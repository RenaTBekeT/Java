public class Cloth {
    String type;
    String color;
    int daysworn;
    int condition;

    public Cloth(String type, String color) {
        this.type = type;
        this.color = color;
        this.daysworn = 0;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }


    public int getDaysworn() {
        return daysworn;
    }

    public boolean needsToBeWashed() {
        return true;
    }
    public boolean needsToBeRepaired() {
        return true;
    }
    public void wear() {
        if (!needsToBeWashed()) {
            daysworn++;
        } else {
            System.out.println("It is dirty! Please wash and wear others");
        }
    }

    public void wash() {
        if (needsToBeWashed() && condition >= 1) {
            daysworn = 0;
            condition--;
        } else {
            System.out.println("it is clean");
        }
    }
        public void repair() {
        condition = 0;
        ;
    }
    public String getinfo() {
        return color +" " + type + " worn for " + daysworn + " days, has "+ condition + " cycles left ";
    }
}

