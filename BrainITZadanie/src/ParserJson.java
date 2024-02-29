import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParserJson implements IParser {
    public List<Map<String, String>> fillList(String content) {

        List<Map<String, String>> array = new ArrayList<>();
        //String regex = "\"(.*?)\":\\s*\"(.*?)\"\\s*";     //,\\s*\"vek\":\\s*\"(\\d+)\"";
        //String regex = "\"(.*?)\":\\s*\"(.*?)\"\\s*,\\s*\"(.*?)\":\\s*\"(.*?)\"";
        String[] parts = content.split("}");
        for (int i = 0; i < parts.length - 1; i++) {
            array.add(fillMap(parts[i]));
        }
        return array;
    }

    public Map<String, String> fillMap(String text) {
        Map<String, String> map = new HashMap<>();
        String regex = "\"(.*?)\":\\s*\"(.*?)\"\\s*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            map.put(matcher.group(1), matcher.group(2));
        }
        return map;
    }
}
