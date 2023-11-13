package controller;

import exceptions.ControllerException;
import exceptions.DictionaryException;
import exceptions.InterpreterException;
import exceptions.StatementException;
import model.ProgramState;
import model.adt.IStack;
import model.statements.Statement;
import repository.IRepository;

public class Controller {
    IRepository repository;

    public Controller(IRepository repository) {
        this.repository = repository;
    }

    public ProgramState oneStep(ProgramState state) throws ControllerException, StatementException, InterpreterException, DictionaryException {
        IStack<Statement> stack = state.getExecutionStack();

        if(stack.isEmpty()) throw new ControllerException("Program state stack is empty");

        Statement currentStatement = stack.pop();

        return currentStatement.execute(state);
    }

    public void allStep() throws ControllerException, StatementException, InterpreterException, DictionaryException {
        ProgramState programState = this.repository.getCurrentProgramState();

        while(!programState.getExecutionStack().isEmpty()) {
            this.oneStep(programState);
        }
    }
}
