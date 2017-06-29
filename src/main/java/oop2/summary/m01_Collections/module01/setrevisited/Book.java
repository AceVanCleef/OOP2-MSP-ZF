package oop2.summary.m01_Collections.module01.setrevisited;

/** Lessons learned:
 *  - set = (DE) Menge
 *  - equals() has to be implemented for HashSet
 *  - hashCode() has to be implemented for HashSet.
 *    Otherwise the Set filter function (no duplicates) won't be applied.
 *  - when a duplicate is about to be stored into the set, it won't. Furthermore,
 *    the original/first instance will be kept within the set while the duplicate
 *    will be thrown away.
 *
 *  Compared to HashTable (Map)
 *  - HashSet keeps the first instance in memory, while HashTable overwrites it by the duplicate
 */

/**
 * @author Dieter Holz
 */
public class Book {
    private final int isbn;

	public Book(int isbn) {
	    this.isbn = isbn;
	}

    public int getIsbn() {
        return isbn;
    }

    /**
     * for HashSet, it is required to implement equals().
     * Otherwise the compiler won't be able to decide whether something is already stored in the set.
     * equals() requires an implementation of hashCode() (by the programmer).
     * @param o Object other
     * @return boolean whether this is equals to other
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return isbn == book.isbn;
    }

    /** For HashSet, it is required to define the HashValue.
     *  That means I have to tell by what variable/value HashSet has to compare.
     *  hashCode() will be implicitly called and returns the hash value.
     *  Within hashCode(), I can define what "sameness" is.
     * @return
     */
    @Override
    public int hashCode() {
        return isbn;
    }
}
