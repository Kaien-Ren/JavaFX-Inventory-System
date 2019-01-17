/*****************
 * @author lethv *
 *****************/

package javafxpractice;

public class Outsourced extends Part {
    
    private
            String companyName;
    
    public
            String getCompanyName(){
                return this.companyName;
            }
            void setCompanyName(String string) {
                this.companyName = string;
            }
            Outsourced(int partIDRes, String partNameRes, double partPriceRes, int partStockRes, int partMinRes, int partMaxRes, String partCompIDRes) {
                this.setPartID(partIDRes);
                this.setName(partNameRes);
                this.setPrice(partPriceRes);
                this.setInStock(partStockRes);
                this.setMin(partMinRes);
                this.setMax(partMaxRes);
                this.setCompanyName(partCompIDRes);
            }
}
