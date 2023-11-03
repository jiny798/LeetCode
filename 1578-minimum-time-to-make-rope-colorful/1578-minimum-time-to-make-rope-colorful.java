class Solution {
    public int minCost(String colors, int[] neededTime) {
        char beforeWord = '0';
        int answer = 0 ;
        int maxTime = 0;
        
        for(int i = 0 ; i < colors.length() ; i++){
            char newWord = colors.charAt(i);
            
            if(beforeWord == newWord){
                if(maxTime <= neededTime[i]){
                    answer += maxTime;
                    maxTime = neededTime[i];
                }else{
                    answer += neededTime[i];
                } 
                
            }else{
                beforeWord = newWord;
                maxTime = neededTime[i];
                continue;
            } 
        }
        return answer;
    }
}