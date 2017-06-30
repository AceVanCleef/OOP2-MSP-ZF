package oop2.summary.m01_Collections.module01.set;


import oop2.summary.m01_Collections.module01.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


// ToDo: Hausaufgabe - komplettiere gemäss Test Cases


/**
 * @author Dieter Holz
 */
public class Family {

    private Set<Person> members = new HashSet<>();


    public int size() {
        return members.size();
    }

    public void add(Person person) {
        members.add(person);    //Duplikate werden von Set autom. weggeworfen -> kein Test nötig.
    }

    public boolean isMember(Person person) {
        return members.contains(person);
    }

    /* HOW TO ITERATE THROUGH A HASHSET:
     *   Sets have no order by definition, and therefore can't be indexed like
     *   arrays, or lists via a get method. However you can still iterate through
     *   the elements of a Set with a for-each loop (or by using the iterator
     *   returned by the iterator() method).
     *
     *   Method 1: with iterator
     *   Iterator<String> it = hset.iterator();
     *   while(it.hasNext()){  System.out.println(it.next());  }
     *
     *   Method 2: with for()
     *   Set<String> set = new HashSet<String>();
     *
     *   //populate set
     *
     *   for (String s : set) {
     *       System.out.println(s);
     *   }
     *
     *   Source: http://beginnersbook.com/2014/08/how-to-iterate-over-a-sethashset/
     */


    public Person getOldest() {
        Iterator<Person> it = members.iterator();
        Person oldest = it.next();

        for(Person p : members) {
            if (p.getAge() > oldest.getAge()) { oldest = p; }
        }

        return oldest;
    }

    //Mit streams:
//    public Person getMrX(Person mrX){
//        return members.stream().filter(person -> person.getName().equals(mrX.getName())).findFirst().get();
//    }


}
