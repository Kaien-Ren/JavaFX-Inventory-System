/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxpractice;

import java.util.*;

/**
 *
 * @author lethv
 */

public class Product {
    
    private
            ArrayList<Part> associatedParts = new ArrayList<>();
            int productID;
            String name;
            double price;
            int inStock;
            int min;
            int max;
    
    public
            ArrayList<Part> getAssociatedPartsList() {
                return this.associatedParts;
            }
            void setName(String string) {
                this.name = string;
            }
            String getName() {
                return this.name;
            }
            void setPrice(double number) {
                this.price = number;
            }
            double getPrice() {
                return this.price;
            }
            void setInStock(int number) {
                this.inStock = number;
            }
            int getInStock() {
                return this.inStock;
            }
            void setMin(int number) {
                this.min = number;
            }
            int getMin() {
                return this.min;
            }
            void setMax(int number) {
                this.max = number;
            }
            int getMax() {
                return this.max;
            }
            void addAssociatedPart(Part part) {
                associatedParts.add(part);
            }
            boolean removeAssociatedPart(Part part) {
                return associatedParts.remove(part);
            }
            boolean removeAssociatedPart(int number) {
                return removeAssociatedPart(lookUpAssociatedPart(number));
            }
            Part lookUpAssociatedPart(int number) {
                while (associatedParts.iterator().hasNext()) {
                    Part temporaryPart = associatedParts.iterator().next();
                    if (number == temporaryPart.getPartID()) {
                        return temporaryPart;
                    }
                }
                Part errorPart = new Part();
                return errorPart;
            }
            void setProductID(int number) {
                this.productID = number;
            }
            int getProductID() {
                return this.productID;
            }
}
