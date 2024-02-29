import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserCsv implements IParser {
    String[] parts;
    public List<Map<String, String>> fillList(String content) {
        List<Map<String, String>> array = new ArrayList<>();
        String[] lines = content.split("\n");
        parts = lines[0].split(",");
        for (int i = 1; i < lines.length; i++) {
            array.add(fillMap(lines[i]));
        }
        return array;
    }

    public Map<String, String> fillMap(String text) {
        //String regex = "\"(.*?)\",\"(.*?)\"";
        Map<String, String> hashMap = new HashMap<>();

        String[] s = text.split(",");
        int count = 0;
        System.out.println(text);

        for (int i = 0; i < s.length; i++) {
            hashMap.put(parts[count], s[i]);
            count++;
        }
        return hashMap;
    }
}
