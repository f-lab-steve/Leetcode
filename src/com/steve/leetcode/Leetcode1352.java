package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1352 {

    class ProductOfNumbers {

        List<Integer> products = new ArrayList<>() {{
            add(1);
        }};

        public ProductOfNumbers() {

        }

        public void add(int num) {
            if (num > 0) {
                products.add(products.get(products.size() - 1) * num);
            } else {
                products = new ArrayList<>() {{
                    add(1);
                }};
            }
        }

        public int getProduct(int k) {
            if (products.size() <= k) {
                return 0;
            }
            return products.get(products.size() - 1) / products.get(products.size() - k - 1);
        }

    }

}
