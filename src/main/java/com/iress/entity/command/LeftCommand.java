package com.iress.entity.command;

import com.iress.entity.position.Position;
import com.iress.service.position.PositionService;

/**
 * This command change the face of the robot to the next left direction.
 */
public class LeftCommand extends AbstractCommand {

    public LeftCommand(Position position) {
        this.commandType = CommandType.LEFT;
        this.position = position;
    }


    @Override
    public Position execute() {
        PositionService.changeRobotDirection(CommandType.LEFT);
        return PositionService.getCurrentPosition();

    }
}
