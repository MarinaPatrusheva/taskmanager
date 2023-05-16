package ru.netology.javacore.typeofcommand;

import ru.netology.javacore.Todos;

import java.util.ArrayList;

public class SetCommand {
    private ArrayList<Command> commands = new ArrayList<>();
    private ArrayList<CommandWithoutParameters> commandWithoutParameters = new ArrayList<>();
    private Todos todos;
    public SetCommand(Todos todos){
        this.todos = todos;
        commands.add(new typeAdd(todos));
        commands.add(new typeRemove(todos));
        commandWithoutParameters.add(new typeRestore(todos));
    }

    public String setCommand(String command, String task) {
        if(task != null) {
            for (int i = 0; i < commands.size(); i++) {
                if (commands.get(i).getTYPE().equals(command)) {
                    return commands.get(i).command(task);
                }
            }
        }else{
            for(int i = 0; i < commands.size(); i++){
                if(commandWithoutParameters.get(i).getTYPE().equals(command)){
                    return commandWithoutParameters.get(i).command();
                }
            }
        }
        return "Неккоректная команда";
    }
}
