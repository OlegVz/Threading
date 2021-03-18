package com.hybris.internship.threadSafetyWithCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {

//    private List<Product> soldProductsList = new ArrayList<>();
    private List<Product> soldProductsList = new CopyOnWriteArrayList<>();
    private List<Product> purchasedProductsList = new ArrayList();

    public void populatedSoldProducts() {
        for (int i = 0; i < 1000; i++) {
            Product prod = new Product(i, "test_product_" + i);
            soldProductsList.add(prod);
            System.out.println("ADDED: " + prod);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displaySoldProducts() {
        for (Product product : soldProductsList) {
            System.out.println("PRINTING THE SOLD: " + product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
