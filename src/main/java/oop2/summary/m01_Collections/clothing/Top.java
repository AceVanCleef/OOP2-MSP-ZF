package oop2.summary.m01_Collections.clothing;

/**
 * clothing that is designed to be worn over the torso
 */
public abstract class Top extends Garment {

    /**
     * creates a new Top
     *
     * @param name the name of the Top
     * @param price the price of the Top
     */
    public Top(String name, float price) {
        super(name, price);
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
