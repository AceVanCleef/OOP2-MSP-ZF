package oop2.summary.m03_Generics.bottleImpl;

import oop2.summary.m03_Generics.bottleImpl.hirarchy.Drink;

/**
 * Created by Degonas on 29.06.2017.
 */
public class Bottle<T extends Drink> {

    private T content;

    public void fill(T val){
        System.out.println("A bottle of " + val.getClass().getName());
        content = val;
    }

}
