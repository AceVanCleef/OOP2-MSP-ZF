package oop2.summary.m01_Collections.clothing;

/**
 * mid-stomach–length garment for the upper body
 */
public class Jacket extends Top {

    private final int size;

    /**
     * creates a new Jacket
     *
     * @param name the name of the Jacket
     * @param price the price of the Jacket
     * @param size the size of the Jacket
     */
    public Jacket(String name, float price, int size) {
        super(name, price);
        this.size = size;
    }

    /**
     * returns the size of the Jacket
     *
     * @return the size of the Jacket
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " (price: " + getPrice() + ", size: " + size + ')';
    }

    /**
     * returns the name of this Garment
     *
     * @return the name of this Garment
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * returns the price of the Garment
     *
     * @return the price of the Garment
     */
    @Override
    public float getPrice() {
        return super.getPrice();
    }

    /**
     * sets the price of the Garment
     *
     * @param price the price of the Garment
     */
    @Override
    public void setPrice(float price) {
        super.setPrice(price);
    }
}
