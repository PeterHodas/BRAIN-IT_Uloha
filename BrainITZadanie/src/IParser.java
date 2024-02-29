import java.util.List;
import java.util.Map;

public interface IParser {
    public List<Map<String, String>> fillList(String content);
    public Map<String, String> fillMap(String text);

}
