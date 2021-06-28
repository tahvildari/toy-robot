package com.iress.entity.command;

import com.iress.common.exception.ValidationException;
import com.iress.entity.position.Direction;
import com.iress.entity.position.Position;
import com.iress.service.position.PositionService;
import org.junit.Assert;
import org.junit.Test;


public class RightCommandTest {

    @Test()
    public void moveNorthSuccessfully() throws ValidationException {
        PositionService.setCurrentPosition(new Position(0, 0, Direction.WEST));
        Assert.assertEquals(new Position(0, 0, Direction.NORTH), (new RightCommand(PositionService.getCurrentPosition())).execute());
    }

    @Test()
    public void moveEastSuccessfully() throws ValidationException {
        PositionService.setCurrentPosition(new Position(0, 0, Direction.NORTH));
        Assert.assertEquals(new Position(0, 0, Direction.EAST), (new RightCommand(PositionService.getCurrentPosition())).execute());
    }

    @Test()
    public void moveWestSuccessfully() throws ValidationException {
        PositionService.setCurrentPosition(new Position(0, 0, Direction.SOUTH));
        Assert.assertEquals(new Position(0, 0, Direction.WEST), (new RightCommand(PositionService.getCurrentPosition())).execute());
    }

    @Test()
    public void moveSouthSuccessfully() throws ValidationException {
        PositionService.setCurrentPosition(new Position(0, 0, Direction.EAST));
        Assert.assertEquals(new Position(0, 0, Direction.SOUTH), (new RightCommand(PositionService.getCurrentPosition())).execute());
    }
}
