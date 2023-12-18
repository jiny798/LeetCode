import java.util.*;
class Solution {
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        BT(0,nums,list);
        return answer;
    }
    
    private void BT(int index,int[] nums, List<Integer> list) {
        if(index == nums.length) {
            List<Integer> newList = new ArrayList<>();
            for(Integer i : list){
                newList.add(i);
            }
            answer.add(newList);
            return;
        }
        
        int num = nums[index]; // 1
        list.add(num);
        BT(index+1,nums,list); //안고르고 넘어가기
        list.remove(list.size()-1);
        BT(index+1,nums,list); //고르고 넘어가기
    }
}