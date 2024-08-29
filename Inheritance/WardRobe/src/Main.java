public class Main {
    public static void main(String[] args) {
        Wardrobe wardrobe = new Wardrobe();
        UnderWear socks = new UnderWear("Socks", "White");
        UnderWear shorts = new UnderWear("Shorts", "blue");
        OverWear shoes = new OverWear("Nikes","white");

        wardrobe.addcloth(shoes);
        shoes.wash();
        wardrobe.printInfo();
        shoes.wear();
        shoes.wear();
        shoes.wear();
        shoes.wear();
        shoes.wear();
        wardrobe.printInfo();
        shoes.wear();
        shoes.wash();
        wardrobe.printInfo();
        shoes.wear();
        shoes.wear();
        shoes.wash();













    }
}