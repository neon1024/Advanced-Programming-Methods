package view.cli;

import exceptions.RepositoryException;
import model.adts.*;
import controller.Controller;
import model.ProgramState;
import model.statements.Statement;
import repository.IRepository;
import repository.Repository;
import view.commands.ExitCommand;
import view.commands.RunExampleCommand;
import programGenerator.ProgramGenerator;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class CLIInterpreter {
    public static void main(String[] args) {
        TextMenu menu = new TextMenu();

        try {
            CLIInterpreter.addCommands(CLIInterpreter.getLogFile(), menu);

        } catch (RepositoryException re) {
            System.out.println(re.getMessage());
        }

        menu.show();
    }

    private static String getLogFile() throws RepositoryException {
        String logFilePath = "./logs/";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the log file name: ");
        String input = scanner.nextLine();

        if (Objects.equals(input, "")) {
            logFilePath += "log.txt";

        } else  {
            logFilePath += input;
        }

        // if the file already exists, delete it and create a new one
        File file = new File(logFilePath);

        if(file.exists() && file.isFile()) {
            if(!file.delete()) {
                throw new RepositoryException("[!] Couldn't delete the already existing log file.");
            }
        }

        return logFilePath;
    }

    private static void addCommands(String logFilePath, TextMenu menu) {
        List<Statement> programs = ProgramGenerator.getPrograms();

        System.out.println(programs.size());

        for (int i = 0; i < programs.size(); i++) {
            Statement program = programs.get(i);

            ProgramState programState = new ProgramState(program, new MyStack<>(), new MyDictionary<>(),
                    new MyHeap(), new MyConcurrentDictionary<>(), new MyList<>(), new MyLockTable());
            IRepository repository = new Repository(programState, logFilePath);
            Controller controller = new Controller(repository, true);

            menu.addCommand(new RunExampleCommand(String.valueOf(i + 1), "run example " + (i + 1), controller));
        }

        menu.addCommand(new ExitCommand("0", "exit"));
    }
}
