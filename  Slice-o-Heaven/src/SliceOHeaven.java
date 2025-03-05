import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

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
    private double orderTotal;

    public int cvv;
    public String cardNumber;
    public String expiryDate;
    public int firstCardDigit;
    public int lastFourDigits;
    public String cardNumberToDisplay;

    public SliceOHeaven(String DEF_ORDER_ID, String DEF_PIZZA_INGREDIENTS, double DEF_ORDER_TOTAL, String sides){
        orderID = DEF_ORDER_ID;
        pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        orderTotal = DEF_ORDER_TOTAL;
        this.sides = sides;
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
    
    public void setorderTotal(double orderTotal){
        this.orderTotal = orderTotal ;
    }
    public String getorderTotal(){
        return sides;
    }
    public void takeOrder(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter three ingredients for your pizza:");
        String[] ingredients = input.nextLine().split(" ");
        String ing1 = ingredients[0];
        String ing2 = ingredients[1];
        String ing3 = ingredients[2];
        
        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String pizzaSize = input.nextLine();
        
        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = input.nextLine();
        
        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        String sideDish = input.nextLine();
        
        System.out.println("”Enter drinks(Cold Coffee, Cocoa drink, Coke, None):");
        String drinks = input.nextLine();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = input.nextLine();
        if(wantDiscount.equalsIgnoreCase("Y")){
            isItYourBirthday();
        }else{
            makeCardPayment();
        }
    input.close();

    System.out.println("Order accepted!");

    System.out.println("Order is being prepared.");

    try{
        Thread.sleep(5000);
    }catch (InterruptedException e){
        System.out.println("Order is ready for pickup!");
    }
        System.out.println("Your order is ready!");

        printReceipt(ing1, ing2, ing3,sideDish,pizzaSize,drinks,extraCheese);
}
public void isItYourBirthday(){
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter your birthdate (YYYY-MM-DD):");
    String birthdate = input.nextLine();
    int year = Integer.parseInt(birthdate.substring(0,4));
    int month = Integer.parseInt(birthdate.substring(5,7));
    int day = Integer.parseInt(birthdate.substring(8,10));
    
    LocalDate dob = LocalDate.of(year, month, day);
    LocalDate now = LocalDate.now();

    Period diff = Period.between(dob, now);
    
    System.out.println("You are " + diff.getYears()+" years old.");
    int age = Period.between(dob, now).getYears();
    
    if(age < 18 && now.getMonthValue() == dob.getMonthValue()){
        System.out.println("Congratulations! You pay only half the price for your order.");
    }else{
        System.out.println("Too bad! You do not meet the conditions to get our 50% discount.");
    }
    input.close();
}

public void makeCardPayment(){
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter your card number:");
    long cardNumber = scanner.nextLong();
    scanner.nextLine();

    System.out.println("Enter the card's expiry date");
    String expiryDate = scanner.nextLine();
    
    System.out.println("Enter the card's cvv number:");
    int cvv=scanner.nextInt();

    processCardPayment(cardNumber,expiryDate,cvv);

   scanner.close();
}

    private String blacklistedNumber = new String("12345678901234");
public void processCardPayment(long cardNumber, String expiryDate, int cvv){
    String cardNumberString =  Long.toString(cardNumber);
    int cardLength = cardNumberString.length();
    
    if(cardLength == 14){
    System.out.println("Card accepted");
    } else{
     System.out.println("Incalid card");
    }
    

    char firstChar = cardNumberString.charAt(0);
    int firstCardDigit = Integer.parseInt(String.valueOf(firstChar));

    if(cardNumberString.equals(blacklistedNumber)){
        System.out.println("Card is blacklisted.Please use anthor card.");
    }
    
    lastFourDigits = Integer.parseInt(cardNumberString.substring(10, 14));
    cardNumberToDisplay = firstCardDigit+"*********"+lastFourDigits;
    System.out.println(cardNumberToDisplay);
}

public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, double specialPrice) {
    System.out.println("Today's special offer:");
    System.out.println("Pizza Of The Day:"+pizzaOfTheDay);
    System.out.println("Side Of The Day:"+sideOfTheDay);
    System.out.println("Specialprice:"+specialPrice);
}

private void printReceipt(String ing1, String ing2, String ing3,String sideDish,String pizzaSize,String drinks,String extraCheese){
    System.out.println("********RECEIPT********");
    System.out.println("Order ID:" + orderID);
    System.out.println("Details:" +pizzaSize +"  " +extraCheese);
    System.out.println("Ingredients:" +ing1 +"  " +ing2 +"  "+ing3);
    System.out.println("Sides:" +sideDish);
    System.out.println("Drinks:" +drinks);
    System.out.println("Order Total:" +orderTotal);
    
    }

public void makePizza(String Ingredients, String sides) {
    pizzaIngredients = Ingredients;
    this.sides = sides;
}
}

