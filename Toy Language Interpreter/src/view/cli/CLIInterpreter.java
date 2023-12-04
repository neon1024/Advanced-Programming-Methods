package view.cli;

import model.adts.*;
import controller.Controller;
import model.ProgramState;
import model.statements.Statement;
import repository.IRepository;
import repository.Repository;
import view.commands.ExitCommand;
import view.commands.RunExampleCommand;
import programGenerator.ProgramGenerator;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class CLIInterpreter {
    public static void main(String[] args) {
        TextMenu menu = new TextMenu();
        CLIInterpreter.addCommands(CLIInterpreter.getLogFile(), menu);
        menu.show();
    }

    private static String getLogFile() {
        String logFilePath = "./logs/";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the log file name: ");
        String input = scanner.nextLine();

        if (Objects.equals(input, "")) {
            logFilePath += "log.txt";
        } else  {
            logFilePath += input;
        }

        return logFilePath;
    }

    private static void addCommands(String logFilePath, TextMenu menu) {
        List<Statement> programs = ProgramGenerator.getPrograms();
        for (int i = 0; i < programs.size(); i++) {
            Statement program = programs.get(i);

            ProgramState programState = new ProgramState(program, new MyStack<>(), new MyDictionary<>(),
                    new MyHeap(), new MyDictionary<>(), new MyList<>());
            IRepository repository = new Repository(programState, logFilePath);
            Controller controller = new Controller(repository, true);

            menu.addCommand(new RunExampleCommand(String.valueOf(i + 1), "run example " + (i + 1), controller));
        }

        menu.addCommand(new ExitCommand("0", "exit"));
    }
}
