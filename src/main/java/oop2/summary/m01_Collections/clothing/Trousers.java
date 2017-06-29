package oop2.summary.m01_Collections.clothing;

/**
 * clothing worn from the waist to the ankles
 */
public class Trousers extends Garment {

    private final int waistSize;
    private final int length;

    /**
     * creates new Trousers
     *
     * @param name the name of the Trousers
     * @param price the price of the Trousers
     * @param waistSize the waist size of the Trousers
     * @param length the length of the Trousers
     */
    public Trousers(String name, float price, int waistSize, int length) {
        super(name, price);
        this.waistSize = waistSize;
        this.length = length;
    }

    /**
     * returns the waist size of the Trousers
     *
     * @return the waist size of the Trousers
     */
    public int getWaistSize() {
        return waistSize;
    }

    /**
     * returns the length of the Trousers
     *
     * @return the length of the Trousers
     */
    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return super.getName() + " (price: " + super.getPrice() +
                ", waist size: " + waistSize + ", length: " + length + ")";
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
