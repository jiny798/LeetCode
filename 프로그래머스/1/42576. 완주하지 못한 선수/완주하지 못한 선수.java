import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String str : participant) {
            if(map.get(str) == null){
                map.put(str,1);
            }else{
                map.put(str, map.get(str) + 1);
            }
        }
        
        for(String str : completion){
            if(map.get(str) != null){
                map.put(str, map.get(str) - 1);
            }
        }
        
        for(String str : participant) {
            if(map.get(str) == 1){
                return str;
            }
        }
        
        return "";
        
    }
}