import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        
        for (String operate : operations) {
            StringTokenizer st = new StringTokenizer(operate);
            String order = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            
            if (order.equals("I")) {
                // 양쪽 삽입
                maxQueue.add(-value);
                minQueue.add(value);
                
            } else {
                if (value == 1) {
                    Integer maxValue = maxQueue.poll();
                    if (maxValue != null) {
                        minQueue.remove(-maxValue);
                    }
                    
                } else {
                    Integer minValue = minQueue.poll();
                    if (minValue != null) {
                        maxQueue.remove(-minValue);
                    }
                }
            }
        }
        
        Integer maxValue = maxQueue.peek();
        Integer minValue = minQueue.peek();
        
        if (maxValue == null) {
            maxValue = 0;
        }
        if (minValue == null) {
            minValue = 0;
        }
        
        return new int[] {-maxValue, minValue};
    }
}