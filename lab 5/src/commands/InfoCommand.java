package commands;

import managers.CollectionManager;

public class InfoCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public InfoCommand (CollectionManager collectionManager){
        super (CommandType.NON_ARG);
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute() throws Exception {
        System.out.println(collectionManager.collectionInfo()+"\n");
    }

    @Override
    public String getDescription() {
        return "shows info about collection.";
    }
}
