$(document).ready(function() {
    var temp = 1;
    var minLeft = $("div.left-content");
    var minMenu = $("div#left-content div.menu");
    var leftMenu = $("div.full-width div.left-content div.menu>ul li");
    var itemMenu = $(".left-more");
    var titleItem = $(".title-item");
    var title = $(".sidebar-heading.title-list")
    var spanItem = $("div.full-width div.left-content div.menu>ul li>a>span");
    var titleIcon = $(".frist-list");
    var marginTop = $(".sidebar-divider");
    var rightContent = $(".right-content");
    var titleItem2 = $(".title-item-2");
    var supMenu = $("ul.supMenu");
    var btnMenu = $("button#btn-min-Menu>i");
    $("button#btn-min-Menu").click(function() {
        temp *= (-1);
        minLeft.toggleClass("min-max-width");
        minMenu.toggleClass("min-max-width");
        leftMenu.toggleClass("left-menu");
        itemMenu.toggleClass("item-menu");
        titleItem.toggleClass("item-menu");
        title.toggleClass("min-font");
        titleIcon.toggleClass("big-font");
        marginTop.toggleClass("marginTop");
        rightContent.toggleClass("rightContent");
        supMenu.toggleClass("tran-Menu");
        titleItem2.toggleClass("min-font");
        spanItem.toggleClass("displayBlock");
        if (temp == -1) {
            btnMenu.attr("class", "fas fa-chevron-right");
        } else {
            btnMenu.attr("class", "fas fa-chevron-left");
        }
    });
});