package commands;

import managers.CollectionManager;

public class ClearCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public ClearCommand (CollectionManager collectionManager){
        super(CommandType.NON_ARG);
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute() throws Exception {
        if (collectionManager.getCollection().size()==0) throw new Exception("Collection is empty!!!!");
        collectionManager.clear();
        System.out.println("Collection has been successfully cleared!!!");
    }

    @Override
    public String getDescription() {
        return "removes all elements from the collection.";
    }
}
