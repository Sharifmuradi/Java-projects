package commands;

import managers.CollectionManager;
import managers.InputManager;

public class UpdateCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private InputManager inputManager;
    public UpdateCommand(CollectionManager collectionManager) {
        super(CommandType.ARG);
        this.collectionManager = collectionManager;
        this.inputManager = new InputManager();
    }

    @Override
    public void execute() throws Exception {
        try{
            String stringId = getArg();
            if (stringId.equals(""))throw new Exception ("Id was not passed!!!!");
            Long id = Long.parseLong(stringId);
            if (!collectionManager.update(id,inputManager.readProduct())) throw new Exception ("Couldn't update the product because there was no products with such id.");
            else System.out.println("Product with id of #"+id+"# has been updated successfully!!!!");
        }catch (NumberFormatException exception){
            throw new Exception (exception.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "Updates elements with the given id.";
    }
}
