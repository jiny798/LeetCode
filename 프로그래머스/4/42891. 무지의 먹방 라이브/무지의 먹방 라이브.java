import java.util.*;
class Solution {
    public int solution(int[] food_times, long k) {     
        int length = food_times.length;
        List<int[]> list = new ArrayList<>();      
        for(int i = 0 ; i < length ; i++ ) {
            list.add(new int[]{i+1,food_times[i]});
        }
        Collections.sort(list,(arr1,arr2)->{
            return arr1[1] - arr2[1];
        });
        // 1 2 3  k = 10
        // 0 1 2  k = 7
        // 0 0 1  k = 5
        // 0 0 0  k = 4
        // 1 1 1 1 k =4
        int[] res = null ;
        long restSize = list.size() ;
        for(int index = 0 ; index < list.size() ; index++) {           
            int[] arr = list.get(index);
            long removeCnt = 0;
            if(index == 0) {
                removeCnt = (long)arr[1] * restSize;
            }else {
                int[] arr2 = list.get(index-1);
                removeCnt = (long)(arr[1] - arr2[1]) * restSize;
            }
            // System.out.println(removeCnt +"--" + k +"--rest " + restSize);
            if(removeCnt <= k ) {
                k -= removeCnt;
                restSize--;
            } else {
                k = k % restSize; // 8 % 1
                list.subList(index, food_times.length).sort((o1, o2) -> o1[0] - o2[0]);
                res = list.get(index + (int)k);
                return res[0];
            }
            
        }
        
        return -1;
    }
}