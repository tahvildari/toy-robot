package com.iress.entity.position;


import com.iress.entity.command.CommandType;
import com.iress.service.position.PositionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PositionServiceTest {

    @Test()
    public void isInsideTable() {
        assertTrue(PositionService.isInsideTable(new Position(0, 0, Direction.EAST)));
        assertTrue(PositionService.isInsideTable(new Position(0, 4, Direction.EAST)));
        assertTrue(PositionService.isInsideTable(new Position(4, 0, Direction.EAST)));
        assertTrue(PositionService.isInsideTable(new Position(3, 3, Direction.EAST)));
        assertFalse(PositionService.isInsideTable(new Position(-1, 0, Direction.EAST)));
        assertFalse(PositionService.isInsideTable(new Position(-1, -1, Direction.EAST)));
        assertFalse(PositionService.isInsideTable(new Position(-0, -1, Direction.EAST)));
        assertFalse(PositionService.isInsideTable(new Position(5, 0, Direction.EAST)));
        assertFalse(PositionService.isInsideTable(new Position(0, 5, Direction.EAST)));
        assertFalse(PositionService.isInsideTable(new Position(5, 5, Direction.EAST)));
    }

    @Test()
    public void getNextMovePosition() {
        assertEquals(PositionService.getNextMovePosition(new Position(0, 0, Direction.NORTH)), new Position(0, 1, Direction.NORTH));
        assertEquals(PositionService.getNextMovePosition(new Position(0, 0, Direction.EAST)), new Position(1, 0, Direction.EAST));
        assertEquals(PositionService.getNextMovePosition(new Position(0, 0, Direction.WEST)), new Position(-1, 0, Direction.WEST));
        assertEquals(PositionService.getNextMovePosition(new Position(0, 0, Direction.SOUTH)), new Position(0, -1, Direction.SOUTH));
        assertEquals(PositionService.getNextMovePosition(new Position(2, 2, Direction.WEST)), new Position(1, 2, Direction.WEST));
        assertEquals(PositionService.getNextMovePosition(new Position(2, 5, Direction.EAST)), new Position(3, 5, Direction.EAST));
    }

    @Test
    public void changeRobotDirection() {
        PositionService.setCurrentPosition(new Position(2, 5, Direction.NORTH));

        PositionService.changeRobotDirection(CommandType.LEFT);
        assertEquals(PositionService.getCurrentPosition(), new Position(2, 5, Direction.WEST));

        PositionService.changeRobotDirection(CommandType.LEFT);
        assertEquals(PositionService.getCurrentPosition(), new Position(2, 5, Direction.SOUTH));

        PositionService.changeRobotDirection(CommandType.LEFT);
        assertEquals(PositionService.getCurrentPosition(), new Position(2, 5, Direction.EAST));

        PositionService.changeRobotDirection(CommandType.LEFT);
        assertEquals(PositionService.getCurrentPosition(), new Position(2, 5, Direction.NORTH));


        PositionService.changeRobotDirection(CommandType.RIGHT);
        assertEquals(PositionService.getCurrentPosition(), new Position(2, 5, Direction.EAST));

        PositionService.changeRobotDirection(CommandType.RIGHT);
        assertEquals(PositionService.getCurrentPosition(), new Position(2, 5, Direction.SOUTH));

        PositionService.changeRobotDirection(CommandType.RIGHT);
        assertEquals(PositionService.getCurrentPosition(), new Position(2, 5, Direction.WEST));

        PositionService.changeRobotDirection(CommandType.RIGHT);
        assertEquals(PositionService.getCurrentPosition(), new Position(2, 5, Direction.NORTH));

        PositionService.changeRobotDirection(CommandType.RIGHT);
        PositionService.changeRobotDirection(CommandType.RIGHT);
        PositionService.changeRobotDirection(CommandType.LEFT);
        PositionService.changeRobotDirection(CommandType.RIGHT);
        assertEquals(PositionService.getCurrentPosition(), new Position(2, 5, Direction.SOUTH));
    }


}
