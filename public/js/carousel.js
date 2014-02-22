$(document).ready( function() {
    $('#myCarousel').carousel({
        interval: false,
        pause: 'hover'
    });
    
    $('#myCarousel').on('slid.bs.carousel', function () {
        // do something…
        $(".accordion-wrapper > div").accordion("refresh");
      });

    $.fn.carousel.defaults = {
        interval: false,
        pause: 'hover',
    }

    $('.nav').on('click', 'li a', function() {
        var previousTabClass = $('.row .nav li.active').attr('data-slide-to');
        $('#myCarousel').removeClass('competence-'+previousTabClass);
        
        $('.row .nav li').removeClass('active');
        $(this).parent().addClass('active');
        
        
        $('#myCarousel').addClass('competence-'+$(this).parent().attr('data-slide-to'));
        
        //$(".accordion-wrapper > div").accordion("refresh");
    });
});