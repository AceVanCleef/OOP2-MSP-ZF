package oop2.summary.m01_Collections.clothing;

import java.util.*;

/** Data structure debate:
 *  - combine a hash map with a list:
 *      - LinkedList when more add/remove operations than get() - access
 *      - ArrayList when more get() - access than add/remove
 *      The latter operation takes more computation time.
 *
 *  How to create HashMap with ArrayList as element:
 *  http://stackoverflow.com/questions/19541582/storing-and-retrieving-arraylist-values-from-hashmap
 */

/** Data structure notes
 *      Map<String, List<Garment>>: Key = garmentObj.getName(), Value = List<Garment>
 *      List<Garment>: Garment objects = Elements of this list
 */

/**
 * a shop that can contain and sell garments
 */
public class WebShop {

    ///*  String: garment name (Trousers, Jacket, Raincoat) = Key, List: Collection of Garments = value */
    private Map<String, List<Garment>> webShop = new HashMap<>();

    /**
     * adds a Garment to this Webshop
     *
     * Case 1: List<Garment> exists -> don't overwrite existing value (mapValue)
     * Case 2: initial adding
     *
     * @param garment the Garment do be added
     */
    public void addGarment(Garment garment) {
        String key = garment.getName();
        List<Garment> mapValue;
        if (webShop.containsKey(key)){
            /* HashMap already uses this key: */
            mapValue = webShop.get(key);
            mapValue.add(garment);
        } else {
            /* first initialization: */
            //1st, create a List
            mapValue = new LinkedList<>();
            mapValue.add(garment);
            //2nd, add list to map
            webShop.put(garment.getName(), mapValue);
        }

    }



    /**
     * returns all items in this Webshop
     *
     * What we do in this method:
     * 1) save all List<Garment> (= Elements of Map<String, List<Garment>> webShop) in
     *      separate Collection (a big bag of Lists) {cluster}
     * 2) creates Santa Clause's bag with which he will collect all Garments out of each List<Garment>:
     *      for(List<Garment> element : cluster) {bag.addAll(element);}
     *      After this, bag will only be filled with Garments.
     *
     * testSaveAllItems():
     * - must prevent retrieving shop items without buying it.
     *
     * @return all items in this Webshop
     */
    public Collection<Garment> getAllItems() {
        Collection<List<Garment>> cluster = webShop.values(); //a bag filled with Lists
        Collection<Garment> bag = new ArrayList<>();
        for(List<Garment> element : cluster) {
            bag.addAll(element); //addAll(): alle Elemente einer CollectionA als EINZELELEMENTE in eine CollectionB aufnehmen
        }
        //create deep copies of Garment
        Collection<Garment> deepCopiesForDisplay = createDeepCopies(bag);

        return deepCopiesForDisplay;
    }

    /**
     * returns the specified Top and removes it from this WebShop
     *
     * @param name the name of the Top to buy
     * @return the specified Top
     */
    public Top buyTop(String name) {
        if (! webShop.containsKey(name)) {
            throw new IllegalArgumentException("Top " + '\"' + name + "\" is not available");
        }
        // hier: mit Iterator solange über Liste iterieren, bis man eine Instanz der Klasse Top gefunden hat
        List<Garment> mapValue = webShop.get(name);
        Iterator<Garment> listIterator = mapValue.iterator();
        Garment temp = new Trousers("notATop", 1, 1, 1); //to enter while()
        //sequenzielle Suche
        while (listIterator.hasNext() && !(temp instanceof Top)){
            temp = listIterator.next();
        }
        Top desiredItem = (Top) temp;   //cast solved type safety problem
        mapValue.remove(desiredItem);

        return desiredItem;
    }

