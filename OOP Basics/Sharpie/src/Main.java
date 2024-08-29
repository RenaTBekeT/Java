public class Main {
    public static void main(String[] args) {
        SharpieSet sharpieSet = new SharpieSet();

        Sharpie red = new Sharpie("red", 20);
        Sharpie blue= new Sharpie("blue", 25);
        Sharpie green = new Sharpie("green", 22);

        sharpieSet.add(red);
        sharpieSet.add(blue);
        sharpieSet.add(green);


        System.out.println("Sharpie red, color: " + red.getColor());
        System.out.println("Sharpie red, width: " + red.getWidth());
        System.out.println("Sharpie red, inkamonut: " + red.inkAmount);
        System.out.println();

        System.out.println("Sharpie blue, color: " + blue.getColor());
        System.out.println("Sharpie blue, width: " + blue.getWidth());
        System.out.println("Sharpie blue, inkamonut: " + blue.inkAmount);
        System.out.println();

        System.out.println("Sharpie green, color: " + green.getColor());
        System.out.println("Sharpie green, width: " + green.getWidth());
        System.out.println("Sharpie green, inkamonut: " + green.inkAmount);
        System.out.println();

        System.out.println("after using:");
        red.use();
        blue.use();
        green.use();
        green.use();
        green.use();
        green.use();
        green.use();
        green.use();
        green.use();
        green.use();
        green.use();
        green.use();

        System.out.println("sharpie red " + red.getInkAmount());
        System.out.println("sharpie red " + blue.getInkAmount());
        System.out.println("sharpie red " + green.getInkAmount());

        System.out.println("Number of usable sharpies: " + sharpieSet.countUsable());

        sharpieSet.removeTrash();

        System.out.println("Number of usable sharpies after removing trash: " + sharpieSet.countUsable());




    }


    }
