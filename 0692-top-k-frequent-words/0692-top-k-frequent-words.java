import java.util.*;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String str : words){
            if(map.get(str) != null){
                map.put(str,map.get(str) + 1);
            }else{
                map.put(str,1);
            }
        }
        
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        
        Collections.sort(list, (e1,e2) -> {
            if(e1.getValue() != e2.getValue()){
                return e2.getValue() - e1.getValue();
            }else{
                return e1.getKey().compareTo(e2.getKey());
            }
        });
        
        List<String> answer = new ArrayList<>();
        for(int i = 0 ; i<k ; i++){
            answer.add(list.get(i).getKey());
        }
            
        return answer;
    }
}