public class app {
    public static void main(String[] args) throws Exception{
    SliceOHeaven SliceOHeaven = new SliceOHeaven("DEF-SOH-099", "Mozzarella Cheese", 15.00, "6-inch", "Cola");
    SliceOHeaven.takeOrder("DEF-SOH-099", "15","Mozzarella Cheese" , "6-inch",  "Cola", 15.00);
    SliceOHeaven.processCardPayment("12345678912345");
    SliceOHeaven.specialOfTheDay("Cheese pizza", "Cream of mushroom soup", 10.00);
}
        
}