    /**
     * returns the specified Trousers and removes them from this WebShop
     *
     * @param name the name of the Trousers to buy
     * @param waistSize the waistSize of the Trousers to buy
     * @param length the length of the Trousers to buy
     * @return the specified Trousers
     */
    public Trousers buyTrousers(String name, int waistSize, int length) {
        if (!webShop.containsKey(name)) {
            throw new IllegalArgumentException("Trousers " + '\"' + name
                    + "\" with size " + waistSize + "," + length
                    + " are not available");
        }

        // hier: mit Iterator solange über Liste iterieren, bis man eine Instanz der Klasse Trousers gefunden hat
        List<Garment> mapValue = webShop.get(name);
        Iterator<Garment> listIterator = mapValue.iterator();
        Garment temp = new Jacket("notAPairOfTrousers", 1, 1); //to enter while()
        //sequenzielle Suche
        while (listIterator.hasNext() && !(temp instanceof Trousers)){
            temp = listIterator.next();
        }
        Trousers desiredItem = (Trousers) temp;   //cast solved type safety problem
        mapValue.remove(desiredItem);

        return desiredItem;
    }

    /**
     * returns the total value of this Webshop (the sum of all prices of all
     * Garments)
     *
     * @return the total value of this Webshop
     */
    public float getTotalValue() {
        //ToDo: jeden Mapkey (bzw. jedes MapValue) aufrufen, über jede Liste iterieren und mit garmentObj.getPrice() aufsummieren
        // Damit ich über alle MapValues iterieren kann, muss ich die values in eine Collection packen (webShop.values()).
        // -> getAllItems() nutzen.
        float sum = 0;
        Collection<Garment> allItems = this.getAllItems();
        for(Garment element : allItems){
            sum += element.getPrice();
        }

        //Als Stream:   float sum = (float) allItems.stream().mapToDouble(garment -> garment.getPrice()).sum();

        return sum;
    }

    /**
     * returns the Garment with the lowest price
     *
     * @param name the name of the Garmet to search for
     * @return the Garment with the lowest price
     */
    public Garment getLowestPrice(String name) {
        // name = Suchkey. D.h. von einer Garmentsorte das günstigste suchen.

        if (!webShop.containsKey(name)){
            //throw exception if necessary
        }

        List<Garment> mapValue = webShop.get(name);
        Iterator<Garment> listIterator = mapValue.iterator();
        Garment cheapest = listIterator.next(); //expects at least one element in List
        Garment temp;
        while (listIterator.hasNext()){
             temp = listIterator.next();
             if (temp.getPrice() < cheapest.getPrice()){
                 cheapest = temp;
             }
        }

        //create deep copiy of cheapest Garment
        return getDeepCopyOf(cheapest);

        //Als Stream:   cheapest = mapValue.stream().sorted((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice())).findFirst().get(); //.get(): from optional to Garment
    }

    /**
     * returns a deep copy of any non-abstract Garment object.
     * This method is identical to createDeepCopy, but offers a more
     * semantic name when used on single Garment object.
     * @param garment - object to be copied.
     * @return object of non-abstract subclass of Garment.
     */
    private static Garment getDeepCopyOf(Garment original){
        return createDeepCopy(original);
    }

    /**
     * creates deep dopies of all Garment objects and returns them gathered within a collection.
     * @param original - Collection of Garments you want to copy
     * @return a duplicate collection filled with deep dopies of Type Garment
     */
    private static Collection<Garment> createDeepCopies(Collection<Garment> original){
        Collection<Garment> deepCopies = new ArrayList<>();
        for (Garment element : original){
            Garment deepCopy = createDeepCopy(element);
            deepCopies.add(deepCopy);
        }
        return deepCopies;
    }

    /**
     * returns a deep copy of any non-abstract Garment object.
     * @param garment - object to be copied.
     * @return object of non-abstract subclass of Garment.
     */
    private static Garment createDeepCopy(Garment garment) {
        Garment deepCopy = null;
        //Note: more specific ref.type in inheritance hirarchy first
        if (garment instanceof Raincoat){
            deepCopy = new Raincoat(garment.getName(), garment.getPrice(), ((Raincoat) garment).getSize());
        } else if (garment instanceof Jacket){
            deepCopy = new Jacket(garment.getName(), garment.getPrice(), ((Jacket) garment).getSize());
        } else if (garment instanceof Trousers) {
            deepCopy = new Trousers(garment.getName(), garment.getPrice(),
                    ((Trousers) garment).getWaistSize(), ((Trousers) garment).getLength());
        }
        return deepCopy;
    }


    /* Kurze Frage: Sind diese beiden Methoden notwändig für die webShop-HashMap?*/
    //required for HashMaps
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    //required for HashMaps
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
