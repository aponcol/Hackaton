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

        var WIDTH = 600, HEIGHT = 450;

        var SEGMENT = "type";
        var DATA = "num";

        var width = WIDTH,
            height = HEIGHT,
            radius = Math.min(width, height) / 3;

        var color = d3.scale.ordinal()
            .range(["#98abc5", "#6b486b", "#ff8c00", "#a05d56"]);

        arc = d3.svg.arc()
            .outerRadius(radius - 10)
            .innerRadius(0);

        var pie = d3.layout.pie()
            .sort(null)
            .value(function(d) { return d[DATA]; });

        svg = d3.select("#canvas").append("svg")
            .attr("width", width)
            .attr("height", height)
            .append("g")
            .attr("transform", "translate(" + width / 3 + "," + height / 2 + ")");

        var drawD3Document = function(data) {
            data.forEach(function(d) {
                d[DATA] = +d[DATA];
            });
            var g = svg.selectAll(".arc")
                .data(pie(data))
                .enter().append("g")
                .attr("class", "arc");

            var count = 0;

            g.append("path")
                .attr("d", arc)
                .attr("id", function(d) { return "arc-" + (count++); })
                .style("fill", function(d) {
                    return color(d.data[SEGMENT]);
                });
            g.append("text").attr("transform", function(d) {
                return "translate(" + arc.centroid(d) + ")";
            }).attr("dy", ".35em").style("text-anchor", "middle")
                .text(function(d) {
                    return d.data[SEGMENT];
                });

            count = 0;
            var legend = svg.selectAll(".legend")
                .data(data).enter()
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
                .attr("x", width / 2)
                .attr("width", 18).attr("height", 18)
                .style("fill", function(d) {
                    return color(d[SEGMENT]);
                });
            legend.append("text").attr("x", width / 2)
                .attr("y", 9).attr("dy", ".35em")
                .style("text-anchor", "end").text(function(d) {
                    return d[SEGMENT];
                });

            $("#competenceFilter").change(function(d) {
            var selected = $('#competenceFilter').find(":selected");
                var competencyId = selected.val();
                $.get("/repartition/competency/" + competencyId, function(repartitions) {
                    repartitions = transformData(repartitions);
                    g.data(pie(repartitions));
                    g.transition().duration(750).attrTween("d", arcTween); // redraw the arcs

                });
            });


            function arcTween(a) {
                var i = d3.interpolate(this._current, a);
                this._current = i(0);
                return function(t) {
                    return arc(i(t));
                };



            }


        }

        drawD3Document(repartitions);
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
        })

        return repartitions;
    }
}

