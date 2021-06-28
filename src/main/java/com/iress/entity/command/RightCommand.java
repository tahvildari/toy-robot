package com.iress.entity.command;

import com.iress.entity.position.Position;
import com.iress.service.position.PositionService;

/**
 * This command change the face of the robot to the next right direction.
 */
public class RightCommand extends AbstractCommand {

    public RightCommand(Position position) {
        this.commandType = CommandType.RIGHT;
        this.position = position;
    }

    @Override
    public Position execute() {
        PositionService.changeRobotDirection(CommandType.RIGHT);
        return position;

    }
}
