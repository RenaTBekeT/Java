public class MainPostit {
    public static void main(String[] args) {
        PostIt orangePostIt = new PostIt("orange", "Idea 1", "blue") ;
        PostIt pinkPostIt = new PostIt("pink", "Awesome", "black");
        PostIt yellowPostIt = new PostIt("yellow", "Superb!", "green");

        System.out.println("Orange Post-It:");
        System.out.println("Background color: " + orangePostIt.getBackgroundColor());
        System.out.println("Text: " + orangePostIt.getText());
        System.out.println("Text color: " + orangePostIt.getTextColor());
        System.out.println();

        System.out.println("Pink Post-It:");
        System.out.println("Background color: " + pinkPostIt.getBackgroundColor());
        System.out.println("Text: " + pinkPostIt.getText());
        System.out.println("Text color: " + pinkPostIt.getTextColor());
        System.out.println();

        System.out.println("Yellow Post-It:");
        System.out.println("Background color: " + yellowPostIt.getBackgroundColor());
        System.out.println("Text: " + yellowPostIt.getText());
        System.out.println("Text color: " + yellowPostIt.getTextColor());
    }
}