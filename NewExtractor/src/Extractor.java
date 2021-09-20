
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Extractor {
    public static void main(String[] args) throws FileNotFoundException {
        fileReader();
    }

    private static void fileReader() {
        try {
            Path filePath = Paths.get("sample.txt"); // get sample text
            String content = Files.readString(filePath); // read from the found file
            String[] split_content = content.split(" "); // split the content of the file by space
            System.out.println(split_content.length); // find the length
            String ref = "@softwire.com"; // the string ref, of the sub string we are looking for
            ArrayList<String> foundEmails = new ArrayList<>(); // create an array to store the found emails
            for (String each_str : split_content) {
                String result = each_str.substring(0, each_str.length()).contains(ref) ? ref : "";
                if (!result.isEmpty()) { // if the result is not empty then we've found a string so append it to the array
                    foundEmails.add(each_str);
                }
            }
            System.out.println(foundEmails);
            System.out.printf("Total Emails Found: %s", foundEmails.size());
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }


    public static void sayHi(){
        System.out.println("Hi");
    }
}

