package ExpressionsAndWorkFlow.src;

public class CodingHours {
    public static void main(String[] args) {
        int cod = 6;
        int sem = 17;
        int days = 5;
        int work = 52;

        int attendeeCodes = (cod * sem * days);
        int attendeeWorks = (work * sem);
        double percantage = ((double) attendeeCodes / attendeeWorks) * 100;
        System.out.println(attendeeCodes);
        System.out.println(percantage);
    }
}
// An average Green Fox attendee codes 6 hours daily
// The semester is 17 weeks long
//
// Print how many hours is spent with coding in a semester by an attendee,
// if the attendee only codes on workdays.
//
// Print the percentage of the coding hours in the semester if the average
// work hours weekly is 52
