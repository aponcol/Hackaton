$(function() {
    pieChart();
});
var svg, arc;
function pieChart() {
    $.when($.get("/repartition"), $.get("/competence"), $.get("/ui/workunit"))
        .done( function(repartitions, competences, unites) {

        var source   = $("#bilan-template").html();
        var template = Handlebars.compile(source);
        var html    = template({'competences': competences[0], 'unites': unites[0]});
        $("#bilan-placeholder").append(html);

       repartitions = transformData(repartitions[0]);


            var width = 800,
                height = 250,
                radius = Math.min(width, height) / 2;

            var color = d3.scale.ordinal()
                .range(["#E83F54", "#FFD41C", "#FCA11D", "#399E40"]);

            var arc = d3.svg.arc()
                .outerRadius(radius - 10)
                .innerRadius(0);

            var pie = d3.layout.pie()
                .sort(null)
                .value(function (d) {
                    return d.num;
                });


            var svg = d3.select("#canvas").append("svg")
                .attr("width", width)
                .attr("height", height)
                .append("g")
                .attr("id", "pieChart")
                .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")");

            var path = svg.selectAll("path")
                .data(pie(repartitions))
                .enter()
                .append("path");

            path.transition()
                .duration(500)
                .attr("fill", function(d, i) { return color(d.data.type); })
                .attr("d", arc)
                .each(function(d) { this._current = d; }); // store the initial angles

            count = 0;
            var legend = svg.selectAll(".legend")
                .data(repartitions).enter()
                .append("g").attr("class", "legend")
                .attr("legend-id", function(d) {
                    return count++;
                })
                .attr("transform", function(d, i) {
                    return "translate(-0," + (-70 + i * 20) + ")";
                })
                .on("click", function() {
                    console.log("#arc-" + $(this).attr("legend-id"));
                    var arc = d3.select("#arc-" + $(this).attr("legend-id"));
                    arc.style("opacity", 0.3);
                    setTimeout(function() {
                        arc.style("opacity", 1);
                    }, 1000);
                });

            legend.append("rect")
                .attr("x", width /2.1)
                .attr("width", 18).attr("height", 18)
                .style("fill", function(d) {
                    return color(d["type"]);
                });

            legend.append("text").attr("x", width / 2.16)
                .attr("y", 9).attr("dy", ".35em")
                .style("text-anchor", "end").text(function(d) {
                    return d["type"];
                });

            $("#competenceFilter").change(function(d) {
                var selected = $('#competenceFilter').find(":selected");
                var competencyId = selected.val();
                $.get("/repartition/competency/" + competencyId, function(repartitions) {
                    repartitions = transformData(repartitions);
                    path.data(pie(repartitions));
                    path.transition().duration(750).attrTween("d", arcTween); // redraw the arcs
                });
            });

// Store the displayed angles in _current.
// Then, interpolate from _current to the new angles.
// During the transition, _current is updated in-place by d3.interpolate.
            function arcTween(a) {
                var i = d3.interpolate(this._current, a);
                this._current = i(0);
                return function(t) {
                    return arc(i(t));
                };
            }
    });

    function transformData(repartitions) {
        repartitions = _.map(repartitions, function(val, name) {
            if (name == "d") {
                return {"type": "Debutante", "num": val.count}
            }
            if (name == "a") {
                return {"type": "Avertie", "num": val.count}
            }
            if (name == "rc") {
                return {"type": "Personne-Resource", "num": val.count}
            }
            if (name == "e") {
                return {"type": "Experte", "num": val.count}
            }
        });

        return repartitions;
    }
}

