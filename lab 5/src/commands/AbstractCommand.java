package commands;

public abstract class AbstractCommand {
    private static String arg ="";
    private CommandType commandType;
    public AbstractCommand(CommandType commandType){
        this.commandType = commandType;
    }
    public static String getArg() {
        return arg;
    }

    public static void setArg(String ar) {
       arg = ar;
    }
    public abstract void execute()throws Exception;
    public abstract String getDescription ();

    public CommandType getCommandType() {
        return commandType;
    }
}
