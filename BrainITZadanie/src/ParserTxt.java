import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserTxt implements IParser {

    public List<Map<String, String>> fillList(String content) {
        List<Map<String, String>> array = new ArrayList<>();
        String[] lines = content.split("\n");
        for (int i = 0; i < lines.length; i++) {
            array.add(fillMap(lines[i]));
        }
        return array;
    }

    public Map<String, String> fillMap(String text) {
        String regex = "(\\w+):”(.*?)”";
        Map<String, String> hashMap = new HashMap<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            hashMap.put(matcher.group(1), matcher.group(2));
        }
        return hashMap;
    }
}
