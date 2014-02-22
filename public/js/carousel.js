$(document).ready( function() {
    $('#myCarousel').carousel({
        interval: false,
        pause: 'hover'
    });

    $.fn.carousel.defaults = {
        interval: false,
        pause: 'hover'
    }

    $('.nav').on('click', 'li a', function() {
        $('.row .nav li').removeClass('active');
        $(this).parent().addClass('active');
    });
});