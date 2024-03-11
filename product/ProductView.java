package com.rod.api.product;

import com.rod.api.common.UtilService;
import com.rod.api.common.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductView {
    public static void main(String[] args) {

        UtilService util = UtilServiceImpl.getInstance();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            products.add(Product.builder()
                    .pno(i)
                    .name(util.createRandomName())
                    .company(util.createRandomCompany())
                    .price(util.createRandomInteger(1000,10000))
                    .build()
            );
        }

        products.forEach(i -> {
            System.out.println(i.toString());
        });
    }
}
