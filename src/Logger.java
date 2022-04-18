import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Logger {
    private String tag;

    public Logger(String tag){
        this.tag = tag;

        File file = new File("C:\\Users\\Kuroneko\\IdeaProjects\\Loggers\\src\\logs\\" + this.tag + ".txt");
        try{
            if(file.createNewFile()) {
                System.out.println("New logger is created");

//                List<String> lines = Arrays.asList("The first line", "The second line");
//                Path file1 = Paths.get(tag + ".txt");
//                Files.write(file1, lines, StandardCharsets.UTF_8);

                try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(tag + ".txt"), "utf-8"))) {
                    writer.write("something");
                } catch(IOException ex){
                    ex.printStackTrace();
                }

            }else{
                System.out.println("This logger is already exists");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}