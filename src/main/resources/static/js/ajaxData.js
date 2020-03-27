$(document).ready(function () {
   $("#createProductImage").on('change', function () {
        var formData = new FormData();
        formData.append('file', $('#createProductImage')[0].files[0]);

        $.ajax({
           url: 'http://localhost:8080/upload',
           type: 'POST',
           data: formData,
           processData: false,
           contentType: false,
           success: function(data) {
               $("#newImageProduct").attr("src", data);
               toastr.success('Upload ảnh thành công ', 'Haha!');
           },
            error: function () {
                toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', 'Inconceivable!');
            }
        });
   });

   $("#btnSaveProductCreate").on('click', function () {
       console.log("OK");
        var product = {
            name:$("#createProductName").val().trim(),
            image: $("#imageProduct").attr('src'),
            description:$("#createProductDescription").val(),
            newPrice:$("#createProductNewPrice").val(),
            oldPrice:$("#createProductOldPrice").val(),
            productPromotion:$("#createProductPromotion").val(),
            star: $("#productStar").val()
        };

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/product",
            data: JSON.stringify(product),
            contentType: 'application/json',
            success: function(data) {
                console.log(data);

                if(data == 0) {
                    window.location.reload();
                    toastr.success('Upload thành công ', 'Haha!');
                }else if(data==1) {
                    alert("Tạo mới sản phẩm thất bại!");
                }
            }
            });
   });
});