package commands;

import managers.CollectionManager;

public class AverageOfPriceCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public AverageOfPriceCommand (CollectionManager collectionManager){
        super(CommandType.NON_ARG);
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute() throws Exception {
        if (collectionManager.getCollection().isEmpty())throw new Exception("Collection is empty!!!");
        System.out.println(collectionManager.averageOfPrice());
    }

    @Override
    public String getDescription() {
        return "Display average price of products.";
    }
}
