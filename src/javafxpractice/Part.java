/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxpractice;

/**
 *
 * @author lethv
 */

public class Part {
    
    private
            int partID;
            String name;
            double price;
            int inStock;
            int min;
            int max;
    
    public
            void setName(String string) {
                this.name = string;
            }
            
            String getName(){
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
            
            void setPartID(int number) {
                this.partID = number;
            }
            
            int getPartID(){
                return this.partID;
            }
}
