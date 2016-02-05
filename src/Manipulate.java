import java.util.Hashtable;

/**
 * Created by Jeel_Mac on 02/15/16.
 */
public class Manipulate implements InventoryManagementSystem {
    private Hashtable<String, Product> products;
    private Hashtable<String, Location> locations;

    public Manipulate(){
        this.products = new Hashtable<String, Product>();
        this.locations = new Hashtable<String, Location>();
    }

    public Manipulate addProduct(Product product){
        products.put(product.getName(), product);
        return this;
    }
    public Manipulate addLocation(Location location){
        locations.put(location.getName(), location);
        return this;
    }

    public Hashtable<String, Product> getProducts(){
        return this.products;
    }

    public Hashtable<String, Location> getLocation(){
        return this.locations;
    }

    public void view_products(String product_name){
        Product product = this.products.get(product_name);
        System.out.println(product.getName() + " has " + product.getLevels() + " copies left. These copies can be found in " +
                product.getLocation().getName());
    }

    public synchronized PickingResult pickProduct(String productId, int amountToPick){
        Product product = products.get(productId);
        product.removeAmount(amountToPick);

        PickingResult pickingResult = new PickingResult(product);
        return pickingResult;
    }
    public synchronized RestockingResult restockProduct(String productId, int amountToRestock){
        Product product = products.get(productId);
        product.addAmount(amountToRestock);

        RestockingResult restockingResult = new RestockingResult(product);
        return restockingResult;
    }
}