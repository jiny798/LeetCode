import java.util.*;
class Solution {
    public static List<List<Integer>> answer ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        BT(target, candidates, new ArrayList<>(), target);
        return answer;
    }   
    public void BT(int target, int[] candidates, List<Integer> list, int beforeSelect){
        //종료 조건
        if(target == 0){
            List<Integer> tmp = new ArrayList<>(list);
            answer.add(tmp);
            return ;
        }     
        //프로세스
        for(int i = 0 ; i < candidates.length ; i++){
            if(candidates[i] <= target && candidates[i] <= beforeSelect ) {//필터링
                list.add(candidates[i]);
                BT(target - candidates[i], candidates, list, candidates[i] );   
                list.remove(list.size()-1);
            }                        
        }               
    }
}