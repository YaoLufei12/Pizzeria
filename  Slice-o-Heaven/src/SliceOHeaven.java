import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class  SliceOHeaven {
    /*public final String DEF_ORDER_ID = "DEF-SOH-099";
    public final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public final double DEF_ORDER_TOTAL = 15.00;*/

    public String storeName;
    public String storeAddress;
    public String storeMenu;
    public String storeEmail;
    public long storePhone;
    public String pizzaPrice;
    
    private String orderID;
    private String pizzaIngredients;
    private String sides;
    //private double orderTotal;

    public int cvv;
    public String cardNumber;
    public String expiryDate;
    public int firstCardDigit;
    public int lastFourDigits;
    public String cardNumberToDisplay;

    enum  PizzaSelection{
        PEPPERONI("Pepperoni","Lots of pepperoni and extra cheese", 18),
        HAWAIIAN("Hawaiian","Pineapple, ham, and extra cheese",22), 
        VEGGIE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives", 25), 
        BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper, and cheddar cheese", 35),
        EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions, green pepper, mushrooms, black olives, and extra cheese", 45);
    
    private final String pizzaName;
    private final String pizzaToppings;
    private final int price;

    PizzaSelection(String pizzaName, String pizzaToppings, int price){
        this.pizzaName = pizzaName;
        this.pizzaToppings = pizzaToppings;
        this.price = price;
    }
    public String getPizzaName(){
        return pizzaName;
    }
    public String getPizzaToppings(){
        return pizzaToppings;
    }
    public int getPrice(){
        return price;
    }
    
    public String toString(){
        return pizzaName+" "+pizzaToppings+" "+price;
    }
    
    }
    
    enum  PizzaToppings{
        HAM("Ham", 2), 
        PEPPERONI("Pepperoni", 2),
        BEEF("Beef", 2),
        CHICKEN("Chicken", 2), 
        SAUSAGE("Sausage", 2),
        PINEAPPLE("Pineapple", 1),
        ONION("Onion", 0.5), 
        TOMATOES("Tomatoes", 0.4), 
        GREEN_PEPPER("Green Pepper", 0.5), 
        BLACK_OLIVES("Black Olives", 0.5), 
        SPINACH("Spinach", 0.5), 
        CHEDDAR_CHEESE("Cheddar Cheese", 0.8), 
        MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8), 
        FETA_CHEESE("Feta Cheese", 1), 
        PARMESAN_CHEESE("Parmesan Cheese", 1);

        private final String topping;
        private final double toppingPrice;

        PizzaToppings(String topping, double toppingPrice){
            this.topping = topping;
            this.toppingPrice = toppingPrice;
        }
        public String getTopping(){
            return topping;
        }
        public double getToppingPrice(){
            return toppingPrice;
        }
        public String toString(){
            return topping+" "+toppingPrice;
        }
    }

    enum PizzaSize{
        LARGE("Large", 10), 
        MEDIUM("Medium", 5),
        SMALL("Small", 0);

        private final String pizzaSize;
        private final double addToPizzaPrice;

        PizzaSize(String pizzaSize, double addToPizzaPrice){
            this.pizzaSize = pizzaSize;
            this.addToPizzaPrice = addToPizzaPrice;
        }
        public String getPizzaSize(){
            return pizzaSize;
        }
        public double getAddToPizzaPrice(){
            return addToPizzaPrice;
        }
        public String toString(){
            return pizzaSize+" "+addToPizzaPrice;
        }
        
    }

    enum SideDish{
        CALZONE("Calzone", 15), 
        CHICKEN_PUFF("Chicken Puff", 20),
        MUFFIN("Muffin", 12),
        NOTHING("No side dish", 0);

        private final String sideDishName;
        private final double addToPizzaPrice;

        SideDish(String sideDishName, double addToPizzaPrice){
            this.sideDishName = sideDishName;
            this.addToPizzaPrice = addToPizzaPrice;
        }
        public String getSideDishName(){
            return sideDishName;
        }
        public double getAddToPizzaPrice(){
            return addToPizzaPrice;
        }
        public String toString(){
            return sideDishName+" "+addToPizzaPrice;
        }
    }

    enum Drinks{
        COCA_COLA("Coca Cola", 8), 
        COCOA_DRINK("Cocoa Drink", 10),
        NOTHING("No drinks", 0);

        private final String drinkName;
        private final double addToPizzaPrice;

        Drinks(String drinkName, double addToPizzaPrice){
            this.drinkName = drinkName;
            this.addToPizzaPrice = addToPizzaPrice;
        }
        public String getDrinkName(){
            return drinkName;
        }
        public double getAddToPizzaPrice(){
            return addToPizzaPrice;
        }
        public String toString(){
            return drinkName+" "+addToPizzaPrice;
        }
    }
   

    public void Pizza(String order_ID, String pizza_ingredients, double order_total){
        orderID = order_ID;
        pizzaIngredients =  pizza_ingredients;
        //orderTotal = order_total;
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
    
    //public void setorderTotal(double orderTotal){
       // this.orderTotal = orderTotal ;
    //}
   // public String getorderTotal(){
       // return sides;
   // }
    private final double PIZZA_BASE_PRICE = 10.0;
    
    private String[] pizzasOrdered = new String[10];
    private String[] pizzaSizesOrdered = new String[10];
    private String[] sideDishesOrdered = new String[20];
    private String[] drinksOrdered = new String[20];
   
    private double totalOrderPrice = 0.0;

    public void takeOrder(){
        Scanner input = new Scanner(System.in);
        boolean continueOrdering = true;
        int orderIndex = 0;
        
        System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here's what we serve:");
        int index = 1;
        for(PizzaSelection pizza: PizzaSelection.values()){
            System.out.println(index+". "+pizza.toString());
            index++;
        }
        System.out.println(index+". Custom Pizza with a maximum of 10 toppings that you choose:");
        System.out.println(" Please enter your choice (1 - 6):");
        int choice = input.nextInt();
        if(choice < 1 || choice > 6){
            System.out.println("Invalid choice. Please enter a number between 1 and 6:");
            choice = input.nextInt();
        }
       
        double customPizzaPrice = 0.0;
        
        if(choice >=1 && choice <=5){
                PizzaSelection selectedPizza = PizzaSelection.values()[choice-1];
                System.out.println("You have chosen:"+selectedPizza.getPizzaName());
                String pizzaDetails = selectedPizza.getPizzaName() + " Pizza with " + selectedPizza.getPizzaToppings() + ", for €" + selectedPizza.getPrice();
                pizzasOrdered[orderIndex] = pizzaDetails;
                totalOrderPrice += selectedPizza.getPrice();
                System.out.println("Your order is: " + pizzaDetails);                                                                                              
            }else if(choice == 6){
                System.out.println("You have chosen to create a custom pizza. Choose up to 10 toppings:");
                int toppingIndex = 1;
                for (PizzaToppings topping : PizzaToppings.values()) {
                    System.out.println(toppingIndex + ". " + topping.getTopping() + " (" + topping.getToppingPrice() + "€)");
                    toppingIndex++;
                }
                Set<PizzaToppings> selectedToppings = new HashSet<>();
                customPizzaPrice = PIZZA_BASE_PRICE;
                while (selectedToppings.size() <= 10) {
                    System.out.println("Enter the number of the topping you want to add (or 'done' to finish):");
                    String choiceStr = input.next();
                    if (choiceStr.equalsIgnoreCase("done")) {
                        break;
                    }
                    int toppingChoice = Integer.parseInt(choiceStr);
                    if (toppingChoice < 1 || toppingChoice > PizzaToppings.values().length) {
                        System.out.println("Invalid choice. Please enter a valid topping number.");
                        continue;
                    }
                    PizzaToppings selectedTopping = PizzaToppings.values()[toppingChoice - 1];
                    if (selectedToppings.contains(selectedTopping)) {
                        System.out.println("You've already chosen this topping.");
                        continue;
                    }
                    selectedToppings.add(selectedTopping);
                    customPizzaPrice += selectedTopping.getToppingPrice();
                }
                StringBuilder pizzaDescription = new StringBuilder("Custom Pizza with ");
                for (PizzaToppings topping : selectedToppings) {
                    pizzaDescription.append(topping.getTopping()).append(", ");
                }
                pizzaDescription.setLength(pizzaDescription.length() - 2); 
                pizzaDescription.append(" for €").append(customPizzaPrice);
                pizzasOrdered[orderIndex] = pizzaDescription.toString();
                totalOrderPrice += customPizzaPrice;
        
                System.out.println("Your custom pizza order is: " + pizzasOrdered[0]);
            }
    
        System.out.println("Choose a pizza size:");
            index = 1;
            for (PizzaSize size : PizzaSize.values()) {
                System.out.println(index + ". " + size.getPizzaSize() + " (" + size.getAddToPizzaPrice() + "€)");
                index++;
            }
        System.out.println("Please enter your choice (1 - 3):");
            int sizeChoice = input.nextInt();
            if (sizeChoice >= 1 && sizeChoice <= 3) {
                PizzaSize selectedSize = PizzaSize.values()[sizeChoice - 1];
                pizzaSizesOrdered[orderIndex] = selectedSize.getPizzaSize();
                totalOrderPrice += selectedSize.getAddToPizzaPrice();
                customPizzaPrice += selectedSize.getAddToPizzaPrice();
                System.out.println("You have chosen " + selectedSize.getPizzaSize() + " size.");
            } else {
                System.out.println("Invalid choice. Defaulting to Small size.");
            }
        
        System.out.println("Choose a side dish:");
            index = 1;
            for (SideDish sideDish : SideDish.values()) {
                System.out.println(index + ". " + sideDish.getSideDishName() + " (" + sideDish.getAddToPizzaPrice() + "€)");
                index++;
            }
        System.out.println("Please enter your choice (1 - 4):");
            int sideDishChoice = input.nextInt();
            if (sideDishChoice >= 1 && sideDishChoice <= 4) {
                SideDish selectedSideDish = SideDish.values()[sideDishChoice - 1];
                sideDishesOrdered[orderIndex] = selectedSideDish.getSideDishName();
                totalOrderPrice += selectedSideDish.getAddToPizzaPrice();
                System.out.println("You have chosen " + selectedSideDish.getSideDishName() + " as a side dish.");
            } else {
                System.out.println("Invalid choice. No side dish selected.");
            }
        
        System.out.println("Choose a drink:");
            index = 1;
            for (Drinks drink : Drinks.values()) {
                System.out.println(index + ". " + drink.getDrinkName() + " (" + drink.getAddToPizzaPrice() + "€)");
                index++;
            }
        System.out.println("Please enter your choice (1 - 3):");
            int drinkChoice = input.nextInt();
            if (drinkChoice >= 1 && drinkChoice <= 3) {
                Drinks selectedDrink = Drinks.values()[drinkChoice - 1];
                drinksOrdered[orderIndex] = selectedDrink.getDrinkName();
                totalOrderPrice += selectedDrink.getAddToPizzaPrice();
                System.out.println("You have chosen " + selectedDrink.getDrinkName() + " as a drink.");
            } else {
                System.out.println("Invalid choice. No drink selected.");
            }
    
        System.out.println("Do you want to  want to order more for as long as you want to ?(Y/N):");
        String anotherOrder = input.nextLine();
        if (!anotherOrder.equalsIgnoreCase("Y")) {
            continueOrdering = false;
        }else{
            orderIndex++;
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

        /*System.out.println(toString(orderID,ing1,ing2,ing3,pizzaSize,extraCheese,sideDish,drinks));
        input.close();*/
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

@Override
public String toString() {
    StringBuilder receipt = new StringBuilder();
    receipt.append("********RECEIPT********\n");
    receipt.append("Thank you for dining with Slice-o-Heaven Pizzeria. Your order details are as follows:\n");

    for (int i = 0; i < 10; i++) {
        if (pizzasOrdered[i] != null) {
            receipt.append(i + 1).append(". ").append(pizzasOrdered[i]).append("\n");
            receipt.append(pizzaSizesOrdered[i]).append("\n");
            receipt.append(sideDishesOrdered[i]).append("\n");
            receipt.append(drinksOrdered[i]).append("\n");
            receipt.append("--------------------\n");
        }
    }
    receipt.append("ORDER TOTAL: €").append(totalOrderPrice).append("\n");
    return receipt.toString();
}

/*public String toString(String orderID,String ing1, String ing2, String ing3, String pizzaSize, String extraCheese,String sideDish, String drinks){
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
    }*/

public void makePizza(String Ingredients, String sides) {
    pizzaIngredients = Ingredients;
    this.sides = sides;
}
}

