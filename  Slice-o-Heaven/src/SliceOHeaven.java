public class  SliceOHeaven {
    public String storeName;
    public String storeAddress;
    public String storeMenu;
    public String storeEmail;
    public long storePhone;
    
    private String orderID;
    private String pizzaIngredients;
    private String pizzaPrice;
    private String sides;
    private String drinks;
    private double orderTotal;
     
public void takeOrder(String id, String Price, String Ingredients, String Sides, String Drinks, double total){
    orderID = id;
    pizzaIngredients = Ingredients;
    pizzaPrice = Price;
    sides = Sides;
    drinks = Drinks;
    orderTotal = total;

    System.out.println("Order accepted!");

    System.out.println("Order is being prepared.");

    try{
        Thread.sleep(5000);
    }catch (InterruptedException e){
        System.out.println("Order is ready for pickup!");
    }
        System.out.println("Your order is ready!");

        printReceipt();
}
    private void printReceipt(){
        System.out.println("********RECEIPT********");
        System.out.println("Order ID:" + orderID);
        System.out.println("Price:" +pizzaPrice);
        System.out.println("Ingredients:" +pizzaIngredients);
        System.out.println("Sides:" +sides);
        System.out.println("Drinks:" +drinks);
        System.out.println("Order Total:" +orderTotal);
    
    }

public void makePizza(String Ingredients, String Sides, String Drinks) {
    pizzaIngredients = Ingredients;
    sides = Sides;
    drinks = Drinks;
}

}

