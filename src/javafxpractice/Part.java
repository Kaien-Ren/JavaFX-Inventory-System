/*****************
 * @author lethv *
 *****************/

package javafxpractice;

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
            Part() {
                
            }
            Part(int partIDRes, String partNameRes, double partPriceRes, int partStockRes, int partMinRes, int partMaxRes) {
                this.setPartID(partIDRes);
                this.setName(partNameRes);
                this.setPrice(partPriceRes);
                this.setInStock(partStockRes);
                this.setMin(partMinRes);
                this.setMax(partMaxRes);
            }
}
