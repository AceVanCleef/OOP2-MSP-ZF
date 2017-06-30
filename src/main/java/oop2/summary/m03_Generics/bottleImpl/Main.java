package oop2.summary.m03_Generics.bottleImpl;

import oop2.summary.m03_Generics.bottleImpl.hirarchy.Beer;
import oop2.summary.m03_Generics.bottleImpl.hirarchy.Drink;
import oop2.summary.m03_Generics.bottleImpl.hirarchy.RedWine;
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
         *      |
         *   RedWine
         *
         *  fill() == add() == setVal()
         */

        /*** [class Bottle<T> vs. [class Bottle<T extends Drink>] ***/
        //[class Bottle<T>] means, that not only Drinks can be filled in, but also Persons!
        HumanEatingBottle<Person> notAgoodBottle = new HumanEatingBottle<>();   //<Person> shoudn't be possible. Only: <Drink>, <Beer> or <Wine>.
        notAgoodBottle.fill(new Person());  //autsch, that will hurt. That poor Person.
        //In order to prevent more meaningless death, we make sure that bottles can only be filled with drinks:
        //  [class Bottle<T extends Drink>]
        //Now, a bottle can only be filled with something really drinkable. Hurray!
        Bottle<Drink> bottle = new Bottle<>();
        bottle.fill(new Drink());
        bottle.fill(new Beer());
        bottle.fill(new Wine());
                        //Wait, what? Another person tries to commit suicide be being eaten by the bottle.
        //bottle.fill(new Person());    // But luckily, our bottle was prepared for this.


        /*** Limit to one type of Drink: Wine only ***/
        //Well, this looks a little messed up. Let's have a bottle that is specialised to carry only Wine:
        Bottle<Wine> wineBottle = new Bottle<>();
        wineBottle.fill(new Wine());    //hurray. But what if we still try to fill it with something else, such as beer?


        /*** Neighbouring branches: Beer isn't Wine ***/
        //wineBottle.fill(new Beer());  //It looks like this bottle is actually pretty smart.
                                        // It knows that it musn't be filled with Beer, another type of drink.


        /*** filling up a Childtype/Subtype of Wine: ***/
        //But it will definitely agree to carry a more well defined type of wine, such as whiteWine or RedWine? Let's see:
        wineBottle.fill(new RedWine());
        //Yepp, it works. Since RedWine is a Subtype of Wine, the wineBottle allows us to fill this Wine into it.



        //Now, some final tips and hints:
        Bottle<?> b = new Bottle<>();   /* === */   Bottle<Drink> b2 = new Bottle<>();  //since class Bottle<T extends Drink> prevents it from eating Persons.
        //This doesn't work:
        /*
        Bottle<? extends Drink> b3 = new Bottle<Drink>();
        b3.fill(new Beer());
        */  //Wildcards are a real pain in the butt. Better avoid them.
    }
}
