package oop2.summary.m01_Collections.module01.hashmap;

// ToDo: die HashMap auffüllen, Wert "Anz. Personen mit gleichem Alter" inkrementieren.

/**
 * How to iterate through a HashMap:    http://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
 */


import oop2.summary.m01_Collections.module01.Person;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Dieter Holz
 */
public class Family {

    private final Set<Person> members = new HashSet<>();
    /* key = Alter x, Value = Anz. Personen mit Alter x */
    private final Map<Integer, Integer> map = new HashMap<>();


    public int size() {
        return members.size();
    }

    public void add(Person person) {
        members.add(person);
        // add family member to map according to their age:
        if (map.containsKey(person.getAge())) {
            int oldValue = map.get(person.getAge());
            map.put(person.getAge(), oldValue + 1);
        } else {
            map.put(person.getAge(), 1);
        }

    }

    public Person getOldest() {
        Person oldest = null;
        for (Person p : members) {
            if (oldest == null || p.getAge() > oldest.getAge()) {
                oldest = p;
            }
        }
        return oldest;
    }


    public boolean isMember(Person person) {
        return members.contains(person);
    }


    /**
     * gibt zurück wieviele Familienmitglieder das angegebene Alter haben.
     *
     * Note: containsKey(Object key)
     *       Returns true if this map contains a mapping for the specified key.
     * Note 2:  map.get(age): Anz. Personen mit Alter age.
     *
     * @param age int gesuchtes Alter (key).
     * @return int Anz. Personen (value).
     */
    public int numberOfMembers(int age) {
        return (map.containsKey(age))? map.get(age) : 0;
    }

    /**
     * gibt die verschiedenen Alter aller Familienmitglieder zurück.
     * e.g. Menge M = {30, 35}
     *
     * Inspired by: http://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
     *
     * @return Set<Integer> ages with elements of ref.type Integer (all keys).
     */
    public Set<Integer> allAges() {
        return map.keySet();
    }
}
