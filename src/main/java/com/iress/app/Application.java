package com.iress.app;

import com.iress.common.exception.InvalidCommandException;
import com.iress.entity.command.CommandType;
import com.iress.service.command.CommandFactory;
import com.iress.service.command.CommandProcessor;
import com.iress.service.position.PositionService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    public static void main(String[] args) throws IOException {

        CommandFactory commandFactory = new CommandFactory();
        String receivedCommand = "";
        BufferedReader consoleReader = new BufferedReader(
                new InputStreamReader(System.in));
        while (!receivedCommand.equalsIgnoreCase("exit")) {

            if (PositionService.getCurrentPosition() == null) {
                System.out.println("Please enter the position of the robot by using 'PLACE X,Y,F' command :");
                // Reading data using readLine
                receivedCommand = consoleReader.readLine();
                if (receivedCommand != null && !receivedCommand.isEmpty()) {
                    String[] enteredCommandArray = receivedCommand.split(" ");
                    if (enteredCommandArray.length != 2 && !enteredCommandArray[0].equalsIgnoreCase(CommandType.PLACE.toString())) {
                        System.out.println("The first command should be 'PLACE' with required arguments.");
                        continue;
                    }
                }
            } else {
                System.out.println("Please enter your command:");
                // Reading command from console
                receivedCommand = consoleReader.readLine();

            }

            CommandProcessor commandProcessor = new CommandProcessor();
            try {
                commandProcessor.process(commandFactory.getCommand(receivedCommand));

            } catch (InvalidCommandException ice) {
                System.out.println("ERROR: Invalid Command entered.");
            }
            // Printing the read line
            receivedCommand = "";
        }
    }
}
