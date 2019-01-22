/*****************
 * @author lethv *
 *****************/

package javafxpractice;

public class Inhouse extends Part {
    
    private
            int machineID;
    
    public
            void setMachineID(int number) {
                this.machineID = number;
            }
            
            int getMachineID() {
                return this.machineID;
            }
            
            Inhouse() {
                
            }
            
            Inhouse(int partIDRes, String partNameRes, double partPriceRes, int partStockRes, int partMinRes, int partMaxRes, int partMachIDRes) {
                this.setPartID(partIDRes);
                this.setName(partNameRes);
                this.setPrice(partPriceRes);
                this.setInStock(partStockRes);
                this.setMin(partMinRes);
                this.setMax(partMaxRes);
                this.setMachineID(partMachIDRes);
            }
}