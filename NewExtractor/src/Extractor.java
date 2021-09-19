
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Extractor {
    public static void main(String[] args) throws FileNotFoundException {
        fileReader();
    }

    private static void fileReader() {
        try {
            Path filePath = Paths.get("sample.txt");
            String content = Files.readString(filePath);
            String[] split_content = content.split(" ");
            System.out.println(split_content.length);
            String ref = "@softwire.com";
            ArrayList<String> foundEmails = new ArrayList<>();
            for (String each_str : split_content) {

                String resp = each_str.substring(0, each_str.length()).contains(ref) ? ref : "";
                if (!resp.isEmpty()) {
                    foundEmails.add(each_str);
                }
            }
            System.out.println(foundEmails);
            System.out.printf("Total Emails Found: %s", foundEmails.size());
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("File not found");
        }

    }
}

