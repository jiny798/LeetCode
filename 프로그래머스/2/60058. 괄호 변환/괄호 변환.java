import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        answer += seperate(p);               
        return answer;
    }
    
    public String seperate(String p){
        if(p.equals("")){
            return "";
        }
        Stack<String> st = new Stack<>();
        int index = -1;
        for(int i = 0 ; i < p.length() ; i++){
            if(st.size() == 0 || st.peek().equals(String.valueOf(p.charAt(i)))){
                st.add(String.valueOf(p.charAt(i))); //하나도 없거나, 똑같은거면 담는다   
            }else{ // 다른거면 뺀다 EX. )( , () 
                st.pop();
            }
            
            if(st.size() == 0){ //균형잡힌 문자열 분리완료
                index = i;
                break;
            }
        }
        String[] arr = new String[2];
        arr[0] = p.substring(0,index+1);
        if(index+1 < p.length()){
            arr[1] = p.substring(index+1,p.length());
        }else{ 
            arr[1] = ""; // v가 빈문자열
        }
        // System.out.println(arr[0] +"--" + arr[1]);
        
        String str ="";
        if(isRight(arr[0])){ // u가 올바른 괄호 문자열이라면
            System.out.println(arr[0]+"--올바른 괄호!");
            return arr[0] + seperate(arr[1]); // v에 대해 1단계부터 다시 수행하고 u에 붙인다
        }else{
            str = "(";
            str += seperate(arr[1]);
            str += ")";
            String u = "";
            String newStr = "";
            for(int j=0; j <arr[0].length() ; j++){
                if(j==0)continue;
                if(j==arr[0].length()-1)continue;               
                u+=arr[0].substring(j,j+1);
            }
            if(u.length() > 0){             
                for(int j = 0 ; j<u.length() ; j++){
                    if(u.charAt(j) == '('){
                        newStr += ")";
                    }else{
                        newStr += "(";
                    }
                }
            }
            str += newStr;
        }
        
        return str;
    }
    
    public boolean isRight(String p){
        Stack<String> st = new Stack<>();
        for(int i = 0 ; i<p.length() ; i++){
            if(st.size() == 0){
                st.add(String.valueOf(p.charAt(i)));
            }else{
                if(st.peek().equals("(") && String.valueOf(p.charAt(i)).equals(")") ){
                    st.pop();
                }else{
                    st.add(String.valueOf(p.charAt(i)));
                }
            }
        }
        if(st.size() == 0){
            return true; // 올바른 괄호
        }
        return false;        
    }
}