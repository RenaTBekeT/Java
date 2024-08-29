public class FleetOfThings {

    public static void main(String[] args) {
        Fleet fleet = new Fleet();
        // - You have the `Thing` class
        // - You have the `Fleet` class
        // - You have the `FleetOfThings` class with a `main()` method
        // - Download those, use those
        // - Create a fleet in the main() method

        // - Create a fleet of things to have this output:
        // 1. [ ] Get milk
        // 2. [ ] Remove the obstacles
        // 3. [x] Stand up
        // 4. [x] Eat lunch
        Thing milk = new Thing("Get Milk");
        Thing Obstacles = new Thing("Remove the obstacles");
        Thing Standup = new Thing("Stand up");
        Thing eatlunch = new Thing("Eat Lunch");

        Standup.complete();
        eatlunch.complete();


        fleet.add(milk);
        fleet.add(Obstacles);
        fleet.add(Standup);
        fleet.add(eatlunch);




        System.out.println(fleet);
    }
}