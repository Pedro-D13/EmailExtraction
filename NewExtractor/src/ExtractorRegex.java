import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExtractorRegex {
    public static void main(String[] args) {
        /* Todo
         *   Create a File Reader method that returns a string
         *   Compile and create a pattern matcher
         *   collect all the matched patterns
         * */
        String fileName = askForFile();
        String fileContent = fileReader(fileName);
        patternMatch(fileContent);
    }

    public static void patternMatch(String fileContent) {
//        String softWireRegex = "\\w+@softwire.com\\b";
        String regexFullEmailPattern = "\"(?<user>[.\\w_]+)(?<domain>@[\\w\\-]+(?:\\.[\\w\\-]+){1,2}\\s)\"gi";
//        String regexEmailPattern = "@\\w+[a-z]\\.[a-z|\\.]*";
        Pattern pattern = Pattern.compile(regexFullEmailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(fileContent);
        ArrayList<String> arrOfMatches = new ArrayList<>();
//        boolean matchFound = matcher.find();
        while (matcher.find()) {
            arrOfMatches.add(matcher.group());
        }
        System.out.printf("\nNo. of matches found were: %s\n", arrOfMatches.size());

        // System.out.println(Arrays.toString(arrOfMatches.toArray()));
        // figure out a way to output the information in an easily read manner
    }


    public static String fileReader(String fileName) {
        String content = "";
        try {
            Path filePath = Paths.get(fileName);
            content = Files.readString(filePath);
            System.out.printf("File found:%s", fileName);
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return content;
    }

    public static String askForFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please write the name of the file (defaults to sample.txt if no input is provided)");
        String fileName = scanner.nextLine();
        return fileName.isEmpty() ? "sample.txt" : fileName;
    }
}
