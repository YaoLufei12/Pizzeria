import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


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

    
    //public SliceOHeaven(String DEF_ORDER_ID, String DEF_PIZZA_INGREDIENTS, double DEF_ORDER_TOTAL, String sides){
       // orderID = DEF_ORDER_ID;
       // pizzaIngredients = DEF_PIZZA_INGREDIENTS;
       // orderTotal = DEF_ORDER_TOTAL;
      //  this.sides = sides;
   // }
    
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
        System.out.println("Please pick any three of the following ingredients:\r\n" + //
                        " 1. Mushroom\r\n" + //
                        " 2. Paprika\r\n" + //
                        " 3. Sun-dried tomatoes\r\n" + //
                        " 4. Chicken\r\n" + //
                        " 5. Pineapple\r\n" + //
                        " Enter any three choices (1, 2, 3,…) separated by spaces:");
             
        int ingChoice1 = input.nextInt();
        int ingChoice2 = input.nextInt();
        int ingChoice3 = input.nextInt();
        while(ingChoice1<1||ingChoice1>5||ingChoice2<1||ingChoice2>5||ingChoice3<1||ingChoice3>5){
            System.out.println("Invalid choice(s). Please pick only from the given list:");
        }        
        
        String ing1 = null;
        switch (ingChoice1) {
            case 1:
                ing1 = "Mushroom";
                break;
            case 2:
                ing1 = "Paprika";
                break;
            case 3:
                ing1 = "Sun-dried tomatoes";
                break;
            case 4:
                ing1 = "Chicken";
                break;
            case 5:
                ing1 = "Pineapple";
                break;
            default:
                break;
        }
        String ing2 = null;
        switch (ingChoice2) {
            case 1:
                ing2 = "Mushroom";
                break;
            case 2:
                ing2 = "Paprika";
                break;
            case 3:
                ing2 = "Sun-dried tomatoes";
                break;
            case 4:
                ing2 = "Chicken";
                break;
            case 5:
                ing2 = "Pineapple";
                break;
            default:
                break;
        }
        String ing3 = null;
        switch (ingChoice3) {
            case 1:
                ing3 = "Mushroom";
                break;
            case 2:
                ing3 = "Paprika";
                break;
            case 3:
                ing3 = "Sun-dried tomatoes";
                break;
            case 4:
                ing3 = "Chicken";
                break;
            case 5:
                ing3 = "Pineapple";
                break;
            default:
                break;
        }
        
        System.out.println("What size should your pizza be?\r\n" + //
                        " 1. Large\r\n" + //
                        " 2. Medium\r\n" + //
                        " 3. Small\r\n" + //
                        " Enter only one choice (1, 2, or 3):");
        int sizeChoice = input.nextInt();
        String pizzaSize = null;
        switch (sizeChoice) {
            case 1:
                pizzaSize = "Large";
                break;
            case 2:
                pizzaSize = "Medium";
                break;
            case 3:
                pizzaSize ="Small";
                break;
            default:
                break;
        }
        
        input.nextLine();
        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = input.nextLine();

        input.nextLine();
        System.out.println("Following are the side dish that go well with your pizza:\r\n" + //
                        " 1. Calzone\r\n" + //
                        " 2. Garlic bread\r\n" + //
                        " 3. Chicken puff\r\n" + //
                        " 4. Muffin\r\n" + //
                        " 5. Nothing for me\r\n" + //
                        " What would you like? Pick one (1, 2, 3,…):");
        int sideDishChoice = input.nextInt();
        String sideDish = null;
        switch (sideDishChoice) {
            case 1:
                sideDish = "Calzone";
                break;
            case 2:
                sideDish = "Garlic bread";
                break;
            case 3:
                sideDish ="Chicken puff";
                break;
            case 4:
                sideDish = "Muffin";
                break;
            case 5:
                sideDish = "Nothing for me";
                break;
            default:
                break;
        }

        System.out.println("Choose from one of the drinks below. We recommend Coca Cola:\r\n" + //
                        " 1. Coca Cola\r\n" + //
                        " 2. Cold coffee\r\n" + //
                        " 3. Cocoa Drink\r\n" + //
                        " 4. No drinks for me\r\n" + //
                        " Enter your choice:");
        int drinksChoice = input.nextInt();
        String drinks = null;
        switch (drinksChoice) {
            case 1:
                drinks = "Coca Cola";
                break;
            case 2:
                drinks = "Cold coffee";
                break;
            case 3:
                drinks = "Cocoa Drink";
                break;
            case 4:
                drinks = " No drinks for me";
                break;
            default:
                break;
        }
        input.nextLine();
        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = input.nextLine();
        
        if(wantDiscount.equalsIgnoreCase("Y")){
            isItYourBirthday();
        }else{
            makeCardPayment();
        }

    System.out.println("Order accepted!");

    System.out.println("Order is being prepared.");

    try{
        Thread.sleep(5000);
    }catch (InterruptedException e){
        System.out.println("Order is ready for pickup!");
    }
        System.out.println("Your order is ready!");

        System.out.println(toString(orderID,ing1,ing2,ing3,pizzaSize,extraCheese,sideDish,drinks));
        input.close();
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
    
    while(diff.getYears()<5||diff.getYears()>120){
        System.out.println("Invalid date. You are either too young or too dead to order. \r\n" + //
                        "Please enter a valid date:");
        System.out.println("Enter your birthdate (YYYY-MM-DD):");
        birthdate = input.nextLine();
        year = Integer.parseInt(birthdate.substring(0,4));
        month = Integer.parseInt(birthdate.substring(5,7));
        day = Integer.parseInt(birthdate.substring(8,10));
        dob = LocalDate.of(year, month, day);
        now = LocalDate.now();

        diff = Period.between(dob, now);
    }
   
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
    boolean validExpiryDate = false;
    while (!validExpiryDate) {
        try {
            String[] parts = expiryDate.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]); 

            LocalDate expiry = LocalDate.of(year, month, 1);
            LocalDate now = LocalDate.now();

            if (expiry.isBefore(now)) {
                System.out.println("Invalid expiry date. The date must be in the future. Please enter a valid date (YYYY-MM):");
                expiryDate = scanner.nextLine();
            } else {
                validExpiryDate = true;
            }
        } catch (Exception e) {
            System.out.println("Invalid format. Please enter the expiry date in YYYY-MM format:");
            expiryDate = scanner.nextLine();
        }
    }
    
    System.out.println("Enter the card's cvv number:");
    int cvv=scanner.nextInt();

    processCardPayment(cardNumber,expiryDate,cvv);

    scanner.close();

}

