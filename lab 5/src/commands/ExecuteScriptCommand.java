package commands;

public class ExecuteScriptCommand extends AbstractCommand{
    public ExecuteScriptCommand (){
        super(CommandType.ARG);
    }

    @Override
    public void execute() throws Exception {

    }

    @Override
    public String getDescription() {
        return "Executes commands from the file.";
    }
}
