package com.iress.service.command;

import com.iress.common.exception.ValidationException;
import com.iress.entity.command.AbstractCommand;
import com.iress.entity.command.Command;
import com.iress.service.position.PositionService;

public class CommandProcessor {

    public void process(Command command) {

        try {
            command.validate();
            command.execute();
            System.out.println("The Command '" + ((AbstractCommand) command).getCommandType() + "' executed. Current position is " + PositionService.getCurrentPosition());
        } catch (ValidationException ve) {
            System.out.println(ve.getMessage());
        }

    }

}
