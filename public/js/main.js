function setupLabel() {
    if ($('.label_check input').length) {
        $('.label_check').each(function(){ 
            $(this).removeClass('c_on');
        });
        $('.label_check input:checked').each(function(){ 
            $(this).parent('label').addClass('c_on');
        });                
    };
    if ($('.label_radio input').length) {
        $('.label_radio').each(function(){ 
            $(this).removeClass('r_on');
        });
        $('.label_radio input:checked').each(function(){ 
            $(this).parent('label').addClass('r_on');
        });
    };
};

$(function(){

    $(function() {
        $.get( "/competence", function(data) {

            _.each(data, function(competence) {
                _.each(competence.elements, function(element) {
                    var levelsObj = _.groupBy(element.indications, "code");
                    levels = _.toArray(levelsObj);
                    element.debutante = levels[0];
                    element.avertie = levels[1];
                    element.resource = levels[2];
                    element.experte = levels[3];
                });
            });

            console.log(data);

            var source   = $("#competences-template").html();
            var template = Handlebars.compile(source);
            var html    = template({'competences': data});
            $("#competences-placeholder").append(html);


            /* page loaded, safe to load other things below */


            $('body').addClass('has-js');

            $('.label_check, .label_radio').click(function(){
                setupLabel();
            });

            setupLabel();
            
            $("#main-progress-bar").progressbar({
          value: 50
        });



            $(".evt-0 .btn-progress-wrapper .progress-bar").progressbar({
                value: 50
            });

            $(".evt-1 .btn-progress-wrapper .progress-bar").progressbar({
                value: 60
            });

            $(".evt-2 .btn-progress-wrapper .progress-bar").progressbar({
                value: 20
            });

            $.fn.carousel.defaults = {
                interval: false,
                pause: 'hover'
            }

            $('#myCarousel').carousel({
                interval: false,
                pause: 'hover'
            });

            $('#myCarousel').on('slid.bs.carousel', function () {
                $(".accordion-wrapper > div").accordion("refresh");
                $(".myInnerCarousel .carousel-inner div").removeClass("active");
                $(".myInnerCarousel .carousel-inner > :first-child").addClass("active");
            });

            $('.myInnerCarousel').carousel({
                interval: false,
                pause: 'hover'
            });
            
            $('.myInnerCarousel').on('slid.bs.carousel', function () {
                setTimeout(function(){
                    $(".accordion-wrapper > div").accordion("refresh");
                },500);
            });

            $('.nav').on('click', 'li a', function() {
                var previousTabClass = $('.row .nav li.active').attr('data-slide-to');
                $('#myCarousel').removeClass('competence-'+previousTabClass);
                $('#myCarousel').addClass('competence-'+$(this).parent().attr('data-slide-to'));
                $('.row .nav li').removeClass('active');
                $(this).parent().addClass('active');
            });

            $("#myCarousel .carousel-inner :first-child").addClass("active");
            $(".myInnerCarousel .carousel-inner :first-child").addClass("active");
            $(".nav-sidebar .nav > :first-child").addClass("active");

            $(".accordion-wrapper > div").accordion({ header: "h3", collapsible: true, active: false });

        });
    });
});