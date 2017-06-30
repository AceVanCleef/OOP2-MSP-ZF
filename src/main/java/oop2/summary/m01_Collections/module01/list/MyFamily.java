package oop2.summary.m01_Collections.module01.list;


import oop2.summary.m01_Collections.module01.MyPerson;

import java.util.ArrayList;
import java.util.List;


public class MyFamily {

    private List<MyPerson> members = new ArrayList<>();

    public int size() { return members.size();  }   //Standartmethode v. List

    public void add(MyPerson person){
        if ( !members.contains(person) ){
            members.add(person);    //Standartmethode v. List
        }
    }

    public boolean isMember(MyPerson person) {
        return members.contains(person);
    }

    @Override
    public String toString() {
        String collection = "";
        for (MyPerson p : members) {
            collection += p.toString() + "\n";
        }
        return collection;
    }
}
