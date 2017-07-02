package oop2.summary.m06_Exam_HS15;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MeanOfTransport<T extends PostItem> {

    private List<T> allPostItems = new ArrayList<T>();

    public void add(T newItem){
        allPostItems.add(newItem);
    }

    public int getNumberOfItems(){
        return (int) allPostItems.stream()
                            .filter(t -> "A".equals(t.getDispatchMode()))
                            .count();
    }

    public T getMaxElement(){
        return allPostItems.stream()
                            .max((o1, o2) -> Double.compare(o1.getWeight(), o2.getWeight()))
                            .get();
    }

    public List<T> getPostItems (String receiver){
        return allPostItems.stream()
                            .filter(t -> t.getReceiver().equals(receiver))
                            .collect(Collectors.toList());
    }


}
