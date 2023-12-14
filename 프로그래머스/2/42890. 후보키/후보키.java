import java.util.*;
class Solution {
    public static int N =0 ;
    public static Map<String,Integer> duplMap;
    public static List<String> answer;
     public static Set<String> set;
    
    public int solution(String[][] relation) {
        boolean[] visit = new boolean[relation[0].length]; // 4개
        answer = new ArrayList<>();
        BT(0,visit,relation); // 유일성 체크 끝
        
        // 0110 1100 0100
        for(int i = 0 ; i < answer.size() ; i++) { // 0110
            String str1 = answer.get(i);
            int n1 = Integer.parseInt(str1,2);
            boolean tag = true;
            for(int j = 0 ; j < answer.size() ; j++) {
                if(i==j) continue;
                String str2 = answer.get(j);
                int n2 = Integer.parseInt(str2,2);
                if( (n1 & n2) == n2) { // n1은 n2를 포함하므로 n1은 최소성 만족하지 않음
                    tag = false;
                    break;
                }                
            } 
            if(tag) {
                N++;
            }
        }
        
            
        return N;
    }
   
    private void BT(int n , boolean[] visit, String[][] relation) {
        if(n == visit.length){
            checkUnique(visit,relation);
            return;
        }                
        visit[n] = true;
        BT(n+1,visit,relation);
        visit[n] = false;                 
        BT(n+1,visit,relation);        
    }
    
    private void checkUnique(boolean[] visit, String[][] relation) {
        duplMap = new HashMap<>();
        for(int j = 0 ; j < relation.length ; j++) { // 모든 relation 반복 
            String key = "";
            for(int k = 0 ; k < relation[0].length ; k++) {
                if(visit[k] == true) {
                    key += relation[j][k] + ".";
                }
            }     
            // System.out.println(key);
            if(duplMap.get(key) == null) {      
                duplMap.put(key,1);
            }else{
                duplMap.put(key, duplMap.get(key)+1);
            }      
        }
        
        for(Map.Entry<String,Integer> entry : duplMap.entrySet()) {
            if(entry.getValue() >= 2){
                // System.out.println(entry.getKey()); // 하나라도 2개 이상이 있으면 나가고
                return;
            }
        }
        String str = "";
        // boolean[] tempVisit = new boolean[visit.length];
        for(int i=0;i<visit.length;i++) { // 유일성을 만족하는 조합            
            if(visit[i] == true) {
                str += "1";
            }else {
                str += "0";
            }
            
        }
        answer.add(str);

        
    }
    // 1 1 0 0
    // 0 1 0 0
}