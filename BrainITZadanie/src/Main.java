import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String templatePath = "/Users/peter/Desktop/text.txt";
        String dataPath = "/Users/peter/Desktop/sample1.json";//convertcsv.csv text2.txt sample1.json

        int lastIndex = dataPath.lastIndexOf(".");
        IParser parse;

        if (dataPath.substring(lastIndex + 1).equals("txt")) {
            parse = new ParserTxt();
        } else if (dataPath.substring(lastIndex + 1).equals("csv")) {
            parse = new ParserCsv();
        } else if (dataPath.substring(lastIndex + 1).equals("json")) {
            parse = new ParserJson();
        } else {
            System.out.println("Nepodporovaný súbor");
            return;
        }

        try {
            Printer printer = new Printer(templatePath, dataPath,parse);
            printer.print();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}