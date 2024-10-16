package managers;

import commands.*;

import java.util.HashMap;

public class CommandManager {
    private CollectionManager collectionManager;
    private InputManager inputManager;
    private FileManager fileManager;
    private static HashMap<String, AbstractCommand> commandMap = new HashMap<>();
    public CommandManager (CollectionManager collectionManager,FileManager fileManager){
        this.collectionManager = collectionManager;
        this.inputManager = new InputManager();
        this.fileManager = fileManager;
        initialize();
    }
    private void initialize (){
        commandMap.put("insert",new InsertCommand(collectionManager));
        commandMap.put("update",new UpdateCommand(collectionManager));
        commandMap.put("show",new ShowCommand(collectionManager));
        commandMap.put("clear",new ClearCommand(collectionManager));
        commandMap.put("info",new InfoCommand(collectionManager));
        commandMap.put("exit",new ExitCommand());
        commandMap.put("print_field_descending_price",new PrintFieldDescendingPriceCommand(collectionManager));
        commandMap.put("remove_greater",new RemoveGreaterCommand(collectionManager));
        commandMap.put("remove_lower",new RemoveLowerCommand(collectionManager));
        commandMap.put("remove_key",new RemoveKeyCommand(collectionManager));
        commandMap.put("remove_lower_key_command",new RemoveLowerKeyCommand(collectionManager));
        commandMap.put("help",new HelpCommand());
        commandMap.put("sum_of_price",new SumOfPriceCommand(collectionManager));
        commandMap.put("average_of_price",new AverageOfPriceCommand(collectionManager));
        commandMap.put("save",new SaveCommand(collectionManager,fileManager));
    }

    public static HashMap<String, AbstractCommand> getCommandMap() {
        return commandMap;
    }

    public void runCommand (){
        String command = "";
        String arg = "";
        while(true){
            try{
                String input = inputManager.readCommand();
                if (input.contains(" ")){
                    command = input.split(" ",2)[0];
                    arg = input.split(" ",2)[1];
                    if (command.equals("insert")|| command.equals("update") || command.equals("remove_key")){
                        try {
                            Double.parseDouble(arg);
                        }catch (NumberFormatException exception ){
                            throw new Exception ("Arg should be a number in this command");
                        }
                    }
                }else command = input;
                if (!commandMap.containsKey(command))throw new Exception ("No such command!!!!!");
                if (commandMap.get(command).getCommandType().equals(CommandType.ARG))
                    AbstractCommand.setArg(arg);
                commandMap.get(command).execute();
            }catch (Exception exception ){
                System.err.println(exception.getMessage());
            }
        }
    }
}
