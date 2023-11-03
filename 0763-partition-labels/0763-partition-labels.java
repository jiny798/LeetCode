import java.util.*;
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<String,Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        int last = -1;
        for(int i = 0 ; i < s.length() ; i++){
            String word = String.valueOf(s.charAt(i));
            map.put(word,i); // 마지막 인덱스 추가, a 기준 [a,2] 가 드감
        }
                
        for(int i = 0 ; i < s.length() ; i++){
            String word = String.valueOf(s.charAt(i));
            int index = map.get(word);        
                     
            if(last > index){
                continue;
            }else{ // x x x last
                last = index;
            }
            
            if(i == last){
               answer.add(i+1); 
            }
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(answer.get(0));
        if(answer.size() > 1){
            int a = answer.get(0);           
            for(int i = 1 ; i< answer.size() ; i++){
                list.add( answer.get(i) - a );
                a = answer.get(i);                             
            }            
        }
        
        
        return list;
    }
}