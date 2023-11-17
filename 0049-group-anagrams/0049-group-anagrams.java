import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        
        for(int i = 0 ; i < strs.length ; i++){
            String s = sortString(strs[i]); //eat
            
            if(map.get(s) == null){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s,list);
            }else{
                List<String> list = map.get(s);
                list.add(strs[i]);
                map.put(s,list);
            }            
        }
        
        for(Map.Entry entry : map.entrySet()){
            
            answer.add((List)entry.getValue());
        }
        return answer;        
    }
    
    
    public String sortString(String str) {
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < str.length() ; i++){
            list.add(String.valueOf(str.charAt(i)));
        }
        Collections.sort(list);
        String answer = "";
        for(String s : list){
            answer += s;
        }
        return answer;
    }
    
}