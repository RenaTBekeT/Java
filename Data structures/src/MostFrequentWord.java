import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class MostFrequentWord {
    public static void main(String[] args) {
        mostFrequentWord("But then they were married (she felt awful about being pregnant before but" +
                "Harry had been talking about marriage for a while and anyway laughed when" +
                "she told him in early February about missing her period and said Great she" +
                "was terribly frightened and he said Great and lifted her put his arms around" +
                "under her bottom and lifted her like you would a child he could be so" +
                "wonderful when you didn’t expect it in a way it seemed important that you" +
                "didn’t expect it there was so much nice in him she couldn’t explain to" +
                "anybody she had been so frightened about being pregnant and he made her" +
                "be proud) they were married after her missing her second period in March" +
                "and she was still little clumsy dark-complected Janice Springer and her" +
                "husband was a conceited lunk who wasn’t good for anything in the world Daddy" +
                "said and the feeling of being alone would melt a little with a little drink.");
    }

    public static void mostFrequentWord(String sentence) {
        String strArray[] = sentence.split(" ");
        System.out.println(Arrays.toString(strArray));
        HashMap<String, Integer>frequence = new HashMap<>();
        for (String word : strArray) {
            Integer count = frequence.get(word);
           if (count == null) {
               count = 0;
           }
                frequence.put(word, count + 1);
        }
        for (HashMap.Entry<String, Integer> entry: frequence.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println(Collections.max(frequence.entrySet(), HashMap.Entry.comparingByValue()).getKey());
    }

}



