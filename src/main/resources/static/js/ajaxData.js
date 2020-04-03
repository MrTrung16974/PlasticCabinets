$(document).ready(function () {
    let productImage = $("input.productImage.createProduct");
    let newImageProduct = $("img.newImageProduct");
    for (var i = 0; i < productImage.length; i++) {
        let ImageProduct = productImage[i];
        let newProductImage = newImageProduct[i];
        ImageProduct.addEventListener('change', function () {
            var formData = new FormData();
            formData.append('file', ImageProduct.files[0]);

            $.ajax({
                url: 'http://localhost:8080/product/upload',
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                success: function(data) {
                    newProductImage.src = data;
                    toastr.success('Upload ảnh thành công ', 'Haha!');
                },
                error: function () {
                    toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', 'Inconceivable!');
                }
            });
        });
    }

    $("#btnSaveProductCreate").on('click', function () {
        console.log("OK1");
        var imgProduct = {
            imgProduct1: $("#newImageProduct1").attr('src'),
            imgProduct2: $("#newImageProduct2").attr('src'),
            imgProduct3: $("#newImageProduct3").attr('src'),
            imgProduct4: $("#newImageProduct4").attr('src'),
            imgProduct5: $("#newImageProduct5").attr('src')
        };

        console.log(imgProduct);
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/product/img_product",
            data: JSON.stringify(imgProduct),
            contentType: 'application/json',
            success: function (data) {
                console.log(data);
                window.location.reload();
                toastr.success('Upload thành công ', 'Haha!');
            },
            error: function () {
                alert("Tạo mới sản phẩm thất bại!");
                toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', 'Inconceivable!');
            }
        });
    });

    $("#btnSaveProductCreate").on('click', function () {
        console.log("OK");
        let idProduct = $("#editProductId").val();
        let product = {
            name:$("#createProductName").val().trim(),
            description:$("#createProductDescription").val().trim(),
            imgProduct: $("#newImageProduct1").attr('src'),
            newPrice:$("#createProductNewPrice").val().trim(),
            oldPrice:$("#createProductOldPrice").val().trim(),
            promotion:$("#createProductPromotion").val(),
            star: $("#createProductStar").val()
        };
        console.log(product);
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/product/create",
            data: JSON.stringify(product),
            contentType: 'application/json',
            success: function(data) {
                console.log(data);
                window.location.reload();
                if (data == 0) {
                    toastr.success('Upload product thành công ', 'Haha!');
                }
                if (data == 4) {
                    toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', 'Inconceivable!');
                }
            },
            error: function () {
                alert("Lỗi hệ thống vui lòng quay lại sau");
            }
        });
    });

    $("#btnSaveProductChange").on('click', function () {
        console.log("OK");
        let idProduct = $("#editProductId").val();
        let updateProduct = {
            name:$("#editProductName").val().trim(),
            description:$("#editProductDescription").val().trim(),
            imgProduct: $("#newImageProduct1").attr('src'),
            newPrice:$("#editProductNewPrice").val().trim(),
            oldPrice:$("#editProductOldPrice").val().trim(),
            promotion:$("#editProductPromotion").val(),
            star: $("#editProductStar").val()
        };
        console.log(updateProduct);
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/product/edit/" + idProduct,
            data: JSON.stringify(updateProduct),
            contentType: 'application/json',
            success: function(data) {
                console.log(data);
                window.location.reload();
                if (data == 0) {
                    toastr.success('Upload product thành công ', 'Haha!');
                }
                if (data == 4) {
                    toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', 'Inconceivable!');
                }
            },
            error: function () {
                alert("Lỗi hệ thống vui lòng quay lại sau");
            }
        });
    });

    // $("#btnSaveProductChange").on('click', function () {
    //     console.log("OK1");
    //     let idProduct = $("#editProductId").val();
    //     let imgProduct = {
    //         imgProduct1: $("#newImageProduct1").attr('src'),
    //         imgProduct2: $("#newImageProduct2").attr('src'),
    //         imgProduct3: $("#newImageProduct3").attr('src'),
    //         imgProduct4: $("#newImageProduct4").attr('src'),
    //         imgProduct5: $("#newImageProduct5").attr('src')
    //     };
    //
    //     console.log(imgProduct);
    //     $.ajax({
    //         type: "POST",
    //         url: "http://localhost:8080/product/image-edit/" + idProduct,
    //         data: JSON.stringify(imgProduct),
    //         contentType: 'application/json',
    //         success: function(data) {
    //             console.log(data);
    //             window.location.reload();
    //             if (data == 0) {
    //                 toastr.success('Upload product thành công ', 'Haha!');
    //             }
    //             if (data == 4) {
    //                 toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', 'Inconceivable!');
    //             }
    //         },
    //         error: function () {
    //             alert("Lỗi hệ thống vui lòng quay lại sau");
    //         }
    //     });
    // });
});