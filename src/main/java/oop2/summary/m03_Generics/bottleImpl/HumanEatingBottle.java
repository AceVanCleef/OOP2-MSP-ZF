package oop2.summary.m03_Generics.bottleImpl;

/**
 * Created by Degonas on 29.06.2017.
 */
public class HumanEatingBottle<T> {

    private T content;

    public void fill(T val){
        content = val;
    }

}
