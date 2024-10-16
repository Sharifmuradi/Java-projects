package commands;

public class ExitCommand extends AbstractCommand{
    public ExitCommand(){
        super(CommandType.NON_ARG);
    }
    @Override
    public void execute() throws Exception {
        System.out.println("Program terminates.");
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "Terminates the program.";
    }
}
