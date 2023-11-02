import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++){
            int n = nums[i];            
            if(map.get(n) != null){
                map.put(n, map.get(n)+1);
            }else{
                map.put(n,1);
            }
        }
        
        
        //[index, count]
        PriorityQueue<int[]> que = new PriorityQueue<>((arr1,arr2)-> arr2[1] - arr1[1] ); 
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            que.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] answer = new int[k];
        int i = 0;
        while(k-- > 0){
            answer[i++] = que.poll()[0];
        }
        
        return answer;
    }
}