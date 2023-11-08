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
        
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            if(map.get(sum - k) != null){
                answer += map.get(sum-k).size();
            }
            List<Integer> list = map.getOrDefault(sum, new ArrayList<>());
            list.add(i);
            map.put(sum,list);
        }
     
        
        return answer;
    }
}