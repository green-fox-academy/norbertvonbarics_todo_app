import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Todo {
  private static final String DATAPATH = "./assets/data.csv";
  private static final String LINE = "=======================================\n";
  private static final String USAGE = "JAVA!!! Todo application\n" +
          "=======================\n" +
          "\n" +
          "Command line arguments:\n" +
          " -l   Lists all the tasks\n" +
          " -a   Adds a new task\n" +
          " -r   Removes an task\n" +
          " -c   Completes an task";

  public static void main(String[] args) {
    String userInput = "";
    List<String> todoList = readFiles();

    if (args.length == 0) {
      Ascii logo = new Ascii();
      logo.printAscii();
      System.out.println(USAGE);

    } else if (args[0].equals("-l")) {
      printUncomplete(todoList);

    } else if (args[0].equals("-la")) {
      print(todoList);

    } else if (args[0].equals("-a")) {
      if (args.length == 1) {
        lineBreak();
        System.out.println(LINE + "No task provided!\n" + LINE);

      } else {
        userInput = "[ ] " + args[1];
        todoList.add(userInput);
        lineBreak();
        System.out.println("Task " + userInput + " added to ToDo list!");
        writeToFile(todoList);
        print(todoList);
      }

    } else if (args[0].equals("-r")) {
      if (args.length == 1) {
        lineBreak();
        System.out.println(LINE + "Unable to remove: no index provided\n" + LINE);
      } else {
        String remove = todoList.get(Integer.parseInt(args[1]) - 1).substring(4);
        todoList.remove(Integer.parseInt(args[1]) - 1);
        lineBreak();
        System.out.println("Task " + remove + " removed from ToDo list!");
        writeToFile(todoList);
        print(todoList);
      }
    } else if (args[0].equals("-c")) {
      if (todoList.size() < Integer.parseInt(args[1])) {
        lineBreak();
        System.out.println(LINE + "Unable to check: index is out of bound!\n" + LINE);

      } else {
        String tempTask = todoList.get(Integer.parseInt(args[1]) - 1).substring(3);
        int tempInt = Integer.parseInt(args[1]) - 1;
        todoList.set(tempInt, "[X]" + tempTask);
        lineBreak();
        writeToFile(todoList);
      }
      print(todoList);

    } else {
      lineBreak();
      System.out.println(LINE + "Unsupported argument!\n" + LINE);
      lineBreak();
      System.out.println(USAGE);
    }
  }

  private static List<String> readFiles() {
    List<String> rawLines = new ArrayList<>();
    Path myPath = Paths.get(DATAPATH);
    try {
      rawLines = Files.readAllLines(myPath);
    } catch (IOException ex) {
      System.out.println("SYNTAX ERROR + (READ)");
    }
    return rawLines;
  }

  private static void writeToFile(List<String> data) {
    Path myPath = Paths.get(DATAPATH);
    try {
      Files.write(myPath, data);
    } catch (IOException ex) {
      System.out.println("SYNTAX ERROR + (WRITE)");
    }
  }

  private static void print(List todoList) {
    lineBreak();
    for (int i = 0; i < todoList.size(); i++) {
      System.out.println(i + 1 + " - " + todoList.get(i));
    }
  }

  private static void printUncomplete(List todoList) {
    lineBreak();
    for (int j = 0; j < todoList.size(); j++) {
      if (todoList.get(j).toString().substring(0, 3).equals("[ ]")) {
        System.out.println(todoList.get(j));
      }
    }
  }

  private static void lineBreak() {
    System.out.println("");
  }
}

