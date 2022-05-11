package ua.lviv.IoT.manager;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class RegexManager {

    public void printPenultimateWordsInAllSentences(String text) {
        String regex = "[\\w-]+ [\\w-]+[.!?]+";
        String[] strings = Pattern.compile(regex)
                .matcher(text)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
        StringBuilder result = new StringBuilder();
        for (String str:strings) {
            int i = str.indexOf(" ");
            if(i == -1)
                continue;
            String word = str.substring(0,i);
            result.append(word).append("\n");
        }
        System.out.println(result);
    }

}
