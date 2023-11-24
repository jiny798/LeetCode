class Solution {
    public int solution(String name) {
            int answer = 0;                
            int move=name.length()-1; //길이
            int start=0;
        for(int i =0; i<name.length();i++ ){
            int num = Math.min( name.charAt(i) -'A','Z' - name.charAt(i) +1 );
            answer +=num;
            //"JJAAAAB"    AAAABAA  ABAA  JJAAAABB     JAAAB //  AAAAB
            if(num!=0){
                start=i;
            }
                int Alength=i;
            while(Alength < name.length()&&name.charAt(Alength)=='A'){
                Alength++;                
            }            
            move = Math.min( move, start*2+name.length()-Alength  ); // 앞갔다가 뒤로 , A가 바로나오면 뒤로 바로 감 
            move = Math.min( move, (name.length()-Alength)*2 + start );//뒤갔다가 앞으로 //        
        }    
            
            answer = answer + move;
        
        return answer;
    }
}