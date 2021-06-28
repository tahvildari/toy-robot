package com.iress.entity.command;

import com.iress.common.exception.ValidationException;
import com.iress.entity.position.Position;

public interface Command {

    void validate() throws ValidationException;

    Position execute();


}
