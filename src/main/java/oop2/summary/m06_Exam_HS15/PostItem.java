package oop2.summary.m06_Exam_HS15;

/*
 *      PostItem
 *       /    \
 *  Parcel    Letter
 *    /
 *  BulkGoodParcel
 *
 */

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;

import java.util.*;
import java.util.stream.Collectors;

public class PostItem {

    private final String receiver;
    private final double weight;

    //Versandart (A = A-post, B = B-post, E = Express)
    private final char dispatchMode;

    public PostItem(String receiver, double weight, char dispatchMode) {
        this.receiver = receiver;
        this.weight = weight;
        this.dispatchMode = dispatchMode;
    }

    public PostItem() {
        this("Santa Clause", 0.2, 'E');
    }

    @Override
    public String toString() {
        return "PI[" + receiver + ", " + weight + ", " + dispatchMode + "]";
    }

    public String getReceiver() {
        return receiver;
    }

    public double getWeight() {
        return weight;
    }

    public char getDispatchMode() {
        return dispatchMode;
    }

    public static void main(String[] args) {
        List<PostItem> listA= new ArrayList<>();
        listA.add(new PostItem("Paul", 4.3, 'A'));
        listA.add(new PostItem("Anna", 0.5, 'B'));
        listA.add(new PostItem("Karl", 0.91, 'E'));
        listA.add(new PostItem("Peter", 3.5, 'B'));
        for(PostItem item : listA){
            System.out.println(item);
        }
        /* Ausgabe:
        PI[Paul, 4.3, A]
        PI[Anna, 0.5, B]
        PI[Karl, 0.91, E]
        PI[Peter, 3.5, B]
         */

        System.out.println("--------------------------------");

        List<PostItem> listB= new ArrayList<>();
        listB.add(new PostItem("Paul", 4.3, 'A'));
        listB.add(new PostItem("Anna", 0.5, 'B'));
        listB.add(new PostItem("Karl", 0.91, 'E'));
        listB.add(new PostItem("Peter", 3.5, 'B'));
        for (int i = listB.size() - 1; i > 0; i--) {        // size = 4 => int = 3
            System.out.println(listB.get(i));
        }
        /* Ausgabe:
        PI[Peter, 3.5, B]
        PI[Karl, 0.91, E]
        PI[Anna, 0.5, B]
        */

        System.out.println("--------------------------------");

        HashMap<Character, PostItem> map = new HashMap<>();

        PostItem i1= new PostItem("Paul", 4.3, 'A');
        PostItem i2= new PostItem("Anna", 0.5, 'B');
        PostItem i3= new PostItem("Karl", 0.91, 'E');
        PostItem i4= new PostItem("Peter", 3.5, 'B');

        map.put(i1.getDispatchMode(), i1);      // A, Pa
        map.put(i2.getDispatchMode(), i2);      // B, An
        map.put(i3.getDispatchMode(), i3);      // E, Ka
        map.put(i4.getDispatchMode(), i4);      // B, Pe

        for(char k : map.keySet()){
            System.out.println(map.get(k).getReceiver());
        }

        // HashSet behält das alte Element und verwirft das Neue
        // HashMap nimmt das neue Element und verwirft das Alte
        // Paul, Karl, Peter => Aber da ASCII Code Reihenfolge => Ausgabe

        /* Ausgabe:
        Paul
        Peter
        Karl
        */

        System.out.println("--------------------------------");

        Set<PostItem> set= new TreeSet<>(new Comparator<PostItem>() {
            @Override
            public int compare(PostItem o1, PostItem o2) {
                return Character.compare(o1.getDispatchMode(),
                        o2.getDispatchMode());
            }
        });
        set.add(new PostItem("Karl", 0.91, 'E'));
        set.add(new PostItem("Anna", 0.5, 'B'));
        set.add(new PostItem("Paul", 4.3, 'A'));
        set.add(new PostItem("Peter", 3.5, 'B'));
        for(PostItem item : set){
            System.out.println(item);
        }
        /*
        PI[Paul, 4.3, A]
        PI[Anna, 0.5, B]
        PI[Karl, 0.91, E]
         */
    }

    public static void printSortedList(List<PostItem> list){

        Collections.sort(list, new Comparator<PostItem>(){
            @Override
            public int compare(PostItem p1, PostItem p2){
                //return p1.getWeight().compareTo(p2.getWeight());
                int orderValue = 0;
                if(p1.getWeight() < p2.getWeight()){
                    orderValue = -1;
                } else if (p1.getWeight() > p2.getWeight()){
                    orderValue = 1;
                }

                return orderValue;
            }
        });
        list.forEach(c -> System.out.println(c));
    }

    public static double getExpressWeight(List<PostItem> list){
        //list.stream().filter(postItem -> "E".equals(postItem.getDispatchMode()));
        return list.stream()
                .filter(postItem -> ((Character)postItem.getDispatchMode()).equals('E'))
                .mapToDouble(postItem -> postItem.getWeight())
                .sum();
    }

    public <T extends PostItem> List<T> extractExpress(T[] input){

        List<T> temp = Arrays.asList(input);

/*      // Variante 2
        for (T o : input) {
            temp.add(o);
        }
*/
        return temp.stream().filter(t -> "E".equals(t.getDispatchMode())).collect(Collectors.toList());
    }

    public <T> List<T> removeDoubles(List<T> input){
        return input.stream().distinct().collect(Collectors.toList());
    }
}

