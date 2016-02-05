/**
 * Created by Jeel_Mac on 2/5/16.
 */
public class Product {
    private String name;
    private int levels;
    private Location location;

    public Product(String name, int levels, Location location){
        this.name = name;
        this.levels = levels;
        this.location = location;
    }

    public String getName(){
        return this.name;
    }
    public int getLevels(){
        return this.levels;
    }
    public Location getLocation(){
        return this.location;
    }

    public void removeAmount(int amount){
        this.levels -= amount;
    }
    public void addAmount(int amount){
        this.levels += amount;
    }
}