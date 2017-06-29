package oop2.summary.m01_Collections.clothing;

import java.util.ArrayList;
import java.util.List;

/** Debate "LinkedList or ArrayList?":
 *  - http://beginnersbook.com/2013/12/difference-between-arraylist-and-linkedlist-in-java/
 *  - http://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist
 *  Summary:
 *  - LinkedList when more add/remove operations than get() - access
 *  - ArrayList when more get() - access than add/remove
 *  The latter operation takes more computation time.
 *
 *  Second point: What the UnitTests specifies:
 *  The constructor of Wardrobe(int size) demands a list constructor can be used (or a method)
 *  with which we can predefine the list's size.
 *  Consulting the Java documentation and comparing the constructors of both candidates,
 *  ArrayList(int initialCapacity) enables us to fulfil this requirement, while LinkedList's constructors
 *  don't. Not even by working around with a method.
 *
 *  Conclusion: ArrayList(int initialCapacity) -> wardrobe as ArrayList
 */
/** Issue discussion: getSize()
 *  - We initialize the List with 'new ArrayList(2)'. It's initial capacity is 2.
 *  - The initial capacity will never change. Otherwise the testFullWardrobe() test case doesn't make any sense.
 *  - Since ArrayList doesn't offer any method to query the (current) capacity,
 *    I will store this information within an attribute. This seems to be the only way to solve this problem.
 *    Any kind of feedback is very welcome.
 */

/**
 * a standing closet used for storing clothes
 */
public class Wardrobe {

    private List<Garment> wardrobe;
    /* wardrobe's initial capacity */
    private final int initialCapacity;

    /**
     * creates a new Wardrobe
     *
     * @param size the size (maximum number of garments it can hold) of the
     * Wardrobe
     */
    public Wardrobe(int size) {
        wardrobe = new ArrayList<>(size);
        initialCapacity = size;
    }

    /**
     * returns the size of this Wardrobe
     *
     * @return the size of this Wardrobe
     */
    public int getSize() {
        return initialCapacity;
    }

    /**
     * adds a garment to this Wardrobe
     *
     * @param garment the garment to be added
     */
    public void addGarment(Garment garment) throws IllegalArgumentException, WardrobeFullException {
        if (this.hasGarment(garment)){
            throw new IllegalArgumentException(garment + " is already in the wardrobe");
        }
        if (this.getSize() == this.getGarmentCount()) {
            throw new WardrobeFullException(this);
        }
        wardrobe.add(garment);
    }

    /**
     * removes a garment from this Wardrobe
     *
     * @param garment the garment to remove
     */
    public void removeGarment(Garment garment) {
        if (!hasGarment(garment)){
            //garment doesn't exist within wardrobe
            throw new IllegalArgumentException(garment + " is not in the wardrobe");
        }
        wardrobe.remove(garment); //removes FIRST occurrence!
    }

    /**
     * tests, if a given garment is in this Wardrobe
     *
     * @param garment the wardrobe to search for
     * @return <tt>true</tt> if the garment is in this Wardrobe, <tt>false</tt>
     * otherwise
     */
    public boolean hasGarment(Garment garment) {
        return wardrobe.contains(garment);
    }

    /**
     * returns the number of garments in this Wardrobe
     *
     * @return the number of garments in this Wardrobe
     */
    public int getGarmentCount() {
        return wardrobe.size();
    }
}
