package com.example.plasticcabinets.controller;

import com.example.plasticcabinets.model.CastProduct;
import com.example.plasticcabinets.model.Products;
import com.example.plasticcabinets.repository.ImageProductRepository;
import com.example.plasticcabinets.repository.ProductsRepository;
import com.example.plasticcabinets.repository.UserRepository;
import com.example.plasticcabinets.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/product")
public class WebController {
    private List<Products> productOfPage = new ArrayList<>();
    private List<Products> goodProductOfPage = new ArrayList<>();

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageProductRepository imageProductRepository;

    @Autowired
    MockData mockData;

    @RequestMapping("/webHome")
    public String home(Model model,@RequestParam(value = "hot", defaultValue = "1") int hot, @RequestParam(value = "type", defaultValue = "1") int type, @RequestParam(value = "Page",
            defaultValue = "0") int page, @RequestParam(value = "PageGood", defaultValue = "0") int pageGood){
        int index = page * Constant.PAGE_SIZE;
        int lengthProduct = page * Constant.PAGE_SIZE + Constant.PAGE_SIZE >  mockData.getAllProduct().size() ?  mockData.getAllProduct().size() :
                page * Constant.PAGE_SIZE + Constant.PAGE_SIZE;

        productOfPage.clear();
        for(int i = index; i< lengthProduct; i++) {
            Products product =  mockData.getAllProduct().get(i);
            if(type == product.getCategoryId()) {
                productOfPage.add(product);
            }
        }
        int totalPage =  mockData.getAllProduct().size() % Constant.PAGE_SIZE != 0
                ? ( mockData.getAllProduct().size()/Constant.PAGE_SIZE )
                : ( mockData.getAllProduct().size()/Constant.PAGE_SIZE -1);

        int indexGood = pageGood * Constant.PAGE_GOOD_SIZE;
        int lengthProductGood =  pageGood * Constant.PAGE_GOOD_SIZE + Constant.PAGE_GOOD_SIZE > mockData.getAllGoodProduct().size() ?
                mockData.getAllGoodProduct().size() :pageGood * Constant.PAGE_GOOD_SIZE + Constant.PAGE_GOOD_SIZE;
        goodProductOfPage.clear();
        for (int i = indexGood; i < lengthProductGood; i++) {
            Products product = mockData.getAllGoodProduct().get(i);
            switch (hot) {
                case 1:
                    goodProductOfPage.add(product);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("ERROR!");
                    break;
            }
        }

        int totalGoodPage = mockData.getAllGoodProduct().size() % Constant.PAGE_GOOD_SIZE != 0
                ? (mockData.getAllGoodProduct().size()/Constant.PAGE_GOOD_SIZE )
                : (mockData.getAllGoodProduct().size()/Constant.PAGE_GOOD_SIZE -1);


        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("currentGoodPage", pageGood);
        model.addAttribute("totalGoodPage", totalGoodPage);
        model.addAttribute("productOfPage", productOfPage);
        model.addAttribute("goodLstGame", goodProductOfPage);

        model.addAttribute("lstProduct", mockData.getAllProduct());
        model.addAttribute("allImageProduct", mockData.getAllImageProduct());
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "web/index";
    }

    @RequestMapping("/pageDetail")
    public String Detail(Model model) {
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "web/page/detail";
    }

    @RequestMapping("/pageSearch")
    public String Search(Model model) {
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "web/page/searchProduct";
    }

    @RequestMapping("/pageHeader")
    public String Header(Model model) {
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "web/default/header";
    }

    @RequestMapping("/pageCast")
    public String Cast(Model model) {
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "web/page/cast";
    }
}
