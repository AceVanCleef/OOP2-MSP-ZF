package oop2.summary.m01_Collections.clothing;

/**
 * a waterproof or water-resistant coat worn to protect the body from rain
 */
public class Raincoat extends Jacket {

    /**
     * creates a new Raincoat
     *
     * @param name the name of the Raincoat
     * @param price the price of the Raincoat
     * @param size the size of the Raincoat
     */
    public Raincoat(String name, float price, int size) {
        super(name, price, size);
    }


    /**
     * returns the size of the Jacket
     *
     * @return the size of the Jacket
     */
    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " (price: " + getPrice() + ", size: " + getSize() + ')';
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
