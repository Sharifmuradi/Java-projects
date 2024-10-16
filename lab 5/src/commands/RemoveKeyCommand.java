package commands;

import managers.CollectionManager;

public class RemoveKeyCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public RemoveKeyCommand (CollectionManager collectionManager){
        super (CommandType.ARG);
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute() throws Exception {
        if (collectionManager.getCollection().isEmpty())throw new Exception("Collection is empty!!!!");
        String key = getArg();
        if (key.equals(""))throw new Exception ("No key was passed!!!!");
        try {
            Integer k = Integer.parseInt(key);
            if (!collectionManager.removeKey(k)) throw new Exception ("Can't remove the key and it's element because either there isn't such key  or couldn't be removed.");
            System.out.println("Key with its value has been removed from the collecton.");
        }catch (NumberFormatException exception ){
            throw new Exception ("Key should be a number!!!");
        }
    }

    @Override
    public String getDescription() {
        return "Remove from the collection element that its key is equals to given key.";
    }
}
