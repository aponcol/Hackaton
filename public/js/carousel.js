$(function() {

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
        $("#myInnerCarousel .carousel-inner div").removeClass("active");
        $("#myInnerCarousel .carousel-inner > :first-child").addClass("active");
    });

    $('#myInnerCarousel').carousel({
        interval: false,
        pause: 'hover'
    });

    $('.nav').on('click', 'li a', function() {
        var previousTabClass = $('.row .nav li.active').attr('data-slide-to');
        $('#myCarousel').removeClass('competence-'+previousTabClass);
        $('#myCarousel').addClass('competence-'+$(this).parent().attr('data-slide-to'));
        $('.row .nav li').removeClass('active');
        $(this).parent().addClass('active');

    });
});