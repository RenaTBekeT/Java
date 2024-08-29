public class MainBlogPost {
    public static void main(String[] args) {
        BlogPost LoremIpsumBlogPost = new BlogPost("John Doe","LoremIpsum", "Lorem ipsum dolor sit amet", "2000.05.04.");
        BlogPost Waitbutwhy = new BlogPost("Tim Urban", "Waitbutwhy", "A popular long-form, stick-figure-illustrated blog about almost everything", "2010.10.10.");
        BlogPost OneEngineerIsTryingtoGetIBMtoReckonWithTrump = new BlogPost("William Turton","One Engineer Is Trying to Get IBM to Reckon With Trump", "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing", "2017.03.28." );

        System.out.println("LoremIpsumBlogPost BlogPost:");
        System.out.println("Author: " + LoremIpsumBlogPost.getAuthorName());
        System.out.println("Tite: " + LoremIpsumBlogPost.getTitle());
        System.out.println("Text: " + LoremIpsumBlogPost.getText());
        System.out.println("Date: " + LoremIpsumBlogPost.getPublicationDate());
        System.out.println();

        System.out.println("Waitbutwhy BlogPost:");
        System.out.println("Author: " + Waitbutwhy.getAuthorName());
        System.out.println("Tite: " + Waitbutwhy.getTitle());
        System.out.println("Text: " + Waitbutwhy.getText());
        System.out.println("Date: " + Waitbutwhy.getPublicationDate());
        System.out.println();

        System.out.println("OneEngineerIsTryingtoGetIBMtoReckonWithTrump BlogPost:");
        System.out.println("Author: " + OneEngineerIsTryingtoGetIBMtoReckonWithTrump.getAuthorName());
        System.out.println("Tite: " + OneEngineerIsTryingtoGetIBMtoReckonWithTrump.getTitle());
        System.out.println("Text: " + OneEngineerIsTryingtoGetIBMtoReckonWithTrump.getText());
        System.out.println("Date: " + OneEngineerIsTryingtoGetIBMtoReckonWithTrump.getPublicationDate());
        System.out.println();


    }
}
