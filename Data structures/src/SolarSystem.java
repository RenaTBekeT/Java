
import java.util.*;

public class SolarSystem {
    public static void main(String... args) {
        List<String> planetList = Arrays.asList("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Uranus", "Neptune");

        // "Saturn" is missing from the planetList below
        // Insert it into the correct position (should go between Jupiter and Uranus)
        // Create a method called "putSaturn()" which has a list parameter and returns the correct list

        // Expected output: [Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune]
        System.out.println(putSaturn(planetList));
    }
    public static List<String>putSaturn(List<String>list) {
        List<String> updatedPlanets = new ArrayList<>(list);
        updatedPlanets.add(5, "Saturn");
        return updatedPlanets;
    }
}