import java.util.*;

class Solution {
    public int[] solution(String msg) { //KAKAO
        Map<String,Integer> map = new HashMap<>();
        init(map);
        int index = 0 ;
        int mapIndex = 27;
        boolean isRest = true;
        List<Integer> answer = new ArrayList<>();
        while(isRest) {         
            String s = "";
            for(int i = 0 ; i < msg.length() ; i++) {
                s += Character.toString(msg.charAt(i)); // KA
                if(map.get(s) == null){ //KA
                    String cash = s.substring(0,s.length()-1);
                    answer.add(map.get(cash)); // K에 해당 하는 색인번호 11 출력
                    map.put(s,mapIndex++); // KA 추가
                    msg = msg.substring(i,msg.length()); // K 제거
                    break;
                }else{ 
                    if(i == msg.length()-1){ // 마지막이라면 
                        answer.add(map.get(s));
                        isRest = false;
                    }
                    continue;
                }
            }           
        }
        int arr[] = answer.stream().mapToInt(i -> i).toArray();
        
        return arr;
    }
    
    public void init(Map<String,Integer> map){
        char c = 'A';
        for(int i = 0 ; i < 26 ; i++) {
            String s = Character.toString(c+i);
            map.put(s,i+1);
        }      
    }
}