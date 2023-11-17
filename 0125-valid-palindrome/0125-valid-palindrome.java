import java.util.*;
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int a = 0;
        int b = s.length()-1;
        boolean answer = true;
        while(true){
            if(a >= b){ // 종료조건
                break;
            }
            char x = s.charAt(a);
            char y = s.charAt(b);
            if('a'<= x && x <= 'z' || 'A' <= x && x <= 'Z' || '0' <= x && x <= '9'){                
            }else{
                a++;
                continue;
            }
            
            if('a'<= y && y <= 'z' || 'A' <= y && y <= 'Z' || '0' <= y && y <= '9'){                
            }else{
                b--;
                continue;
            }
            
            if(x == y){
                answer=true;
                a++;
                b--;
            }else{
                answer=false;
                break;
            }
            
            
                        
        }
       return answer; 
    }
}