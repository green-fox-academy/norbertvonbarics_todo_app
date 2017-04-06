import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Todo {
  private static final String DATAPATH = "./assets/data.csv";

  public static void main(String[] args) {
    String userInput = "";
    List<String> todoList = readFiles();

    if (args.length == 0) {
      System.out.println("JAVA!!! Todo application\n" +
              "=======================\n" +
              "\n" +
              "Command line arguments:\n" +
              " -l   Lists all the tasks\n" +
              " -a   Adds a new task\n" +
              " -r   Removes an task\n" +
              " -c   Completes an task");
    } else if (args[0].equals("-l")) {
      System.out.println(todoList);
      for (int i = 0; i < todoList.size(); i++) {
        System.out.println(i + 1 + " - " + todoList.get(i));
      }

    } else if (args[0].equals("-a")) {
      userInput = args[1];
      todoList.add(userInput);
      writeToFile(todoList);
      System.out.println("Task " + userInput + " added to ToDo list!");

    } else if (args[0].equals("-r")) {
      String remove = todoList.get(Integer.parseInt(args[1])-1);
      todoList.remove(Integer.parseInt(args[1])-1);
      writeToFile(todoList);
      System.out.println("Task " + remove + " removed from ToDo list!");

    } else if (args[0].equals("-c")) {
      System.out.println("this is a");
    }
  }

  public static List<String> readFiles() {
    List<String> rawLines = new ArrayList<>();
    Path myPath = Paths.get(DATAPATH);
    try {
      rawLines = Files.readAllLines(myPath);
    } catch (IOException ex) {
      System.out.println("SYNTAX ERROR");
    }
    return rawLines;
  }

  private static void writeToFile(List<String> data) {
    Path myPath = Paths.get(DATAPATH);
    try {
      Files.write(myPath, data);
    } catch (IOException ex) {
      System.out.println("SYNTAX ERROR");
    }
  }
}

