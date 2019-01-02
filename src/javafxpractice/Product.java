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
            ArrayList<Part> associatedParts = new ArrayList<Part>();
            int productID;
            String name;
            double price;
            int inStock;
            int min;
            int max;
    
    public
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
                //add part to ArrayList
            }
            boolean removeAssociatedPart(int number) {
                //if found
                //remove part from ArrayList
                //return true
                //if not found
                //return false
                return true;
            }
            Part lookUpAssociatedPart(int number) {
                //go through ArrayList
                //check if "number" is equal to "productID"
                //if found
                //return associated part
                Part temporaryPart = new Part();
                return temporaryPart;
            }
            void setProductID(int number) {
                this.productID = number;
            }
            int getProductID() {
                return this.productID;
            }
}
