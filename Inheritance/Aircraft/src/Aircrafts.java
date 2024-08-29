import javax.print.attribute.standard.PagesPerMinute;

public class Aircrafts {
    int ammunation;
    int maxammo;
    int basedamage;
    String type;

    public int getAmmunation() {
        return ammunation;
    }

    public int getMaxammo() {
        return maxammo;
    }

    @Override
    public String toString() {
        return "Aircrafts{" +
                "ammunation=" + ammunation +
                ", maxammo=" + maxammo +
                ", basedamage=" + basedamage +
                ", type='" + type + '\'' +
                '}';
    }

    public int getBasedamage() {
        return basedamage;
    }

    public String getType() {
        return type;
    }

    public Aircrafts(int maxammo, int basedamage, String type) {
        this.ammunation = 0;
        this.basedamage = basedamage;
        this.maxammo = maxammo;
        this.type = type;
    }
    public int fight() {
        ammunation = 0;
        return maxammo * basedamage;
    }
    public int reffilammo(int ammofromstation)
    {
        ammunation = maxammo;
        return ammofromstation - maxammo;
    }
    public String getstatus() {
        return "Type: " + getType() + ", Ammo: " + getAmmunation() + ", Base damage: " + getBasedamage() + " all damage: " + (ammunation * basedamage);

    }


}