public void processCardPayment(long cardNumber, String expiryDate, int cvv){
    Scanner scanner = new Scanner(System.in);   
    String cardNumberString =  Long.toString(cardNumber);
    int cardLength = cardNumberString.length();
    
    final Set<Long> blacklistedNumber = new HashSet<>();
    blacklistedNumber.add(12345678901234L); 

    if(cardLength == 14){
        System.out.println("Card accepted");
       
    } else{
     System.out.println("Incalid card");
    }
    
    while(cardLength!=14||blacklistedNumber.contains(cardNumber)){
        System.out.println("Card is blacklisted.Please use anthor card:");
        cardNumber = scanner.nextLong();
    }
    
    char firstChar = cardNumberString.charAt(0);
    int firstCardDigit = Integer.parseInt(String.valueOf(firstChar));

    
    lastFourDigits = Integer.parseInt(cardNumberString.substring(10, 14));
    cardNumberToDisplay = firstCardDigit+"*********"+lastFourDigits;
    System.out.println(cardNumberToDisplay);
    orderID = cardNumberToDisplay;
    scanner.close();
}

public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, double specialPrice) {
    System.out.println("Today's special offer:");
    System.out.println("Pizza Of The Day:"+pizzaOfTheDay);
    System.out.println("Side Of The Day:"+sideOfTheDay);
    System.out.println("Specialprice:"+specialPrice);
}

public String toString(String orderID,String ing1, String ing2, String ing3, String pizzaSize, String extraCheese,String sideDish, String drinks){
    StringBuilder receipt = new StringBuilder();
    receipt.append("********RECEIPT********\n");
    receipt.append("Order ID: ").append(orderID).append("\n");
    receipt.append("Ingredients: ").append(ing1).append("  ").append(ing2).append("  ").append(ing3).append("\n"); 
    receipt.append("Size: ").append(pizzaSize).append("\n");
    receipt.append("Extra Cheese(Y/N): ").append(extraCheese).append("\n");
    receipt.append("Side Dish: ").append(sideDish).append("\n"); 
    receipt.append("Drinks: ").append(drinks).append("\n"); 
    receipt.append("Order Total: ").append(orderTotal).append("\n"); 
    return receipt.toString();
    }

public void makePizza(String Ingredients, String sides) {
    pizzaIngredients = Ingredients;
    this.sides = sides;
}
}

