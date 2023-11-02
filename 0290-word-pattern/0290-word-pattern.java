import java.util.*;
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String,String> map = new HashMap<>();
        Map<String,String> rverseMap = new HashMap<>();
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        
        for(int i = 0 ; i<pattern.length() ; i++){
            String word = pattern.substring(i,i+1);
            String str = arr[i];
            // System.out.println(i+"--"+str+"--" + word);
            if(map.get(word) != null){      
                if(!map.get(word).equals(arr[i])){
                   return false; 
                }
            }else if(rverseMap.get(str) != null){
                if(!rverseMap.get(str).equals(word)){
                    return false;
                }
            }else{
                map.put(word,arr[i]);
                rverseMap.put(arr[i],word);
            }           
        }
        return true;
    }
}