import java.util.*;

class Solution {
    public int solution(String s) {
        int maxLength = s.length();
        //aabbacc  
        int limit = s.length()/2; // 3
        
        for(int i = 1 ; i <= limit ; i++){ // 1~3개 단위로 짜르기
            int cnt = s.length() / i; // 1이면 그대로, 2면 3 번
            int rest = s.length() % i;
            int sameCnt = 1;
            List<String> list = new ArrayList<>();
            int k = 0;
            for(int j = 0 ; j<cnt ; j++){
                list.add(s.substring(k,k+i));
                k = k + i;
            }
            String answer = "";
            for(int j = 0 ; j < list.size()-1 ; j++){
                if(list.get(j).equals(list.get(j+1))){
                    sameCnt++;
                }else{
                    if(sameCnt == 1){
                        answer += list.get(j);
                    }else{
                        answer += (sameCnt + list.get(j));
                        sameCnt = 1;
                    }
                }
            }
            if(sameCnt == 1){
                answer += list.get(list.size()-1);
            }
            else{
                answer += (sameCnt + list.get(list.size()-1));
            }
                
            if(rest > 0 ){
                answer += s.substring(s.length()-rest, s.length());
            }    

            if(maxLength > answer.length()){
                maxLength = answer.length();
            }
            
        }
              
        return maxLength;
    }
}