package oop2.summary.m01_Collections.clothing;

/**
 * An exception that is thrown when a Wardrobe is full
 */
public class WardrobeFullException extends Exception {

    /**
     * creates a new WardrobeFullException
     *
     * @param wardrobe the full wardrobe
     */
    public WardrobeFullException(Wardrobe wardrobe) {
        super("The wardrobe can contain maximum "
                + wardrobe.getSize() + " items!");
    }

}
