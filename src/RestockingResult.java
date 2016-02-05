/**
 * Created by Jeel_Mac on 2/5/16.
 */
public class RestockingResult {
    private Product product;

    public RestockingResult(Product product){
        this.product = product;
    }

    public Product getProduct(){
        return this.product;
    }
}