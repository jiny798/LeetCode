import java.util.*;

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        
        String haystack = s + s;
        Set<String> set = new HashSet<>();
        set.add(goal);
        int length = goal.length();
        int answer = -1 ;
        for(int i = 0 ; i <= haystack.length() - length ; i++ ){
            String str = haystack.substring(i,i+length);
            if(set.contains(str)){
                answer = i;
                break;
            }
        }
        
        if(answer == -1){
            return false;
        }
        return true;
        
    }
}