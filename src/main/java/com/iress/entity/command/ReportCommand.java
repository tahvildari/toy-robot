package com.iress.entity.command;

import com.iress.entity.position.Position;
import com.iress.service.position.PositionService;

/**
 * This command give a report about the current  position of the robot.
 */
public class ReportCommand extends AbstractCommand {

    public ReportCommand(Position position) {
        this.commandType = CommandType.REPORT;
        this.position = position;
    }


    @Override
    public Position execute() {
        System.out.println("The current position is: " + PositionService.getCurrentPosition());
        return PositionService.getCurrentPosition();
    }
}
