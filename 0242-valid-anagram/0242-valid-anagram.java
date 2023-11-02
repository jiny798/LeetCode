import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<String,Integer> map = new HashMap<>();
        String str;
        for(int i = 0 ; i < s.length() ; i++){
            str = String.valueOf(s.charAt(i));
            if(map.get(str) != null){
                map.put(str,map.get(str)+1);
            }else{
                map.put(str,1);
            }
        }
        
        for(int i = 0 ; i < t.length() ; i++){
            str = String.valueOf(t.charAt(i)); 
            if(map.get(str) != null){
                map.put(str,map.get(str)-1);
            }else{
                return false;
            }
        }
        
        for(int i = 0 ; i < s.length() ; i++){
            str = String.valueOf(s.charAt(i));
            if(map.get(str) != 0){
                return false;
            }
        }        
        return true;     
    }
}