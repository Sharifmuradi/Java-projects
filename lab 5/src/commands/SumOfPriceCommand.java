package commands;

import managers.CollectionManager;

public class SumOfPriceCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public SumOfPriceCommand (CollectionManager collectionManager){
        super (CommandType.NON_ARG);
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute() throws Exception {
        if (collectionManager.getCollection().isEmpty()) throw new Exception ("Collection is empty!!");
        System.out.println(collectionManager.sumOfPrice());
    }

    @Override
    public String getDescription() {
        return "Displays summation of product prices.";
    }
}
