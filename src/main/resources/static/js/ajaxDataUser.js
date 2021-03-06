$(document).ready(function () {
    let userSex = $("#UserSex").val();
    if(userSex == 'true') {
        $("#createUserSexMale").attr("checked", "checkedchecked");
    }else {
        $("#createUserSexFemale").attr("checked", "checked");
    }
//    Start User
    $("#btnSaveUserCreate").on('click', function () {
        let sex = $("input[name='createUserSex']:checked").val();
        console.log(sex);
        let user = {
            name: $("#createUserName").val().trim(),
            account: $("#createUserAccount").val().trim(),
            password: $("#createUserPassword").val().trim(),
            accountBank: $("#createUserAccountBank").val().trim(),
            address: $("#createUserAddress").val().trim(),
            userFace: $("#UserFace").attr('src'),
            email: $("#createUserEmail").val().trim(),
            sex: sex,
            birthday: $("#createUserBirthday").val().trim(),
            phone: $("#createUserPhone").val()
        };
        console.log(user);
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/product/create-user",
            data: JSON.stringify(user),
            contentType: 'application/json',
            success: function (data) {
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

    $("#btnSaveUserEdit").on('click', function () {
        console.log("OK");
        let idUser = $("#editProductId").val();
        let updateUser = {
            name: $("#createUserName").val().trim(),
            account: $("#createUserAccount").val().trim(),
            password: $("#createUserPassword").val().trim(),
            accountBank: $("#createUserAccountBank").val().trim(),
            address: $("#createUserAddress").val().trim(),
            userFace: $("#UserFace").attr('src'),
            email: $("#createUserEmail").val().trim(),
            sex: $("input[name='createUserSex']:checked").val(),
            birthday: $("#createUserBirthday").val().trim(),
            phone: $("#createUserPhone").val()
        };
        console.log(updateUser);
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/product/edit-user/" + idUser,
            data: JSON.stringify(updateUser),
            contentType: 'application/json',
            success: function (data) {
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


    $("#btnLoginAccount").on('click', function () {
        let loginUsers = {
            email: $("#loginAccount").val().trim(),
            password: $("#loginPassword").val().trim()
        };
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/product/login-page",
            data: JSON.stringify(loginUsers),
            contentType: 'application/json',
            success: function (data) {
                console.log(data);
                if (data == 0) {
                    alert("Thành công");
                    toastr.success('Thành công ', 'Haha!');
                    window.location.href = "http://localhost:8080/product/home";
                }
                if (data == 4) {
                    alert("Bạn nhập sai tai khoản hoặc mật khẩu");
                    toastr.error('Bạn nhập sai tai khoản hoặc mật khẩu', 'Inconceivable!');
                    window.location.href = "http://localhost:8080/product/login";
                }
            },
            error: function () {
                alert("Lỗi hệ thống vui lòng quay lại sau");
            }
        });
    });

    $("#btnRegistrationAccount").on('click', function () {
        let sex = $("input[name='createUserSex']:checked").val();
        console.log(sex);
        let user = {
            name: $("#createUserName").val().trim(),
            account: $("#createUserAccount").val().trim(),
            password: $("#createUserPassword").val().trim(),
            accountBank: $("#createUserAccountBank").val().trim(),
            address: $("#createUserAddress").val().trim(),
            userFace: $("#UserFace").attr('src'),
            email: $("#createUserEmail").val().trim(),
            sex: $("input[name='createUserSex']:checked").val(),
            birthday: $("#createUserBirthday").val().trim(),
            phone: $("#createUserPhone").val()
        };
        console.log(user);
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/product/login-page",
            data: JSON.stringify(user),
            contentType: 'application/json',
            success: function (data) {
                console.log(data);
                window.location.reload();
                if (data == 0) {
                    toastr.success('Upload product thành công ', 'Haha!');
                    window.location.href = "http://localhost:8080/product/home";
                }
                if (data == 4) {
                    toastr.error('Bạn nhập sai tai khoản hoặc mật khẩu', 'Inconceivable!');
                    window.location.href = "http://localhost:8080/product/login";
                }
            },
            error: function () {
                alert("Lỗi hệ thống vui lòng quay lại sau");
            }
        });
    });
});