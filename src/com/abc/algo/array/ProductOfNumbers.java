package com.abc.algo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2025/9/8 22:07
 * @Version 1.0
 */
public class ProductOfNumbers {

    private List<Integer> product;

    public ProductOfNumbers() {
        product = new ArrayList<>();
        product.add(1);
    }

    public void add(int num) {
        if (num == 0){
            product.clear();
            product.add(1);
            return;
        }
        product.add(product.get(product.size()-1) *num);
    }

    public int getProduct(int k) {
        int size = product.size();
        if (k > size -1){
            return 0;
        }
        return product.get(size-1) / product.get(size-1-k);
    }


    public List<Integer> getProductList() {
        return product;
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        System.out.println(productOfNumbers.getProduct(2));
        System.out.println(productOfNumbers.getProduct(3));
        System.out.println(productOfNumbers.getProduct(4));
        productOfNumbers.add(8);
        System.out.println(productOfNumbers.getProduct(2));

        System.out.println(productOfNumbers.getProductList());
    }

}
