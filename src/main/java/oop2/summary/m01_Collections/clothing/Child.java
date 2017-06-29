package oop2.summary.m01_Collections.clothing;

/** Lessons learned:
 *  - putOn(Garment g){ if(g instanceOf Top){..} else if (g instnaceOf Trousers){...} } is bad idea. Normally,
 *    it's better to use overloading such as putOn(Top garment) and putOn(Trousers garment)
 */

/**
 * A human being between birth and puberty. Can wear a top and some trousers.
 * Acts childish from time to time.
 */
public class Child {

    private Top top;
    private Trousers trousers;

    /**
     * puts on a garment
     *
     * @param garment the garment to put on
     */
    public void putOn(Garment garment) {
        if (garment instanceof Top){
            top = (Top) garment;
        } else if (garment instanceof Trousers) {
            trousers = (Trousers) garment;
        } else {
            throw new IllegalArgumentException("I only wear tops and trousers!");
        }
    }


    /**
     * takes off a garment
     *
     * @param garment
     */
    public void takeOff(Garment garment) {
        if (top == null && trousers == null){
            throw new IllegalArgumentException("I do not currently wear " + garment);
        }
        if (garment instanceof Top){
            top = null;
        } else if (garment instanceof Trousers) {
            trousers = null;
        }
    }

    /**
     * returns the top garment of the child
     *
     * @return the top garment of the child
     */
    public Garment getTop() {
        return top;
    }

    /**
     * returns the trousers of the child
     *
     * @return the trousers of the child
     */
    public Garment getTrousers() {
        return trousers;
    }
}
