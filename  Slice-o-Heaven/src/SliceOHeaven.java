public class  SliceOHeaven {
    public final String DEF_ORDER_ID = "DEF-SOH-099";
    public final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public final double DEF_ORDER_TOTAL = 15.00;

    public String storeName;
    public String storeAddress;
    public String storeMenu;
    public String storeEmail;
    public long storePhone;
    public String pizzaPrice;
    
    private String orderID;
    private String pizzaIngredients;
    private String sides;
    private String drinks;
    private double orderTotal;

    public int cvv;
    public String cardNumber;
    public String expiryDate;
    public int firstCardDigit;
    public int lastFourDigits;
    public String cardNumberToDisplay;
    private String cardLength = new String("14");
    private String blacklistedNumber = new String("11111222223333");

    public SliceOHeaven(String DEF_ORDER_ID, String DEF_PIZZA_INGREDIENTS, double DEF_ORDER_TOTAL, String sides, String drinks){
        orderID = DEF_ORDER_ID;
        pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        orderTotal = DEF_ORDER_TOTAL;
        this.sides = sides;
        this.drinks = drinks;
    }
    
    public void Pizza(String order_ID, String pizza_ingredients, double order_total){
        orderID = order_ID;
        pizzaIngredients =  pizza_ingredients;
        orderTotal = order_total;
    }
    
    public void setorderID(String orderID){
        this.orderID = orderID;
    }
    public String getorderID(){
        return orderID;
    }
    
    public void setpizzaIngredients(String pizzaIngredients){
        this.pizzaIngredients = pizzaIngredients;
    }
    public String getpizzaIngredients(){
        return pizzaIngredients;
    }
    
    public void setsides(String sides){
        this.sides = sides;
    }
    public String getsides(){
        return sides;
    }
    
    public void setdrinks(String drinks){
        this.drinks = drinks;
    }
    public String getdrinks(){
        return sides;
    }

    public void setorderTotal(double orderTotal){
        this.orderTotal = orderTotal ;
    }
    public String getorderTotal(){
        return sides;
    }

    public void takeOrder(String id, String Price, String Ingredients, String sides, String drinks, double total){
    orderID = id;
    pizzaIngredients = Ingredients;
    pizzaPrice = Price;
    this.sides = sides;
    this.drinks = drinks;
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

public void makePizza(String Ingredients, String sides, String drinks) {
    pizzaIngredients = Ingredients;
    this.sides = sides;
    this.drinks = drinks;
}

public void processCardPayment(String cardNumber){
    this.cardNumber = cardNumber;
    
    if(cardLength.equals("14")){
     System.out.println("Card accepted");
    } else{
     System.out.println("Incalid card");
    }
    char firstChar = cardNumber.charAt(0);
    int firstCardDigit = Integer.parseInt(String.valueOf(firstChar));
    
    if(cardNumber.equals(blacklistedNumber)){
        System.out.println("Card is blacklisted.Please use anthor card.");
    }
    
    lastFourDigits = Integer.parseInt(cardNumber.substring(10, 13));
    cardNumberToDisplay = firstCardDigit+"*********"+lastFourDigits;
    System.out.println(cardNumberToDisplay);
}

public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, double specialPrice) {
    System.out.println("Today's special offer:");
    System.out.println("Pizza Of The Day:"+pizzaOfTheDay);
    System.out.println("Side Of The Day:"+sideOfTheDay);
    System.out.println("Specialprice:"+specialPrice);
}

}

