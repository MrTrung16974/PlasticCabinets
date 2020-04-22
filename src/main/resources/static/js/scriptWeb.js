$(document).ready(function() {
    // $(window).scroll(function(event) {
    //     var pos_body = $('html,body').scrollTop();
    //     if (pos_body > 20) {
    //         $('div#top-menu').addClass('flex-menu');
    //     } else {
    //         $('div#top-menu').removeClass('flex-menu');
    //     }

    // })
    // ;

    $('div#sub-messenger').hide(0);
    $('div#sub-messenger').delay(3000).show(500);

    $('div#mess').on('click', function () {
        $('div#sub-messenger').show(500);
    });

    $('i#down-mess').on('click', function () {
        $('div#sub-messenger').hide(500);
    });


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
                // window.location.href = "http://localhost:8080/product/cast?id=" + keyword;
            }
        });
    });

});