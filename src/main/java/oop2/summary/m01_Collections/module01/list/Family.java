package oop2.summary.m01_Collections.module01.list;

import ch.fhnw.oop2.module01.Person;

import java.util.ArrayList;
import java.util.List;

/** Key shortcut: Alt + Enter -> auto complete missing things.
 *
 */

/**
 * @author Dieter Holz
 */
public class Family {

    private List<Person> members = new ArrayList<>();

    public int size() { return members.size();  }   //Standartmethode v. List

    /**
     * adds a Person to List<Person> only if Person isn't already added.
     * @param person Person to be added.
     */
    public void add(Person person) {
        if ( !members.contains(person) ){
            members.add(person);    //Standartmethode v. List
        }
    }

    public boolean isMember(Person person) {
        return members.contains(person);    //Standartmethode v. List
    }

    public Person getOldest() {
        Person oldest = members.get(0); //1st Elem.

        for(Person p : members) {
            if(p.getAge() > oldest.getAge() ) {
                oldest = p;
            }
        }

        return oldest;
    }
}
