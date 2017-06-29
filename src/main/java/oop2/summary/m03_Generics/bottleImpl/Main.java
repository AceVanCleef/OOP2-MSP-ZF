package oop2.summary.m03_Generics.bottleImpl;

import oop2.summary.m03_Generics.bottleImpl.hirarchy.Beer;
import oop2.summary.m03_Generics.bottleImpl.hirarchy.Drink;
import oop2.summary.m03_Generics.bottleImpl.hirarchy.Wine;

/**
 * Created by Degonas on 29.06.2017.
 */
public class Main {

    public static void main(String[] args){
        /** Hierarchie:
         *
         *       Drink
         *       /    \
         *    Wine   Beer
         *
         */


        //[class Bottle<T>] means, that not only Drinks can be filled in, but also Persons!
        HumanEatingBottle<Person> notAgoodBottle = new HumanEatingBottle<>();
        notAgoodBottle.fill(new Person());  //autsch, that will hurt. That poor Person.

        //In order to prevent more meaningless death, we make sure that bottles can only be filled with drinks:
        //  [class Bottle<T extends Drink>]
        //Now, a bottle can only be filled with something really drinkable. Hurray!
        Bottle<Drink> bottle = new Bottle<>();
        bottle.fill(new Drink());
        bottle.fill(new Beer());
        bottle.fill(new Wine());

        //Well, this looks a little messed up. Let's have a bottle that is specialised to carry only Wine:
        Bottle<Wine> wineBottle = new Bottle<>();
        wineBottle.fill(new Wine());    //hurray. But what if we still try to fill it with something else, such as beer?

        //wineBottle.fill(new Beer());  //It looks like this bottle isn't the right type to hold on to beer. It would get bad very quickly.


    }
}
