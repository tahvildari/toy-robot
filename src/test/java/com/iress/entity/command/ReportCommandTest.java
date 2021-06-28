package com.iress.entity.command;

import com.iress.common.exception.ValidationException;
import com.iress.entity.position.Direction;
import com.iress.entity.position.Position;
import com.iress.service.position.PositionService;
import org.junit.Assert;
import org.junit.Test;


public class ReportCommandTest {

    @Test()
    public void placeInsideSuccessfully() throws ValidationException {
        PositionService.setCurrentPosition(new Position(1, 1, Direction.NORTH));
        Assert.assertEquals(new Position(1, 1, Direction.NORTH), PositionService.getCurrentPosition());
    }


}
