package ua.lviv.IoT.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexManager {

    public List<String> findPenultimateWordsInAllSentences(String text) {
        String regex = "\\S+\\s+\\S+[.!?]+";
        String[] strings = Pattern.compile(regex)
                .matcher(text)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
        List<String> result = new ArrayList<>();
        for (String str:strings) {
            String regex1 = "[\\w-]+";
            Matcher matcher = Pattern.compile(regex1).matcher(str);
            matcher.find();
            result.add(str.substring(matcher.start(), matcher.end()));
        }
        return result;
    }

}
