import java.util.*;
class Solution {
    
    Map<String,Integer> map = new HashMap<>();
    Map<String,Integer> cosMap = new HashMap<>();
    Set<String> set = new HashSet();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer =new ArrayList<>();
        for(int i = 0 ; i < orders.length ; i++){
            String sortedStr = sortStr(orders[i]);
            
            set = new HashSet<>();
            BT(0,"",sortedStr,course);
            for(String ss : set) {
                if(cosMap.get(ss) == null){
                    cosMap.put(ss,1);
                }else{
                    cosMap.put(ss,cosMap.get(ss)+1);
                }
            }
        }
        for(int i = 0 ; i < course.length ; i++){
            int len = course[i];
            int maxOrderCount = 0 ;
            for(Map.Entry entry : cosMap.entrySet()){ // AB 
                String cos = (String)entry.getKey();
                Integer cnt = (Integer)entry.getValue();
                if(cos.length() == len){
                    if(maxOrderCount < cnt){
                        maxOrderCount = cnt;
                    }
                }               
            }
            System.out.println(len+"길이 최대값"+maxOrderCount);
            for(Map.Entry entry : cosMap.entrySet()){ // AB 
                String cos = (String)entry.getKey();
                Integer cnt = (Integer)entry.getValue();
                if(len == cos.length() && cnt == maxOrderCount && maxOrderCount >=2){
                    answer.add(cos);
                }           
            }
        }
        Collections.sort(answer);
        String[] ans = new String[answer.size()];
        for(int i = 0 ; i < answer.size() ; i++){
            ans[i] = answer.get(i);
        }
            
        
        return ans;
    }
      
    public void BT(int index, String s , String str,int[] course) { // s 는 합쳐가는 문자열 
        for(int i = 0 ; i<course.length ; i++){
            if(s.length() == course[i]){ // 2, 3 ,4
                // System.out.println("조합"+s);
                set.add(s); 
            }
        }
        
        if(index == str.length()){
            return;
        }
        String word = String.valueOf(str.charAt(index));
        BT(index+1,s+word,str,course);
        BT(index+1,s,str,course);
    }
    
    public String sortStr(String order){
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < order.length() ; i++){
            list.add(String.valueOf(order.charAt(i)));
        }
        Collections.sort(list);
        String result = "";
        for(String s : list){
            result+=s;
        }
        return result;
    }
}