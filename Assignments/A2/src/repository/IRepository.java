package repository;

import model.ProgramState;

import java.io.IOException;
import java.util.List;

public interface IRepository {
    void addProgramState(ProgramState programState);
    void logProgramStateExecution(ProgramState programState) throws IOException;
    List<ProgramState> getProgramStates();
    void setProgramState(List<ProgramState> programStates);

    ProgramState getCurrentProgramState();
}
