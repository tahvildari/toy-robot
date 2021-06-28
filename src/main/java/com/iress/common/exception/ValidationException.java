package com.iress.common.exception;

import com.iress.entity.command.CommandType;
import com.iress.entity.position.Position;

public class ValidationException extends RuntimeException {
    public ValidationException(String message, CommandType commandType, Position position) {
        super("Error: " + message + " Command:'" + commandType + "', " + position);
    }
}
