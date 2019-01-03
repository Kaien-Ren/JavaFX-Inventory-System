/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxpractice;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author lethv
 */

public class Inventory {
    
    private
            ArrayList<Product> products = new ArrayList<>();
            ArrayList<Part> allParts = new ArrayList<>();
            
    public
            ArrayList<Product> getProductsList() {
                return this.products;
            }
            ArrayList<Part> getPartsList() {
                return this.allParts;
            }
            void addProduct(Product product) {
                products.add(product);
            }
            boolean removeProduct(int number) {
                return products.remove(lookUpProduct(number));
            }
            Product lookUpProduct(int number) {
                while (products.iterator().hasNext()) {
                    Product temporaryProduct = products.iterator().next();
                    if (number == temporaryProduct.getProductID()) {
                        return temporaryProduct;
                    }
                }
                Product errorProduct = new Product();
                return errorProduct;
            }
            void updateProduct(int number) {
                removeProduct(number);
                addProduct(lookUpProduct(number));
            }
            void addPart(Part part){
                allParts.add(part);
            }
            boolean deletePart(Part part) {
                return allParts.remove(part);
            }
            Part lookUpPart(int number) {
                while (allParts.iterator().hasNext()) {
                    Part temporaryPart = allParts.iterator().next();
                    if (number == temporaryPart.getPartID()) {
                        return temporaryPart;
                    }
                }
                Part errorPart = new Part();
                return errorPart;
            }
            void updatePart(int number) {
                deletePart(lookUpPart(number));
                addPart(lookUpPart(number));
            }
}
