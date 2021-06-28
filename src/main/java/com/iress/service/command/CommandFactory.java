package com.iress.service.command;

import com.iress.common.exception.InvalidCommandException;
import com.iress.entity.command.*;
import com.iress.entity.position.Position;
import com.iress.service.position.PositionService;

public class CommandFactory {

    public Command getCommand(String commandStr) throws InvalidCommandException {
        CommandType commandType = getCommandType(commandStr);
        Position currentPosition = PositionService.getCurrentPosition();

        switch (commandType) {
            case PLACE: {
                try {
                    Position position = new Position(commandStr.split(" ")[1]);
                    return new PlaceCommand(position);
                } catch (Exception e) {
                    throw new InvalidCommandException("ERROR: The entered arguments are invalid.");
                }
            }
            case MOVE: {
                return new MoveCommand(currentPosition);
            }
            case LEFT: {
                return new LeftCommand(currentPosition);
            }
            case RIGHT: {
                return new RightCommand(currentPosition);
            }
            case REPORT: {
                return new ReportCommand(currentPosition);
            }
            default:
                return null;
        }
    }

    private CommandType getCommandType(String commandStr) throws InvalidCommandException {
        try {
            return CommandType.valueOf(commandStr.split(" ")[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandException("ERROR: Invalid command '" + commandStr + "'");
        }
    }
}
