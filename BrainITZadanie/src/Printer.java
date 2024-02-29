import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Printer {
    private String contentTemplate;
    private List<Map<String, String>> data = new ArrayList<>();

    Printer(String templatePath, String dataPath, IParser parser) throws IOException {
        Loader loader = new Loader();
        this.contentTemplate = loader.openTxtFile(templatePath);
        String text = loader.openTxtFile(dataPath);
        this.data = parser.fillList(text);
    }

    public void print() {
        String newText;

        for (int i = 0; i < data.size(); i++) {//riadky
            newText = contentTemplate;
            for (Map.Entry<String, String> entry : data.get(i).entrySet()) {//jednotlive parametre v riadku
                newText = newText.replace("{"+entry.getKey()+"}", entry.getValue());
                //System.out.println( entry.getValue() + " " + entry.getKey());
            }
            System.out.println(newText);
        }
    }
}
