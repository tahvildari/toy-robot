package com.iress.entity.command;

import com.iress.common.exception.ValidationException;
import com.iress.entity.position.Direction;
import com.iress.entity.position.Position;
import com.iress.entity.table.Table;
import org.junit.Assert;
import org.junit.Test;


public class MoveCommandTest {


    @Test(expected = ValidationException.class)
    public void moveOutsideWest_validate() throws ValidationException {
        (new MoveCommand(new Position(0, 2, Direction.WEST))).validate();
    }

    @Test(expected = ValidationException.class)
    public void moveOutsideSouth_validate() throws ValidationException {
        (new MoveCommand(new Position(2, 0, Direction.SOUTH))).validate();
    }

    @Test(expected = ValidationException.class)
    public void moveOutsideEast_validate() throws ValidationException {
        (new MoveCommand(new Position(Table.getWidth() - 1, 0, Direction.EAST))).validate();
    }

    @Test(expected = ValidationException.class)
    public void moveOutsideNorth_validate() throws ValidationException {
        (new MoveCommand(new Position(0, Table.getLength() - 1, Direction.NORTH))).validate();
    }

    @Test()
    public void moveNorthSuccessfully() throws ValidationException {
        Assert.assertEquals(new Position(0, 1, Direction.NORTH), (new MoveCommand(new Position(0, 0, Direction.NORTH))).execute());
    }

    @Test()
    public void moveEastSuccessfully() throws ValidationException {
        Assert.assertEquals(new Position(1, 0, Direction.EAST), (new MoveCommand(new Position(0, 0, Direction.EAST))).execute());
    }

    @Test()
    public void moveWestSuccessfully() throws ValidationException {
        Assert.assertEquals(new Position(0, 0, Direction.WEST), (new MoveCommand(new Position(1, 0, Direction.WEST))).execute());
    }

    @Test()
    public void moveSouthSuccessfully() throws ValidationException {
        Assert.assertEquals(new Position(0, 0, Direction.SOUTH), (new MoveCommand(new Position(0, 1, Direction.SOUTH))).execute());
    }
}
