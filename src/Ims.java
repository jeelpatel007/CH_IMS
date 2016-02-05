import java.util.Scanner;

/**
 * Created by Jeel_Mac on 02/05/16.
 */
public class Ims {
    public static Manipulate mn = new Manipulate();


    public static void main(String args[]) {
        new Thread(new runner()).start();
    }

    static class runner implements Runnable {
        public void run(){
            int choice = 0;;

            while (choice != 5) {
                Scanner in = new Scanner(System.in);
                System.out.println("Please pick an option");
                System.out.println("1 = Picking out an product");
                System.out.println("2 = Restocking out an product");
                System.out.println("3 = View an product");
                System.out.println("4 = Add a product");
                System.out.println("5 = Exit system");
                choice = Integer.parseInt(in.nextLine());
                mn = executor(choice);
            }
        }
    }

    public static Manipulate executor(int choice){
        String productId;
        int amountToPick;
        int amountToRestock;
            switch (choice) {
                case 1:
                    productId = check_if_product_exists(mn);
                    amountToPick = check_if_enough_product(productId, mn);
                    PickingResult pickingResult = mn.pickProduct(productId, amountToPick);

                    System.out.println("The number of " + pickingResult.getProduct().getName() + "'s left is " +
                            pickingResult.getProduct().getLevels());
                    System.out.println(pickingResult.getProduct().getName() + " can be found in " +
                            pickingResult.getProduct().getLocation().getName());

                    System.out.println();
                    break;
                case 2:
                    productId = check_if_product_exists(mn);
                    amountToRestock = how_much_to_stock();

                    RestockingResult restockingResult = mn.restockProduct(productId,amountToRestock);

                    System.out.println("The number of " + restockingResult.getProduct().getName() + "'s left is "
                            + restockingResult.getProduct().getLevels());
                    System.out.println(restockingResult.getProduct().getName() + " can be found in " +
                            restockingResult.getProduct().getLocation().getName());

                    System.out.println();
                    break;
                case 3:
                    productId = check_if_product_exists(mn);
                    mn.view_products(productId);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Enter the name of the Product:");
                    Scanner in = new Scanner(System.in);
                    Scanner inn= new Scanner(System.in);
                    String pname= in.nextLine();
                    System.out.println("Enter the quantity of the Product available:");
                    int quant= in.nextInt();
                    System.out.println("Enter the location of the Product:");
                    String location= inn.nextLine();
                    Location loc= new Location(location);
                    Product tempProduct = new Product(pname,quant,loc);
                    mn.addLocation(loc);
                    mn.addProduct(tempProduct);
                    System.out.println("product added.");
                    break;
                case 5:
                    System.out.println("Thank you for using our system");
                    System.out.println();
                    break;
            }
        return mn;
    }

    public static String check_if_product_exists(Manipulate mn){
        Scanner in = new Scanner(System.in);
        boolean flag;
        flag = true;
        String productId = "";

        while (flag) {
            System.out.println("Enter which product you want");
            productId = in.nextLine();
            if(mn.getProducts().containsKey(productId)){
                flag = false;
            } else {
                System.out.println("That product is not in the Inventory");
            }
        }
        return productId;
    }

    public static int check_if_enough_product(String productId, Manipulate mn){
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        Product product = mn.getProducts().get(productId);

        while (flag) {
            System.out.println("Enter how many of the products you want");
            String amountToPickString = in.nextLine();
            if(isInteger(amountToPickString)) {
                int amountToPick = Integer.parseInt(amountToPickString);
                if (amountToPick <= product.getLevels()) {
                    return amountToPick;
                } else {
                    System.out.println("Not enough " + product.getName() + "'s, thus you can not order this quantity");
                    System.out.println("Please re-enter the amount that you would like");
                }
            }  else {
                System.out.println("That is not a valid number");
            }
        }
        return -1;
    }

    public static int how_much_to_stock(){
        Scanner in = new Scanner(System.in);
        boolean flag;
        flag = true;

        while (flag) {
            System.out.println("Enter how many of the products you want");
            String amountToRestock = in.nextLine();
            if(isInteger(amountToRestock)) {
                return Integer.parseInt(amountToRestock);
            } else {
                System.out.println("That is not a valid number");
            }
        }
        return -1;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        if ( Integer.parseInt(s) < 0 ){
            return false;
        }
        return true;
    }
}
