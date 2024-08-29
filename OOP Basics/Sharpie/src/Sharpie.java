public class Sharpie {
    private String color;
    private int width;
    public int inkAmount = 100;

    public Sharpie(String color, int width) {
        this.color = color;
        this.width = width;
        this.inkAmount = 100;
    }

    public String getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    public int getInkAmount() {
        return inkAmount;
    }
    public void use() {
         inkAmount -= 10;
    }
}


