public class ShiftedCharSequence implements CharSequence {

    String string;
    int i;

    public String getString() {
        return string;
    }

    public int getI() {
        return i;
    }

    public ShiftedCharSequence(String string, int i) {
        this.string = string;
        this.i = i;
    }

    @Override
    public void reversedstring() {
        String string1= getString();
        for (int i = 0; i < string1.length(); i++) {
            string1.charAt(2);
        }
        System.out.println(string1.charAt(1));
    }

}

