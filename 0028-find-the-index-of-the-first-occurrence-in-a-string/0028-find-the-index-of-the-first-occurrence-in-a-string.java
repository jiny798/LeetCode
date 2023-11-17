import java.util.*;
class Solution {
    public int strStr(String haystack, String needle) {
        Set<String> set = new HashSet<>();
        set.add(needle);
        int length = needle.length();
        int answer = -1 ;
        for(int i = 0 ; i <= haystack.length() - length ; i++ ){
            String s = haystack.substring(i,i+length);
            if(set.contains(s)){
                answer = i;
                break;
            }
        }
        return answer;
    }
}