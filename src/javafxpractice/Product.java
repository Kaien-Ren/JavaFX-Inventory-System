/*****************
 * @author lethv *
 *****************/

package javafxpractice;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {
    
    private
            ObservableList<Integer> associatedPartNumberObList = FXCollections.observableArrayList();
            ObservableList<String> associatedPartNameObList = FXCollections.observableArrayList();
            ObservableList<Integer> associatedPartInventoryObList = FXCollections.observableArrayList();
            ObservableList<String> associatedPartPriceObList = FXCollections.observableArrayList();
            
            ArrayList<Part> associatedParts = new ArrayList<>();
    
            int productID;
            String name;
            double price;
            int inStock;
            int min;
            int max;
    
    public
            ObservableList<Integer> getAssociatedPartNumberObList() {
                return this.associatedPartNumberObList;
            }
            
            ObservableList<String> getAssociatedPartNameObList() {
                return this.associatedPartNameObList;
            }
            
            ObservableList<Integer> getAssociatedPartInventoryObList() {
                return this.associatedPartInventoryObList;
            }
            
            ObservableList<String> getAssociatedPartPriceObList() {
                return this.associatedPartPriceObList;
            }
                    
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
                this.getAssociatedPartNumberObList().add(part.getPartID());
                this.getAssociatedPartNameObList().add(part.getName());
                this.getAssociatedPartInventoryObList().add(part.getInStock());
                this.getAssociatedPartPriceObList().add("$ " + Double.toString(part.getPrice()));
            }
            
            void addAssociatedParts (ArrayList<Part> partsList) {
                for (Part temporaryPart : this.associatedParts) {
                    this.addAssociatedPart(temporaryPart);
                }
            }
            
            boolean removeAssociatedPart(Part part) {
                return associatedParts.remove(part);
            }
            
            boolean removeAssociatedPart(int number) {
                return removeAssociatedPart(lookUpAssociatedPart(number));
            }
            
            Part lookUpAssociatedPart(int number) {
                for (Part temporaryPart : this.associatedParts) {
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
            
            Product(int productIDRes) {
                this.setProductID(productIDRes);
            }
            
            Product(int productIDRes, String productNameRes, double productPriceRes, int productStockRes, int productMinRes, int productMaxRes, Part associatedPartRes) {
                this.setProductID(productIDRes);
                this.setName(productNameRes);
                this.setPrice(productPriceRes);
                this.setInStock(productStockRes);
                this.setMin(productMinRes);
                this.setMax(productMaxRes);
                this.addAssociatedPart(associatedPartRes);
            }
            
            Product(int productIDRes, String productNameRes, double productPriceRes, int productStockRes, int productMinRes, int productMaxRes, ArrayList<Part> associatedPartListRes) {
                this.setProductID(productIDRes);
                this.setName(productNameRes);
                this.setPrice(productPriceRes);
                this.setInStock(productStockRes);
                this.setMin(productMinRes);
                this.setMax(productMaxRes);
                this.addAssociatedParts(associatedPartListRes);
            }
}