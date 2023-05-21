package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductService {

    List<Product> products = new ArrayList<Product>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getProduct(String name){
        for(Product p : products){
            if(p.getName().equals(name))
                return p;
        }

        return null;
    }

    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<Product>();

        for(Product p : products){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();
            if(name.contains(str) || type.contains(str) || place.contains(str))
                prods.add(p);
        }
        return prods;

    }
    // ADDED BY FAIZAL ATHANIYA
    public List<Product> getProductsByPlaces(String black_table) {
        return products.stream().filter(product -> product.getPlace().equals(black_table)).collect(Collectors.toList());
    }

    public List<Product> getProductsByExpiredWarranty() {
        return products.stream().filter(product -> product.getWarranty()<=new Date().getYear()+1900).collect(Collectors.toList());
    }
}
