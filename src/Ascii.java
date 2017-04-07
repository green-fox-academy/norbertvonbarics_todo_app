
public class Ascii {
  public void printAscii (){
    System.out.println(" ______   ___   ___     ___       _      ____ _____ ______ \n" +
            "|      | /   \\ |   \\   /   \\     | |    |    / ___/|      |\n" +
            "|      ||     ||    \\ |     |    | |     |  (   \\_ |      |\n" +
            "|_|  |_||  O  ||  D  ||  O  |    | |___  |  |\\__  ||_|  |_|\n" +
            "  |  |  |     ||     ||     |    |     | |  |/  \\ |  |  |  \n" +
            "  |  |  |     ||     ||     |    |     | |  |\\    |  |  |  \n" +
            "  |__|   \\___/ |_____| \\___/     |_____||____|\\___|  |__|  \n" +
            "                                                           \n");
  }

  public void printUsage() {
    System.out.println("JAVA!!! Todo application\n" +
            "=======================\n" +
            "\n" +
            "Command line arguments:\n" +
            " -l   Lists all the tasks\n" +
            " -a   Adds a new task\n" +
            " -r   Removes an task\n" +
            " -c   Completes an task");
  }
}
