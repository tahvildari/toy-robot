package com.iress.service.position;

import com.iress.common.exception.ValidationException;
import com.iress.entity.command.CommandType;
import com.iress.entity.position.Direction;
import com.iress.entity.position.Position;
import com.iress.entity.table.Table;

import java.util.LinkedList;

public class PositionService {

    private PositionService() {
        throw new IllegalStateException("Utility class cannot be instantiated.");
    }

    private static Position currentPosition = null;

    public static Position getCurrentPosition() {
        return currentPosition;
    }

    public static void setCurrentPosition(Position currentPosition) {
        PositionService.currentPosition = currentPosition;
    }

    public static void changeRobotDirection(CommandType commandType) {
        currentPosition.setFace(getNextFace(currentPosition.getFace(), commandType));
    }

    public static Direction getNextFace(Direction currentDirection, CommandType commandType) {

        LinkedList<Object> directions = getDirections();
        int indexOfDirection = directions.indexOf(currentDirection);

        switch (commandType) {
            case RIGHT: {
                if (directions.listIterator(indexOfDirection + 1).hasNext()) {
                    return (Direction) directions.listIterator(indexOfDirection + 1).next();
                } else {
                    return (Direction) directions.getFirst();
                }
            }
            case LEFT: {
                if (directions.listIterator(indexOfDirection).hasPrevious()) {
                    return (Direction) directions.listIterator(indexOfDirection).previous();
                } else {
                    return (Direction) directions.getLast();
                }
            }
            default:
                throw new ValidationException("The entered command is not valid", commandType, getCurrentPosition());
        }

    }

    private static LinkedList<Object> directions = null;

    private static LinkedList<Object> getDirections() {
        if (directions == null) {
            directions = new LinkedList<>();
            directions.add(Direction.NORTH);
            directions.add(Direction.EAST);
            directions.add(Direction.SOUTH);
            directions.add(Direction.WEST);
        }
        return directions;
    }

    public static Position getNextMovePosition(Position position) {
        int nextX = position.getX();
        int nextY = position.getY();

        if (position.getFace() == Direction.NORTH) {
            nextY += 1;
        } else if (position.getFace() == Direction.EAST) {
            nextX += 1;
        } else if (position.getFace() == Direction.SOUTH) {
            nextY -= 1;
        } else if (position.getFace() == Direction.WEST) {
            nextX -= 1;
        }
        return new Position(nextX, nextY, position.getFace());
    }

    public static boolean isInsideTable(Position position) {
        return (position.getX() >= 0 && position.getX() <= Table.getWidth() - 1)
                && (position.getY() >= 0 && position.getY() <= Table.getLength() - 1);
    }

}
