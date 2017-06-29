package oop2.summary.m01_Collections.module01;

/**
 * @author Dieter Holz
 */
public class MyPerson {
	private int    personNr;
	private String firstName;
	private String lastName;



	public MyPerson(int personNr, String firstName, String lastName) {
        this.personNr = personNr;
        this.firstName = firstName;
        this.lastName = lastName;
	}

    @Override
    public String toString() {
        return "Person-Nr " + personNr + ": " + firstName + " " + lastName;
    }

    //alle Getter und Setter

    public int getPersonNr() {
        return personNr;
    }

    public void setPersonNr(int personNr) {
        this.personNr = personNr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



}
