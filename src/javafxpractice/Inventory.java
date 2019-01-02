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

public class Inventory {
    
    private
            ArrayList<Product> products = new ArrayList<>();
            ArrayList<Part> allParts = new ArrayList<>();
            
    public
            void addProduct(Product product) {
                //add product to arraylist
            }
            boolean removeProduct(int number) {
                //go through arraylist
                //if number is found
                //remove associated product
                //return true
                //if number is not found
                //return false
                return true;
            }
            Product lookUpProduct(int number) {
                //go through arraylist
                //if number is found
                //return associated product
                //if number is not found
                //???
                Product temporaryProduct = new Product();
                return temporaryProduct;
            }
            void updateProduct(int number) {
                //go through arraylist
                //if number is found
                //update associated product
            }
            void addPart(Part part){
                //add part to the arraylist
            }
            boolean deletePart(Part part) {
                //go through arraylist
                //if part is found
                //delete part
                //return true
                //if part is not found
                //return false
                return true;
            }
            Part lookUpPart(int number) {
                //go through arraylist
                //if associated part is found
                //return part
                //if associated part is not found
                //???
                Part temporaryPart = new Part();
                return temporaryPart;
            }
            void updatePart(int number) {
                //go through arraylist
                //if associated part is found
                //update part
            }
}
