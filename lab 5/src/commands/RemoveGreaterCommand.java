package commands;

import managers.CollectionManager;
import managers.InputManager;

public class RemoveGreaterCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private InputManager inputManager;
    public RemoveGreaterCommand(CollectionManager collectionManager){
        super (CommandType.NON_ARG);
        this.collectionManager = collectionManager;
        this.inputManager = new InputManager();
    }
    @Override
    public void execute() throws Exception {
        if (collectionManager.getCollection().isEmpty())throw new Exception("Collection is empty!!!");
        if(!collectionManager.removeGreater(inputManager.readProduct())) throw new Exception ("Couldn't remove greater elements from the collection, either they don't exist or can't be removed!!!");
        System.out.println("All elements greater than the given one was removed successfully from the collection.");
    }

    @Override
    public String getDescription() {
        return "Removes all elements from the collection greater than the given one.";
    }
}
