package commands;

import managers.CollectionManager;

public class PrintFieldDescendingPriceCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public PrintFieldDescendingPriceCommand (CollectionManager collectionManager){
        super (CommandType.NON_ARG);
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute() throws Exception {
        if (collectionManager.getCollection().isEmpty()) throw new Exception("Collection is empty!!");
        collectionManager.descendingPrice().forEach(System.out::println);
    }

    @Override
    public String getDescription() {
        return "Prints prices in descending order.";
    }
}
