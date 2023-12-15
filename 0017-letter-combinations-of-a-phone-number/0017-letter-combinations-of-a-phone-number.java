import java.util.*;
class Solution {
    public static List<String> list;
    public static Map<Integer,String> map;
    public static String input = "";
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        map = new HashMap<>();
        input = digits;
        init(map);
        BT(0,"");
        return list; 
    }
    
    public void BT(int index, String str){
        if(index == input.length()) {
            if(str.equals("")) return;
            list.add(str);
            return;
        }      
        int digit = Integer.parseInt(String.valueOf(input.charAt(index)));
        String s = map.get(digit);
        
        for(int i = 0 ; i < s.length() ; i++){
            BT(index+1, str + String.valueOf(s.charAt(i))); // a
        }               
    }
    
    
    public void init(Map<Integer,String> map){        
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");        
    }
}