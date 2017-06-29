package oop2.summary.m03_Generics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestGenerics {

    /** [Inheritance tree]
     *      A
     *     / \
     *    B   C
     *    |
     *    D
     */


    private Box<A> aBox;
    private Box<B> bBox;
    private Box<C> cBox;
    private Box<D> dBox;

    private Box box;

    //Objekte der Verarbungsstruktur
    private A a1;
    private B b1;
    private C c1;
    private D d1;

    @Before
    public void setUp() throws Exception {
        aBox = new Box<>();
        bBox = new Box<>();
        cBox = new Box<>();
        dBox = new Box<>();

        box = new Box();

        a1 = new A();
        b1 = new B();
        c1 = new C();
        d1 = new D();
    }

    @Test
    public void testBoxA(){
        //working
        try{
            aBox.setValue(a1);
            assertSame(a1, aBox.getValue());
        } catch (Exception e){
            fail();
        }
        try{
            aBox.setValue(b1);
            assertSame(b1, aBox.getValue());
        } catch (Exception e){
            fail();
        }
        try{
            aBox.setValue(c1);
            assertSame(c1, aBox.getValue());
        } catch (Exception e){
            fail();
        }
        try{
            aBox.setValue(d1);
            assertSame(d1, aBox.getValue());
        } catch (Exception e){
            fail();
        }

        //All work. Reason: All children are of type A.

        //NOT working
        // -
    }

    @Test
    public void testBoxB(){
        //working
        try{
            bBox.setValue(b1);                  //works.
            assertSame(b1, bBox.getValue());
        } catch (Exception e){
            fail();
        }
        try{
            bBox.setValue(d1);                  //works. D is child and type of B.
            assertSame(d1, bBox.getValue());
        } catch (Exception e){
            fail();
        }

        //NOT working
        /*
            bBox.setValue(a1);                  //does NOT work. A is NOT of type B (it is its parent class tough).

            bBox.setValue(c1);                  //does NOT work. C is on separate inheritance branch A- C.
        */

    }

    @Test
    public void testBoxC(){
        //working
        try{
            cBox.setValue(c1);                  //works.
            assertSame(c1, cBox.getValue());
        } catch (Exception e){
            fail();
        }

        //NOT working
        /*
            cBox.setValue(a1);                  //does NOT work. A is NOT of type C (It is its root and parent class tough).

            cBox.setValue(b1);                  //does NOT work. B is on separate inheritance branch A - B - D.

            cBox.setValue(d1);                  //does NOT work. B is on separate inheritance branch A - B - D.
        */
    }

    @Test
    public void testBoxD(){
        //works
        try{
            dBox.setValue(d1);                  //works: D is LEAF of branch A - B - D.
            assertSame(d1, dBox.getValue());
        } catch (Exception e){
            fail();
        }


        //NOT working
        /*
            dBox.setValue(a1);                  //does NOT work. A is NOT of type D (It is its root class tough).

            dBox.setValue(b1);                  //does NOT work. B is NOT of type D (It is its parent type tough).

            dBox.setValue(c1);                  //does NOT work. C is on separate branch & NOT of type D.
        */


    }

    @Test
    public void testGetValueOfbBox(){
        bBox.setValue(b1);

        //working
        a1= bBox.getValue();    //B is child of A.  -> works
        b1= bBox.getValue();    //B is B.           -> works

        //NOT working
        /*
            c1= bBox.getValue();    //C isn't of type B -> does NOT work.
            d1= bBox.getValue();    //D isn't of type B (own inharitance branch) -> does NOT work.
        */
    }

    @Test
    public void testZuweisungen(){
        //working
        box = aBox;      //works. untypisierte box kann beliebigen Typ enthalten.
        box = dBox;      //works. ".

        //NOT working
        /*
            aBox = bBox;    //does NOT work. aBox doesn't accept Boxes filled with children types (B, C, D).
            dBox= cBox;     //does NOT work. dBox doesn't accept Boxes filled with types of different branch (C in A-C).
        */
    }

    @Test
    public void testWildcards(){
        //So werden alle Typen zugelassen.
        Box<?> wildBox= new Box<B>();          //Hinweis: Box<?> wildBox für Referenz. Aber: ...new Box<B> -> explizit Typ für Instanz angeben.

        wildBox = aBox;
        wildBox = cBox;
        wildBox = dBox;
        //Aufgrund der wildcards (<?>) in der Deklaration funktionieren alle Zuweisungen. Wildcards akzeptieren alle Typen.
    }


    /**
     * Testsubjekt: Wildcard-Referenz mit constraint. Testen via: Zuweisungen.
     */
    @Test
    public void testWildcardsSubclassesOnly(){
        //Constraint (extends):
        Box<? extends B> bBoxSub= new Box<B>();     //extends: nur Unterklassen und B erlaubt.

        //NOT working
        /*
            bBoxSub = aBox; //does NOT work. A is parent class of B.
            bBoxSub = cBox; //does NOT work. C is on separate inheritance branch
        */

        //working
        bBoxSub = dBox; //works. D is child and type of B.

        //Hinweis: So simuliert man die Eigenschaften der Polymorphie: A = new D() zum Beispiel.
    }

    @Test
    public void testWildcardsPredecessorclassesOnly(){
        Box<A> aBox= new Box<A>();
        Box<B> bBox= new Box<B>();

        //Constraint (super):
        Box<? super C> cBox= new Box<C>();  //super: nur Oberklassen und C erlaubt.

        Box<D> dBox= new Box<D>();

        //working
        cBox= aBox;     //works. A ist Oberklasse von C.

        //NOT working
        /*
            cBox= bBox;     //does NOT work. Separate branch.
            cBox= dBox;     //does NOT work. Separate branch.
        */
    }

    @Test
    public void testUnacceptableWildcardInstantiation(){
        //NOT working
        /*
            Box<D> dBox= new Box<?>();  //new Box<?>: Error, "Wildcardtype ? CANNOT be instantiated directly".
        */

        //Grund:    Wildcards (<?>) sind nur für Referenzen erlaubt.
    }

    @Test
    public void testUseOfGenericMethod(){
        BoxWith2Typeparams<C, B> box = new BoxWith2Typeparams<>();  //C als Key, B als Value

        box.isNull(new B());    //Aufrufbeispiel für: public <P> boolean isNull(P val)  //hier: P = B.
    }
}