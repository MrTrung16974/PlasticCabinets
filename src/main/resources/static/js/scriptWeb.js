$(document).ready(function() {

    // hide & show sup mess
    $('div#sub-messenger').delay(3000).show(500);
    $('div#mess').delay(2900).hide(400);

    $('div#mess').on('click', function () {
        $('div#sub-messenger').show(500);
        $('div#mess').hide(400);

    });

    $('i#down-mess').on('click', function () {
        $('div#sub-messenger').hide(500);
        $('div#mess').show(600);
    });

    // hide & show sup menu
    $("a#notifications").mouseenter(function(){
        $('div#sub-menu').show(500);
    });

    $("div#hiden-sub-menu").mouseleave(function(){
        $('div#sub-menu').hide(500);
    });
    $("div#sub-menu").mouseleave(function(){
        $('div#sub-menu').hide(500);
    });

    //evert enter search
    $('#keywordSearch').on('keypress', function (e) {
        if (e.keyCode == 13) {
            let keyword = $("#keywordSearch").val().trim();
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/product/search?keyword="+ keyword,
                processData: false,
                contentType: 'application/json',
                success : function () {
                    window.location.href = "http://localhost:8080/product/search?keyword="+ keyword;
                }
            });
        }
    });

    //evert click search
    $("#searchProduct").on('click', function () {
        let keyword = $("#keywordSearch").val().trim();
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/product/search?keyword="+ keyword,
            processData: false,
            contentType: 'application/json',
            success : function () {
                window.location.href = "http://localhost:8080/product/search?keyword="+ keyword;
            }
        });
    });
    if($("#image-Product-1").attr('src') == '') {
        $("#carousel-item-image-1").remove();
        $("#target-item-image-1").remove();
    }
    if($("#image-Product-2").attr('src') == '') {
        $("#carousel-item-image-2").remove();
        $("#target-item-image-2").remove();
    }
    if($("#image-Product-3").attr('src') == '') {
        $("#carousel-item-image-3").remove();
        $("#target-item-image-3").remove();
    }
    if($("#image-Product-4").attr('src') == '') {
        $("#carousel-item-image-4").remove();
        $("#target-item-image-4").remove();
    }
    if($("#image-Product-5").attr('src') == '') {
        $("#carousel-item-image-5").remove();
        $("#target-item-image-5").remove();
    }

    $("#deleteCastProduct").on('click', function () {
        let keyword = $("#idCastProduct").val();
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/product/delete-cast/"+ keyword,
            processData: false,
            contentType: 'application/json',
            success : function () {
                window.location.reload();
            }
        });
    });

    $("button#btn-pay").on('click', function () {
        let keyword = $("#idCastProduct").val();
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/product/pay?id="+ 1,
            processData: false,
            contentType: 'application/json',
            success : function () {
                window.location.href = "http://localhost:8080/product/pay?id=" + 1;
            }
        });
    });
});