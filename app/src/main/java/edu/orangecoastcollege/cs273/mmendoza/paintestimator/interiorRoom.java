package edu.orangecoastcollege.cs273.mmendoza.paintestimator;

/**
 * Created on 9/19/2017.
 */

public class interiorRoom
{
    public static final float DOOR_AREA = 21f;
    public static final float WINDOW_AREA = 16f;
    public static final float SQ_FEET_PER_GALLON = 275f;

    private float mLength;
    private float mWidth;
    private float mHeight;

    private int mDoors;
    private int mWindows;

    /**
     * Get the length of a room
     *
     * @return the length
     */
    public float getLength()
    {
        return mLength;
    }

    /**
     * Sets the length of the room to a new length
     * @param length The new length of the room
     */
    public void setLength(float length)
    {
        mLength = length;
    }

    /**
     * Get the width of a room
     *
     * @return the width
     */
    public float getWidth()
    {
        return mWidth;
    }

    /**
     * Set the width of the room to a new width
     *
     * @param width The new width
     */
    public void setWidth(float width) {
        mWidth = width;
    }

    /**
     * Gets the height of a room
     *
     * @return The height
     */
    public float getHeight() {
        return mHeight;
    }

    /**
     * Sets the height of a room
     *
     * @param height The new height
     */
    public void setHeight(float height) {
        mHeight = height;
    }

    /**
     * Gets the number of doors in a room
     *
     * @return The number of doors
     */
    public int getDoors() {
        return mDoors;
    }

    /**
     * Sets the number of doors in a room
     *
     * @param doors The new number of doors
     */
    public void setDoors(int doors) {
        mDoors = doors;
    }

    /**
     * Gets the number of windows in a room
     *
     * @return The number of windows
     */
    public int getWindows() {
        return mWindows;
    }

    /**
     * Sets the number of windows in a room
     *
     * @param windows The new number of windows
     */
    public void setWindows(int windows) {
        mWindows = windows;
    }

    /**
     * Calculates the doors + windows surface area
     * doors * door area * windows * window area
     *
     * @return The surface area of the doors and windows
     */
    public float doorAndWindowArea()
    {
        return mDoors * DOOR_AREA * mWindows * WINDOW_AREA;
    }

    /**
     * Calculates the walls surface area
     * 2 * length * height + 2 * width + length * width
     *
     * @return The surface area of the walls
     */
    public float wallSurfaceArea()
    {
        return 2 * mLength * mHeight + 2 * mWidth + mLength * mWidth;
    }

    /**
     * Calculates the total surface area to be painted
     * wallSurfaceArea - doorsAndWindowArea
     *
     * @return The surface area to be painted
     */
    public float totalSurfaceArea()
    {
        return wallSurfaceArea() - doorAndWindowArea();
    }

    /**
     * Calculates the gallons of paint required to paint the total surface area
     * Total surface area / square feet per gallons
     *
     * @return The gallons of paint required
     */
    public float gallonsOfPaintRequired()
    {
        return totalSurfaceArea() / SQ_FEET_PER_GALLON;
    }
}
