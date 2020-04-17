package com.example.plasticcabinets.controller;

import com.example.plasticcabinets.model.CastProduct;
import com.example.plasticcabinets.model.ImageProduct;
import com.example.plasticcabinets.model.Products;
import com.example.plasticcabinets.repository.CastProductRepository;
import com.example.plasticcabinets.repository.ImageProductRepository;
import com.example.plasticcabinets.repository.ProductsRepository;
import com.example.plasticcabinets.repository.UserRepository;
import com.example.plasticcabinets.service.StoreFileService;
import com.example.plasticcabinets.util.Constant;
import info.debatty.java.stringsimilarity.Levenshtein;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/product")
public class LogicWebController {
    private Levenshtein leven = new Levenshtein();
    private Set<Products> lstSimilarProduct = new HashSet<>();
    private Set<Products> lstCast = new HashSet<>();
    private List<Products> lstCastProduct = new ArrayList<>();

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    CastProductRepository castProductRepository;

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

    //    chuyển sang chi tiết sản phẩm
    @GetMapping("/detail/{id}")
    public String productDetail(@PathVariable("id") Integer idProduct, Model model) {
        Products product = null;
        ImageProduct imageProduct = null;
        String productType = null;
        for (Products p : mockData.getAllProduct()) {
            if(p.getId() == idProduct) {
                product = p;
            }
        }
        for (ImageProduct img : mockData.getAllImageProduct()) {
            if(img.getId() == product.getIdImg()) {
                imageProduct = img;
            }
        }
        lstSimilarProduct.clear();
        for (Products p : mockData.getAllProduct()) {
            if(leven.distance(p.getName(), product.getName()) < 7.0 && lstSimilarProduct.size() <= 8) {
                lstSimilarProduct.add(p);
            }
        }
        switch (product.getCategoryId()) {
            case 1:
                productType = "Tủ trẻ em";
                break;
            case 2:
                productType = "Tủ quần áo";
                break;
            case 3:
                productType = "Tủ đài loan cách sơn";
                break;
            case 4:
                productType = "Tủ quần áo hàn quốc";
                break;
            case 5:
                productType = "Bàn học";
                break;
            case 6:
                productType = "Tủ giày";
                break;
            case 7:
                productType = "Giường và tủ bếp";
                break;
            case 8:
                productType = "Kệ tivi";
                break;
            default:
                productType = "";
                break;

        }
        model.addAttribute("productType", productType);
        model.addAttribute("product", product);
        model.addAttribute("imageProduct", imageProduct);
        model.addAttribute("lstSimilarProduct", lstSimilarProduct);
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "web/page/detail";
    }

    @GetMapping("/search")
    public String productSearch(@RequestParam("keyword") String keyword,
                                @RequestParam(value = "Page", defaultValue = "0") int page, Model model) {
        String mess = null;
        List<Products> lstProduct = productsRepository.searchProduct(keyword);
        Set<Products> lstPageProduct = new HashSet<>();

        int index = page * Constant.PAGE_SIZE;
        int lengthProduct = page * Constant.PAGE_SIZE + Constant.PAGE_SIZE >  lstProduct.size() ?  lstProduct.size() :
                page * Constant.PAGE_SIZE + Constant.PAGE_SIZE;

        for(int i = index; i< lengthProduct; i++) {
            Products product =  lstProduct.get(i);
            lstPageProduct.add(product);
        }
        int totalPage = lstProduct.size() % Constant.PAGE_SIZE != 0 || lstProduct.size() % Constant.PAGE_SIZE == 0
                ? ( lstProduct.size()/Constant.PAGE_SIZE )
                : ( lstProduct.size()/Constant.PAGE_SIZE -1);

        if(lstPageProduct.isEmpty() && lstPageProduct != null) {
            mess = "Không có sản phẩm tồn tại!";
        }
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("lstSimilarProduct", lstPageProduct);
        model.addAttribute("mess", mess);
//        model.addAttribute("lstImageProduct", lstImageProduct);
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "web/page/searchProduct";
    }

    //    save producy in cast
    @GetMapping("/cast/{id}")
    public String productCast(@PathVariable("id") Integer idProduct, Model model) {
        Products product = null;
        CastProduct castProduct = null;
        for (Products p : mockData.getAllProduct()) {
            if(p.getId() == idProduct) {
                product = p;
            }
        }
//        castProduct = castProductRepository.findByCast(product.getId());
        castProductRepository.saveCastProduct(1, 1,
                "Chờ chủ cửa hàng phê duyệt",1, product.getId(), product.getIdImg(), 1);
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "redirect:/product/webHome";
    }

    @RequestMapping("/cast")
    public String Cast(Model model, @RequestParam(value = "id", defaultValue = "0") int id, @RequestParam(value = "Page", defaultValue = "0") int page) {
        lstCastProduct = productsRepository.getCastProduct();

        String mess = null;
        int index = page * Constant.PAGE_SIZE;
        int lengthProduct = page * Constant.PAGE_SIZE + Constant.PAGE_SIZE >  lstCastProduct.size() ?   lstCastProduct.size() :
                page * Constant.PAGE_SIZE + Constant.PAGE_SIZE;

        if(lstCast != null) {
            lstCast.clear();
        }
        for(int i = index; i< lengthProduct; i++) {
            Products product =  lstCastProduct.get(i);
            if(product.getCreateBy() == id) {
                lstCast.add(product);
            }
        }
        int totalPage = lstCastProduct.size() % Constant.PAGE_SIZE != 0 || lstCastProduct.size() % Constant.PAGE_SIZE == 0
                ? ( lstCastProduct.size()/Constant.PAGE_SIZE )
                : ( lstCastProduct.size()/Constant.PAGE_SIZE -1);

        if(lstCast.isEmpty() && lstCast != null) {
            mess = "Không có sản phẩm tồn tại!";
        }

        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("lstCast", lstCast);
        model.addAttribute("mess", mess);
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "web/page/cast";
    }

}
