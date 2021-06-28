package com.iress.entity.command;

import com.iress.common.exception.ValidationException;
import com.iress.entity.position.Position;
import com.iress.service.position.PositionService;

/**
 * The PlaceCommand set the current position of the robot on the table.
 * The allowed positions are inside the table and any position to outside of the table will be ignored.
 */
public class PlaceCommand extends AbstractCommand {

    public PlaceCommand(Position position) {
        this.commandType = CommandType.PLACE;
        this.position = position;
    }

    @Override
    public void validate() {
        super.validate();
        if (!PositionService.isInsideTable(this.position)) {
            throw new ValidationException("The place is outside of the table.", commandType, position);
        }
    }

    @Override
    public Position execute() {
        PositionService.setCurrentPosition(position);
        return PositionService.getCurrentPosition();

    }
}
