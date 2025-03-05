public class app {
    public static void main(String[] args) throws Exception{
    SliceOHeaven SliceOHeaven = new SliceOHeaven("DEF-SOH-099", "Mozzarella Cheese", 15.00, "6-inch");
    SliceOHeaven.takeOrder();
    SliceOHeaven.isItYourBirthday();
    SliceOHeaven.makeCardPayment();
    SliceOHeaven.specialOfTheDay("Cheese pizza", "Cream of mushroom soup", 10.00);
}
        
}
