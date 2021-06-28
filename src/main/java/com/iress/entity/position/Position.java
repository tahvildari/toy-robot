package com.iress.entity.position;

public class Position {

    private int x; // width of table, starts from 0
    private int y; // length of table, starts from 0
    private Direction face;

    public Position(int x, int y, Direction face) {
        this.x = x;
        this.y = y;
        this.face = face;
    }

    public Position(String positionStr) {
        String[] positionArray = positionStr.split(",");
        this.x = Integer.parseInt(positionArray[0]);
        this.y = Integer.parseInt(positionArray[1]);
        this.face = Direction.valueOf(positionArray[2].toUpperCase());
    }

    /**
     * @return Get the position of the robot in the width of table
     */
    public int getX() {
        return x;
    }

    /**
     * @return get the position of the robot in the length of table
     */
    public int getY() {
        return y;
    }

    /**
     * @return Get the direction of the robot
     */
    public Direction getFace() {
        return face;
    }

    public void setFace(Direction face) {
        this.face = face;
    }

    @Override
    public String toString() {
        return "{x=" + x +
                ", y=" + y +
                ", face=" + face + '}';
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Position
                && this.getX() == ((Position) obj).getX()
                && this.getY() == ((Position) obj).getY()
                && this.getFace() == ((Position) obj).getFace();
    }
}