package repository;

import model.ProgramState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Repository implements IRepository {
    private List<ProgramState> programStates;
    private String logFilePath;

    public Repository(String logFilePath) {
        this.programStates = new LinkedList<>();

        this.logFilePath = logFilePath;
    }

    @Override
    public void addProgramState(ProgramState programState) {
        this.programStates.add(programState);
    }

    @Override
    public void logProgramStateExecution(ProgramState programState) throws IOException {
        PrintWriter logFile;

        logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
        logFile.println(programState);
        logFile.close();
    }

    public ProgramState getCurrentProgramState() { return this.programStates.getLast(); }

    @Override
    public List<ProgramState> getProgramStates() {
        return this.programStates;
    }

    @Override
    public void setProgramState(List<ProgramState> programStates) {
        this.programStates = programStates;
    }
}
