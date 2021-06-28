package com.iress.entity.command;

import com.iress.common.exception.ValidationException;
import com.iress.entity.position.Position;
import com.iress.service.position.PositionService;

/**
 * This command change the position of the robot to the next step by keeping the same direction.
 * The move just allowed inside the table and any movement to outside of the table will be ignored.
 */
public class MoveCommand extends AbstractCommand {

    public MoveCommand(Position position) {
        this.commandType = CommandType.MOVE;
        this.position = position;
    }

    @Override
    public void validate() throws ValidationException {
        super.validate();
        if (!PositionService.isInsideTable(PositionService.getNextMovePosition(this.position))) {
            throw new ValidationException("The next move is outside of the table.", commandType, position);
        }
    }

    @Override
    public Position execute() {
        PositionService.setCurrentPosition(PositionService.getNextMovePosition(position));
        return PositionService.getCurrentPosition();
    }

}
