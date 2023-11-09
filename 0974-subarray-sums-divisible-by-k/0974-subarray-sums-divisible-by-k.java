import java.util.*;
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // 4 5 0 -2 -3 1, k = 5 , -5
        // 4 9 9  7  4 5
//나머지    4 4 4  2 4 0  
     
        // -1 2 9 , k =2
        // -1 1 10
        // -1 1 0
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        int[] sums = new int[nums.length];
        int sum=0;
        list.add(-1);
        map.put(0, list);
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i]; 
            int mod = (sum % k + k) % k;
            if(map.get(mod) != null){
                answer += map.get(mod).size();
            }
            
            list = map.getOrDefault(mod, new ArrayList<>());
            list.add(i);
            map.put(mod, list);
            
        }
        return answer;
        
    }
}