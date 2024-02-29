import java.io.*;

public class Loader {

    public String getTypeOfDocument(String path) {
        int lastIndex = path.lastIndexOf(".");
        if (lastIndex != -1 && lastIndex < path.length() - 1) {
            return path.substring(lastIndex + 1);
        }
        return "";
    }

    public String openTxtFile(String path) throws IOException {
        String allData = "";
        File file = new File(path);
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String data;
            while ((data = br.readLine()) != null) {
                //System.out.println(data);
                allData += (data + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allData;
    }
}
