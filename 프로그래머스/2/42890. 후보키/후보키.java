import java.util.*;
class Solution {         
    public int solution(String[][] relation) {
        Set<String> set = new HashSet<>(); 
        Set<String> uniqueSet = new HashSet<>();
        int answer = 0 ;
        int[] visit = new int[relation[0].length];
        BT(0,visit,set);
        
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            String next = it.next();
            boolean isUnique = isUnique(relation, next); // 1101
            if(isUnique) {
                uniqueSet.add(next);
            }            
        }
        
        Iterator<String> it2 = uniqueSet.iterator();
        
        while(it2.hasNext()) {
            String next = it2.next();
            Iterator<String> it3 = uniqueSet.iterator();
            boolean tag = true;
            while(it3.hasNext()) {
                String inNext = it3.next();
                if(next.equals(inNext)){
                    continue;
                }
                int a = Integer.parseInt(next,2);
                int b = Integer.parseInt(inNext,2);
                if((a&b) == b) {
                   tag = false; 
                }
            }
            if(tag) {
                answer++;
            }
        }
        
        
        
        return answer;
    }
   
    
    private void BT(int n, int[] visit, Set<String> set) {
        String str = "";
        if(n == visit.length) {
            for(int i = 0 ; i < visit.length ; i++ ) {
                str += visit[i];
            }
            set.add(str);
            return;
        }
        visit[n] = 1;
        BT(n+1, visit, set);
        visit[n] = 0;
        BT(n+1, visit, set);
    }
    
    private boolean isUnique(String[][] relation, String visit ) {
        Set<String> uSet = new HashSet<>();
        for(int i = 0 ; i < relation.length ; i++ ) {
            String str = "";
            for(int j = 0 ; j < visit.length() ; j++ ) {
                if(visit.charAt(j) == '1') {
                    str += relation[i][j] +"," ;
                }   
            }
            if(!uSet.contains(str)){
                uSet.add(str);
            }else{
                return false;
            }
        }
        return true;
    }
        
    
}