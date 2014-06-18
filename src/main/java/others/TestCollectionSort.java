package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollectionSort{

    public static void main(String[] args) {
        List<Integer> rawList = new ArrayList<Integer>();
        rawList.add(4);
        rawList.add(3);
        rawList.add(2);
        rawList.add(5);
        rawList.add(1);

        List<Integer> sortedList = new ArrayList<Integer>();
        sortedList.addAll(rawList);

        Collections.sort(sortedList);

        for(Integer num : rawList) {
            System.out.println(num);
        }

        for(Integer num : sortedList) {
            System.out.println(num);
        }

    }
}
