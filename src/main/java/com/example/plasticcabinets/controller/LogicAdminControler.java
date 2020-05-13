package com.example.plasticcabinets.controller;

import com.example.plasticcabinets.dto.UserDto;
import com.example.plasticcabinets.exception.ResurceNotFoundException;
import com.example.plasticcabinets.model.ImageProduct;
import com.example.plasticcabinets.model.Products;
import com.example.plasticcabinets.model.Users;
import com.example.plasticcabinets.repository.ImageProductRepository;
import com.example.plasticcabinets.repository.ProductsRepository;
import com.example.plasticcabinets.repository.UserRepository;
import com.example.plasticcabinets.service.StoreFileService;
import com.google.gson.Gson;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class LogicAdminControler {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageProductRepository imageProductRepository;

    @Autowired
    StoreFileService storeFileService;

    @Autowired
    ProductApiController productApiController;

    @Autowired
    MockData mockData;

    @PostMapping(value = "/login-page")
    @ResponseBody
    public int loginAdmin(@RequestBody UserDto loginUsers){
        List<Users> lstUsers = userRepository.findAll();
        Users user = null;

//        hast pass
//        String hashPass = BCrypt.hashpw(loginUsers.getPassword(), BCrypt.gensalt(12));

        for(Users u : lstUsers) {
            if(u.getId() == 1) {
                user = u;
            }
        }
        if(user == null) {
            return 4;
        }
        if(!user.getAccount().toLowerCase().equals(loginUsers.getEmail().toLowerCase())) {
            System.out.println("FAIL!");
            return 4;
        }
        return 0;
    }



    //    create image product
    @PostMapping(value = "/image-product")
    @ResponseBody
    public int createImgProduct(@RequestBody ImageProduct imgProduct) {
        if(imgProduct.getImgProduct1() != null) {
            imgProduct.setCreateBy(1);
            imageProductRepository.save(imgProduct);
        }else {
            return 1;
        }
        return 0;

    }

    //    create product
    @PostMapping(value = "/create-product")
    @ResponseBody
    public int createProduct(@RequestBody Products product) {
        if(product.getName() != null && product.getDescription() != null) {
            product.setUserId(1);
            product.setCreateBy(1);
            productsRepository.save(product);
        }else {
            return 4;
        }
        return 0;

    }

//    chuyển sang chi tiết sản phẩm
    @GetMapping("/edit-product/{id}/detail")
    public String editProductDetail(@PathVariable("id") Integer idProduct, Model model) {
        Products product = null;
        for (Products p : mockData.getAllProduct()) {
            if(p.getId() == idProduct) {
                product = p;
            }
        }
        model.addAttribute("product", product);
        model.addAttribute("allImageProduct", mockData.getAllImageProduct());
        return "admin/page/editProduct";
    }

//    Edit product
    @PostMapping("/edit-product/{id}")
    @ResponseBody
    public int editProduct(@PathVariable("id") Integer idProduct,@RequestBody Products product) {
        product.setId(idProduct);
        System.out.println(product);
        Products productModel = productsRepository.findById(idProduct).orElseThrow(() -> new ResurceNotFoundException("Product", "id", idProduct));
        if (product.getDescription() != null && !product.getDescription().isEmpty()) {
            productModel.setName(product.getName());
            productModel.setDescription(product.getDescription());
            productModel.setImgProduct(product.getImgProduct());
            productModel.setNewPrice(product.getNewPrice());
            productModel.setOldPrice(product.getOldPrice());
            productModel.setPromotion(product.getPromotion());
            productModel.setStar(product.getStar());
            productModel.setCategoryId(product.getCategoryId());
            Products newproducts = productsRepository.save(productModel);
        } else {
            return 4;
        }
        return 0;
    }

//    edit image product
    @PostMapping("/image-edit-product/{id}")
    @ResponseBody
    public Integer editImageProduct(@PathVariable("id") Integer idImageProduct, @RequestBody ImageProduct imageProduct) {
        imageProduct.setId(idImageProduct);
        System.out.println(imageProduct);
//        ImageProduct imageProductModel = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        if (imageProduct.getImgProduct1() != null && !imageProduct.getImgProduct1() .isEmpty()) {
            imageProduct.setCreateBy(1);
            imageProductRepository.updateImageProduct(imageProduct.getId(), imageProduct.getImgProduct1(),
                    imageProduct.getImgProduct2(), imageProduct.getImgProduct3(), imageProduct.getImgProduct4()
                    , imageProduct.getImgProduct5());
        } else {
            return 4;
        }
        return 0;
    }

//    delete product
    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Integer idProduct) {
        if(idProduct != null) {
            productsRepository.deleteById(idProduct);
        }else {
            System.out.println("errors");
        }

        return "redirect:/product/deleteProduct";

    }

    //    create user
    @PostMapping(value = "/create-user")
    @ResponseBody
    public int createUser(@Valid @RequestBody Users user) {
        if(user.getName() != null && user.getAccount() != null) {
            String pass = user.getPassword();
            String hashPass = BCrypt.hashpw(pass, BCrypt.gensalt(12));
            user.setPassword(hashPass);
            user.setRoleId(1);
            user.setCreateBy(1);
            userRepository.save(user);
        }else {
            return 4;
        }
        return 0;

    }


    //    chuyển sang chi tiết người dung
    @GetMapping("/edit-user/{id}/detail")
    public String editUserDetail(@PathVariable("id") Integer idUser, Model model) {
        Users user = null;
        String formatDate = null;
        for (Users u : mockData.getAllUser()) {
            if(u.getId() == idUser) {
                user = u;
            }
        }
        try {
            Date date = user.getBirthday();
            // Setting the pattern
            SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
            // myDate is the java.util.Date in yyyy-mm-dd format
            // Converting it into String using formatter
            if(date != null) {
                formatDate = sm.format(date);
//                System.out.println(date1);
//                //Converting the String back to java.util.Date
//                Date formatDate = sm.parse(date1);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("date", formatDate);
        model.addAttribute("user", user);
        return "admin/page/editUser";
    }

    //    Edit User
    @PostMapping("/edit-user/{id}")
    @ResponseBody
    public int editUser(@PathVariable("id") Integer idUser, @Valid @RequestBody Users user) {
        user.setId(idUser);
        System.out.println(user);
        Users userModel = userRepository.findById(idUser).orElseThrow(() -> new ResurceNotFoundException("User", "id", idUser));
        if (user.getAccount() != null && !user.getAccount().isEmpty()) {
            userModel.setName(user.getName());
            userModel.setAccount(user.getAccount());
            userModel.setPassword(user.getPassword());
            userModel.setAccountBank(user.getAccountBank());
            userModel.setAddress(user.getAddress());
            userModel.setUserFace(user.getUserFace());
            userModel.setEmail(user.getEmail());
            userModel.setSex(user.getSex());
            userModel.setBirthday(user.getBirthday());
            userModel.setPhone(user.getPhone());
            Users newUser = userRepository.save(userModel);
        } else {
            return 4;
        }
        return 0;
    }

    //    delete User
    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable("id") Integer idUser) {
        if(idUser != null) {
            userRepository.deleteById(idUser);
        }else {
            System.out.println("errors");
        }
        return "redirect:/product/deleteProduct";
    }

    //    Upload file img
    @PostMapping("/upload")
    @ResponseBody
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        String fileName = "";
        String fileLink = "http://localhost:8080/link/";
        try {
            if(file.isEmpty()) {
                throw new Exception();
            }
            fileName = storeFileService.store(file);
            fileLink += fileName;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return fileLink;
    }
}
