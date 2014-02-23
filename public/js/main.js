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
    $('body').addClass('has-js');
    $('.label_check, .label_radio').click(function(){
        setupLabel();
    });
    setupLabel();
    
    $(function() {
//        $("#progressbar1").progressbar({
//          value: 50
//        });
//        $("#progressbar2").progressbar({
//          value: 60
//        });
//        $("#progressbar3").progressbar({
//          value: 20
//        });

        $(".evt-0 .btn-progress-wrapper .progress-bar").progressbar({
            value: 50
        });
        
        $(".evt-1 .btn-progress-wrapper .progress-bar").progressbar({
            value: 60
        });
        
        $(".evt-2 .btn-progress-wrapper .progress-bar").progressbar({
            value: 20
        });
        
        $(".accordion-wrapper > div").accordion({ header: "h3", collapsible: true, active: false });

        $.get( "/competence", function(data) {
            console.log(data);
        });
    });
    
});