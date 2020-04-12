$(document).ready(function() {
    // $(window).scroll(function(event) {
    //     var pos_body = $('html,body').scrollTop();
    //     if (pos_body > 20) {
    //         $('div#top-menu').addClass('flex-menu');
    //     } else {
    //         $('div#top-menu').removeClass('flex-menu');
    //     }

    // });
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

});