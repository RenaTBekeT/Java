import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carrier {
    int iniammo;
    int actualammo;
    int health;


    private List<Aircrafts> aircrafts;

    public Carrier() {
        aircrafts = new ArrayList<>();
        this.iniammo = 1000;
        this.actualammo = iniammo;
        this.health = 5000;
    }

    public int getIniammo() {
        return iniammo;
    }

    public int getActualammo() {
        return actualammo;
    }

    public int getHealth() {
        return health;
    }

    public void add(Aircrafts aircraft) {
        aircrafts.add(aircraft);
    }

    public int fill() {
        for (Aircrafts aircraft : aircrafts) {
            aircraft.reffilammo(aircraft.maxammo);
            actualammo = actualammo - aircraft.maxammo;
        }
        return actualammo;
    }

    public void fight(Carrier othercarrier) {
        for (Aircrafts aircraft : aircrafts) {
            aircraft.reffilammo(aircraft.maxammo);
            othercarrier.health = othercarrier.health - aircraft.basedamage * aircraft.ammunation;
        }
    }

    public int getcarrierTotalDamage() {
        int totaldamage = 0;
        for (Aircrafts aircraftsone : aircrafts) {
            totaldamage += (aircraftsone.getBasedamage() * aircraftsone.getAmmunation());
        }
        return totaldamage;

    }

    public void getstatusall() {
        System.out.println(this.health + ", " + aircrafts.size() + ", " + this.actualammo + ", " +  getcarrierTotalDamage());
        for (Aircrafts aircraftsone : aircrafts) {
            System.out.println(aircraftsone.getstatus());
        }
    }
}

