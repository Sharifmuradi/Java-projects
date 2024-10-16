package commands;

import managers.CollectionManager;

public class RemoveLowerKeyCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public RemoveLowerKeyCommand (CollectionManager collectionManager){
        super(CommandType.ARG);
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute() throws Exception {
        if (collectionManager.getCollection().isEmpty()) throw new Exception("Collection is empty !!!!");
        String key = getArg();
        if (key.equals("")) throw new Exception ("No key has been passed!!!");
        try {
            Integer k = Integer.parseInt(key);
            if (!collectionManager.removeLowerKey(k)) throw new Exception ("Can't remove the key either it doesn't exist or couldn't be removed.");
        }catch (NumberFormatException exception ){
            throw new Exception ("Key should be a number!!!!");
        }
    }

    @Override
    public String getDescription() {
        return "Removes all keys and their values from the collection which equals to the given one.";
    }
}
