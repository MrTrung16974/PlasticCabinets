$(document).ready(function() {
    // content
    let createProduct = $("#createProduct");
    let createUser = $("#createUser");
    let deleteProduct = $("#deleteProduct");
    let deleteUser = $("#deleteUser");
    let editProduct = $("#editProduct");
    let editUser = $("#editUser");
    let home = $("#content");

//    function
    $("#home").click(function () {
        home.attr("style", "block");
        createProduct.attr("style", "display: none");
        createUser.attr("style", "display: none");
        deleteProduct.attr("style", "display: none");
        deleteUser.attr("style", "display: none");
        editProduct.attr("style", "display: none");
        editUser.attr("style", "display: none");
    });
    $("#btnCreateProduct").click(function () {
        home.attr("style", "display: none;");
        createProduct.attr("style", "display: block;");
        createUser.attr("style", "display: none;");
        deleteProduct.attr("style", "display: none;");
        deleteUser.attr("style", "display: none;");
        editProduct.attr("style", "display: none;");
        editUser.attr("style", "display: none;");
    });

    $("#btnCreateUser").click(function () {
        home.attr("style", "display: none");
        createProduct.attr("style", "display: none");
        createUser.attr("style", "display: block");
        deleteProduct.attr("style", "display: none");
        deleteUser.attr("style", "display: none");
        editProduct.attr("style", "display: none");
        editUser.attr("style", "display: none");
    });

    $("#btnEditProduct").click(function () {
        console.log("OK");
        home.attr("style", "display: none");
        createProduct.attr("style", "display: none");
        createUser.attr("style", "display: none");
        deleteProduct.attr("style", "display: none");
        deleteUser.attr("style", "display: none");
        editProduct.attr("style", "display: block");
        editUser.attr("style", "display: none");
    });

    $("#btnEditUser").click(function () {
        home.attr("style", "display: none");
        createProduct.attr("style", "display: none");
        createUser.attr("style", "display: none");
        deleteProduct.attr("style", "display: none");
        deleteUser.attr("style", "display: none");
        editProduct.attr("style", "display: none");
        editUser.attr("style", "display: block");
    });

    $("#btnDeleteProduct").click(function () {
        home.attr("style", "display: none");
        createProduct.attr("style", "display: none");
        createUser.attr("style", "display: none");
        deleteProduct.attr("style", "display: block");
        deleteUser.attr("style", "display: none");
        editProduct.attr("style", "display: none");
        editUser.attr("style", "display: none");
    });

    $("#btnDeleteUser").click(function () {
        home.attr("style", "display: none");
        createProduct.attr("style", "display: none;");
        createUser.attr("style", "display: none;");
        deleteProduct.attr("style", "display: none;");
        deleteUser.attr("style", "display: block;");
        editProduct.attr("style", "display: none;");
        editUser.attr("style", "display: none;");
    });
});