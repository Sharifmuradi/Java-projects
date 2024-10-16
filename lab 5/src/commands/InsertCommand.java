package commands;

import managers.CollectionManager;
import managers.InputManager;

public class InsertCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private InputManager inputManager;
    public InsertCommand (CollectionManager collectionManager){
        super(CommandType.ARG);
        this.collectionManager = collectionManager;
        this.inputManager = new InputManager();
    }

    @Override
    public void execute() throws Exception {
        try{
            String k = getArg();
            if (k.equals("")) throw new Exception ("Key can't be empty !!!!");
            Integer key = Integer.parseInt(k);
            collectionManager.insert(key,inputManager.readProduct());
        }catch (NumberFormatException exception){
            throw new Exception ("Invalid key!!!");
        }
    }

    @Override
    public String getDescription() {
        return "Inserts elements in the collection with the given key.";
    }
}
