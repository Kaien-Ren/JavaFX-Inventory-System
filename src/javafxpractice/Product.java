/*****************
 * @author lethv *
 *****************/

package javafxpractice;

import java.util.*;

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
                for (Part temporaryPart : associatedParts) {
                    if (temporaryPart.getPartID() == number) {
                        return temporaryPart;
                    }
                }
                return null;
            }
            
            void setProductID(int number) {
                this.productID = number;
            }
            
            int getProductID() {
                return this.productID;
            }
            
            Product(int productIDRes, String productNameRes, double productPriceRes, int productStockRes, int productMinRes, int productMaxRes) {
                this.setProductID(productIDRes);
                this.setName(productNameRes);
                this.setPrice(productPriceRes);
                this.setInStock(productStockRes);
                this.setMin(productMinRes);
                this.setMax(productMaxRes);
            }
}