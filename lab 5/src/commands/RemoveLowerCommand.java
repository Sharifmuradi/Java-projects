package commands;

import managers.CollectionManager;
import managers.InputManager;

public class RemoveLowerCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private InputManager inputManager;
    public RemoveLowerCommand (CollectionManager collectionManager){
        super (CommandType.NON_ARG);
        this.collectionManager = collectionManager;
        this.inputManager = new InputManager();
    }
    @Override
    public void execute() throws Exception {
       if (collectionManager.getCollection().isEmpty())throw new Exception ("Collection is empty!!!!");
       if (!collectionManager.removeLower(inputManager.readProduct())) throw new Exception ("Couldn't remove element lower than the given one because either they don't exist or couldn't be removed. ");
       System.out.println("All elements lower than the given one was removed from the collection successfully.");
    }

    @Override
    public String getDescription() {
        return "Removes from the collection all elements lower than the given one.";
    }
}
