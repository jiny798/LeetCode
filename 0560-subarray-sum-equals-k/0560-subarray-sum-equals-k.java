import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        // -1 -2 -1
        int[] arr = new int[nums.length];
        Map<Integer,List<Integer>> map = new HashMap<>();    
        int sum = 0;
        int answer = 0;
        List<Integer> edgeList = new ArrayList<>();
        edgeList.add(-1);
        map.put(0,edgeList);
        // 1 2 3
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];   
            arr[i] = sum; // 1 3 6 
            List<Integer> list = map.getOrDefault(sum, new ArrayList<>());
            list.add(i);
            map.put(sum,list);
        }
        for(int i = -1 ; i < nums.length ; i++){
            int n ;
            if(i == -1){
               n = 0; 
            }else{
               n = arr[i]; // 3 
            }
            List<Integer> flist = map.get(n);
            flist.remove(0);
            int cnt = 0 ;
            if(map.get(n+k) != null){
                List<Integer> tlist = map.get(n+k);
                for(Integer num : tlist){
                    if(i < num){
                        cnt++;
                    }
                }
            }
            answer+=cnt;
        }
        
        
        // for(int i = 0 ; i < nums.length ; i++){
        //     sum += nums[i];
        //     if(map.get(sum - k) != null){
        //         answer += map.get(sum-k).size();
        //     }
        //     List<Integer> list = map.getOrDefault(sum, new ArrayList<>());
        //     list.add(i);
        //     map.put(sum,list);
        // }
     
        
        return answer;
    }
}