package commands;

import managers.CollectionManager;

public class ShowCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public ShowCommand(CollectionManager collectionManager){
        super(CommandType.NON_ARG);
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() throws Exception {
        if (collectionManager.getCollection().size()==0) throw new Exception("Collection is empty!!!");
        System.out.println("=".repeat(50));
        collectionManager.getCollection().forEach((k,p)->{
            System.out.println("-".repeat(50)+"\n"+p+"\n"+"-".repeat(50)+"\n");
        });
        System.out.println("=".repeat(50));
    }

    @Override
    public String getDescription() {
        return "Shows elements that are currently stored in the collection.";
    }
}
