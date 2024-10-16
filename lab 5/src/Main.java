
import managers.CollectionManager;
import managers.CommandManager;
import managers.FileManager;

public class Main {
    private static String PATH = System.getenv("file");
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager(PATH);
        CommandManager commandManager = new CommandManager(collectionManager,fileManager);
        commandManager.runCommand();
    }
}