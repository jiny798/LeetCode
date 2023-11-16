import java.util.*;

class Solution {
    public static List<List<Integer>> answer ; 
        
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        BT(0,new ArrayList<>(), nums);
        return answer;
    }
    
    public void BT(int index,List<Integer> list,int[] nums){
        if(list.size() == nums.length){
            List<Integer> tmp = new ArrayList<>(list);
            answer.add(tmp);
            return;
        }
        
        for(int i = 0 ; i < nums.length ; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            BT(index+1,list,nums);
            list.remove(list.size()-1);
        }
        
    }
}