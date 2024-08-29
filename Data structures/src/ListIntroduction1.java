import java.util.ArrayList;

class ListIntroduction1 {
    public static void main(String[] args) {


        ArrayList<String> names = new ArrayList<String>();
        System.out.println(names.size());
        names.add("William");

        System.out.println(names.size() == 0);

        names.add("John");
        names.add("Amanda");

        System.out.println(names.size());
        System.out.println(names.get(2));

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));

        }


        for (int i = 0; i < names.size(); i++) {
            String addNumber = names.get(i);
            System.out.println(i + 1 + "." + addNumber);



        }
        names.remove(1);

        for (int i = 1; i >=0 ; i--) {
            System.out.println(names.get(i));
        }
        names.clear();
        {
            System.out.println(names.size());
        }

    }
}
