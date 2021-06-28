package com.iress.entity.command;

import com.iress.common.exception.ValidationException;
import com.iress.entity.position.Position;

public abstract class AbstractCommand implements Command {

    CommandType commandType;
    Position position;

    public void validate() throws ValidationException {
        if (commandType == null) throw new ValidationException("the commandType  cannot be null", null, null);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }
}
