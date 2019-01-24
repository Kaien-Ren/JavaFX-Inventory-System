/*****************
 * @author lethv *
 *****************/

package javafxpractice;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    
    private
            ObservableList<Integer> allPartNumberObList = FXCollections.observableArrayList();
            ObservableList<String> allPartNameObList = FXCollections.observableArrayList();
            ObservableList<Integer> allPartInventoryObList = FXCollections.observableArrayList();
            ObservableList<String> allPartPriceObList = FXCollections.observableArrayList();
            
            ObservableList<Integer> allProductNumberObList = FXCollections.observableArrayList();
            ObservableList<String> allProductNameObList = FXCollections.observableArrayList();
            ObservableList<Integer> allProductInventoryObList = FXCollections.observableArrayList();
            ObservableList<String> allProductPriceObList = FXCollections.observableArrayList();
            
            ArrayList<Product> products = new ArrayList<>();
            ArrayList<Part> allParts = new ArrayList<>();
            
    public
            ObservableList<Integer> getAllPartNumberObList() {
                return this.allPartNumberObList;
            }
            
            ObservableList<String> getAllPartNameObList() {
                return this.allPartNameObList;
            }
            
            ObservableList<Integer> getAllPartInventoryObList() {
                return this.allPartInventoryObList;
            }
            
            ObservableList<String> getAllPartPriceObList() {
                return this.allPartPriceObList;
            }
            
            ObservableList<Integer> getAllProductNumberObList() {
                return this.allProductNumberObList;
            }
            
            ObservableList<String> getAllProductNameObList() {
                return this.allProductNameObList;
            }
            
            ObservableList<Integer> getAllProductInventoryObList() {
                return this.allProductInventoryObList;
            }
            
            ObservableList<String> getAllProductPriceObList() {
                return this.allProductPriceObList;
            }
            
            ArrayList<Product> getProductsList() {
                return this.products;
            }
            
            ArrayList<Part> getPartsList() {
                return this.allParts;
            }
            
            void addProduct(Product product) {
                products.add(product);
                updateProductObList();
            }
            
            //** Unknown Bug **//
            boolean removeProduct(int number) {
                boolean returnValue = false;
                for (Product product : products) {
                    if (product.getProductID() == number) {
                        int indexOf = products.indexOf(product);
                        this.products.remove(indexOf);
                    }
                    else {
                        
                    }
                }
                updateProductObList();
                return returnValue;
            }
            
            Product lookUpProduct(int number) {
                for (Product temporaryProduct : products) {
                    if (temporaryProduct.getProductID() == number) {
                        return temporaryProduct;
                    }
                }
                return null;
            }
            
            void updateProduct(int number) {
                
            }
            
            void updateProductObList() {
                allProductNumberObList.clear();
                allProductNameObList.clear();
                allProductInventoryObList.clear();
                allProductPriceObList.clear();
                products.iterator().forEachRemaining((n) -> allProductNumberObList.add(n.getProductID()));
                products.iterator().forEachRemaining((n) -> allProductNameObList.add(n.getName()));
                products.iterator().forEachRemaining((n) -> allProductInventoryObList.add(n.getInStock()));
                products.iterator().forEachRemaining((n) -> allProductPriceObList.add("$ " + Double.toString(n.getPrice())));
            }
            
            void addPart(Part part){
                allParts.add(part);
                updatePartObList();
            }
            
            boolean deletePart(Part part) {
                boolean returnValue = allParts.remove(part);
                updatePartObList();
                return returnValue;
            }
            
            Part lookUpPart(int number) {
                for (Part temporaryPart : allParts) {
                    if (temporaryPart.getPartID() == number) {
                        return temporaryPart;
                    }
                }
                return null;
            }
            
            Inhouse lookUpInhouse(int number) {
                for (Part temporaryPart : allParts) {
                    if (temporaryPart.getPartID() == number) {
                        return (Inhouse) temporaryPart;
                    }
                }
                return null;
            }
            
            Outsourced lookUpOutsourced(int number) {
                for (Part temporaryPart : allParts) {
                    if (temporaryPart.getPartID() == number) {
                        return (Outsourced) temporaryPart;
                    }
                }
                return null;
            }
            
            void updatePart(int number) {
                
            }
            
            void updatePartObList() {
                allPartNumberObList.clear();
                allPartNameObList.clear();
                allPartInventoryObList.clear();
                allPartPriceObList.clear();
                allParts.iterator().forEachRemaining((n) -> allPartNumberObList.add(n.getPartID()));
                allParts.iterator().forEachRemaining((n) -> allPartNameObList.add(n.getName()));
                allParts.iterator().forEachRemaining((n) -> allPartInventoryObList.add(n.getInStock()));
                allParts.iterator().forEachRemaining((n) -> allPartPriceObList.add("$ " + Double.toString(n.getPrice())));
            }
            
            boolean isOutsourced(Part part) {
                if (part instanceof Outsourced) {
                    return true;
                }
                else {
                    return false;
                }
            }
            
            Inventory() {
                
            }
}
