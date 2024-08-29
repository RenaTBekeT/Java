public class Gnirts implements CharSequence {

    String string;

    public Gnirts(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    @Override
    public void reversedstring() {
        String correct = getString();
        String reversed = "";
        for (int i = 0; i < correct.length(); i++) {
            reversed = correct.charAt(i) + reversed;
        }


        System.out.println(reversed);
        for (int i = 0; i < reversed.length(); i++) {
        }
        System.out.println(reversed.charAt(2));
    }
}
