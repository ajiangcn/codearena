package leetCode;

import java.util.PriorityQueue;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int n : num) {
            heap.add(n);
        }
        int counter = 1;
        int max = 1;
        Integer number = heap.poll();
        int lastInt = number;
        while((number = heap.poll()) != null) {
            if(number == lastInt + 1) {
                counter++;
            } else if(number != lastInt){
                max = counter > max ? counter : max;
                counter = 1;
            }
            lastInt = number;
        }
        max = counter > max ? counter : max;
        return max;
    }
}
