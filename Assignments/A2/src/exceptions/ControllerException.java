package exceptions;

import controller.Controller;

public class ControllerException extends Exception {
    public ControllerException(String message) {
        super(message);
    }
}
