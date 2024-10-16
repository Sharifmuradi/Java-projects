package commands;
import csv.CSVSerializer;
import managers.*;
public class SaveCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private FileManager fileManager;
    private CSVSerializer serializer;
    public SaveCommand(CollectionManager collectionManager,FileManager fileManager){
        super (CommandType.NON_ARG);
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
        serializer = new CSVSerializer(collectionManager.getCollection());
    }
    @Override
    public void execute() throws Exception {
        String csv = serializer.serialize();
        try {
            if (collectionManager.getCollection().isEmpty()) throw new Exception("Collection is empty!!!!");
            boolean success = fileManager.write(csv);
            if (success) System.out.println("Collection has been successfully written in the file.");
            else throw new Exception ("Couldn't save the collection in the file.");
        }catch (Exception exception){
            throw new Exception (exception.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "Save collection into the file.";
    }
}
