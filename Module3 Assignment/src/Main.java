public class Main {
    public static void main(String[] args) {
        Cake chocolateBrownie = new Cake();
        chocolateBrownie.setName("Chocolate Brownie");
        chocolateBrownie.setPrice(250.0f);
        
        Cake chocolateMaple = new Cake();
        chocolateMaple.setName("Chocolate Maple");
        chocolateMaple.setPrice(300.0f);
        
        Pastry blackForest = new Pastry();
        blackForest.setName("Black Forest");
        blackForest.setPrice(35.0f);
        
        Pastry chocoTruffle = new Pastry();
        chocoTruffle.setName("Choco Truffle");
        chocoTruffle.setPrice(40.0f);
        
        System.out.println("Today's Special Menu");
        System.out.println("--------------------------------------------------");
        System.out.println("Special Cakes");
        System.out.println("---------------------------------------------");
        Cake[] cakes = { chocolateBrownie, chocolateMaple };
        for (Cake cake : cakes) {
            cake.display();
        }
        System.out.println("Special Pastries");
        System.out.println("---------------------------------------------");
        Cake[] pastries = { blackForest, chocoTruffle };
        for (Cake pastry : pastries) {
            pastry.display();
        }
    }
}
