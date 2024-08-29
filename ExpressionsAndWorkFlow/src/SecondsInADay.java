package ExpressionsAndWorkFlow.src;

public class SecondsInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;
        int secondsPerMinute = 60;
        int minutesPerHour = 60;

        int currenttime = (currentHours*secondsPerMinute*minutesPerHour+(currentMinutes*secondsPerMinute)+(currentSeconds));
        int secondsindday = (24*secondsPerMinute*minutesPerHour);
        System.out.println(secondsindday-currenttime);
    }
}
// Write a program that prints the remaining seconds (as an integer) from a
// day if the current time is represented by the variables above