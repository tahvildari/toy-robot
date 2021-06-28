package com.iress.entity.command;

import com.iress.common.exception.ValidationException;
import com.iress.entity.position.Direction;
import com.iress.entity.position.Position;
import com.iress.entity.table.Table;
import org.junit.Assert;
import org.junit.Test;


public class PlaceCommandTest {


    @Test(expected = ValidationException.class)
    public void moveOutsideWest_validate() throws ValidationException {
        (new PlaceCommand(new Position(-1, 0, Direction.WEST))).validate();
    }

    @Test(expected = ValidationException.class)
    public void moveOutsideSouth_validate() throws ValidationException {
        (new PlaceCommand(new Position(Table.getWidth(), 0, Direction.SOUTH))).validate();
    }

    @Test(expected = ValidationException.class)
    public void moveOutsideEast_validate() throws ValidationException {
        (new PlaceCommand(new Position(0, -1, Direction.EAST))).validate();
    }

    @Test(expected = ValidationException.class)
    public void moveOutsideNorth_validate() throws ValidationException {
        (new PlaceCommand(new Position(0, Table.getLength(), Direction.NORTH))).validate();
    }

    @Test()
    public void placeInsideSuccessfully() throws ValidationException {
        Assert.assertEquals(new Position(1, 1, Direction.NORTH), (new PlaceCommand(new Position(1, 1, Direction.NORTH))).execute());
    }

    @Test()
    public void placeSuccessfully() throws ValidationException {
        Assert.assertEquals(new Position(6, 6, Direction.NORTH), (new PlaceCommand(new Position(6, 6, Direction.NORTH))).execute());
    }


}
