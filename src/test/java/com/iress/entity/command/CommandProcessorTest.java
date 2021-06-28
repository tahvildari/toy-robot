package com.iress.entity.command;

import com.iress.service.command.CommandProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CommandProcessorTest {

    @Test()
    public void processorCallsCommandMethodsSuccessfully() {
        CommandProcessor commandProcessor = new CommandProcessor();

        MoveCommand moveCommand = Mockito.mock(MoveCommand.class);
        commandProcessor.process(moveCommand);
        // verify the processor is calling the command methods correctly
        verify(moveCommand, times(1)).validate();
        verify(moveCommand, times(1)).execute();

        PlaceCommand placeCommand = Mockito.mock(PlaceCommand.class);
        commandProcessor.process(placeCommand);
        // verify the processor is calling the command methods correctly
        verify(placeCommand, times(1)).validate();
        verify(placeCommand, times(1)).execute();
    }

}
