package commands;

import managers.CommandManager;

public class HelpCommand extends AbstractCommand{
    public HelpCommand(){
        super(CommandType.NON_ARG);
    }
    @Override
    public void execute() throws Exception {
        System.out.println("=".repeat(50));
        CommandManager.getCommandMap().forEach((s,c)->{
            System.out.println(s+"   :"+c.getDescription());
        });
        System.out.println("=".repeat(50));
    }

    @Override
    public String getDescription() {
        return "Shows commands and their description.";
    }
}
