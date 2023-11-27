package controller;

import exceptions.ExecutionException;
import model.ProgramState;
import repository.IRepository;

public class Controller {

    private final IRepository repository;

    public Controller(IRepository repository) {
        this.repository = repository;
    }

    public ProgramState oneStep(ProgramState programState) throws ExecutionException {

    }

    public ProgramState
}
