package repository;

import model.adts.IDictionary;
import model.adts.IHeap;
import exceptions.RepositoryException;
import model.ProgramState;
import model.values.Value;

import java.util.List;

public interface IRepository {

    List<ProgramState> getProgramStateList();

    void setProgramStateList(List<ProgramState> programStateList);

    IHeap getHeap();

    IDictionary<String, Value> getSymbolTable();

    void logProgramStateExecution(ProgramState programState) throws RepositoryException;
}
