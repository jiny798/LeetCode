class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Gas  [1] - [2] - [3] - [4] - [5] -
        // cost     3     4     5     1     2
        int answer = -1;
        int count = 0;
        for(int i = 0 ; i < gas.length ; i++){
            int gasAmount = 0;
            count = 0; // 5
            int index = i;
            while(count++ < gas.length){ 
                index = index % gas.length;
                gasAmount += gas[index]; // 가스채우고
                gasAmount -= cost[index]; // 다음칸으로 이동                
                if( gasAmount >= 0 ){ // 지나감
                    index++;
                }else{ // 못지나감
                    i = i + count - 1;
                    break;
                }                
            }

            if(count == gas.length+1){
                return i;
            }
        }// for end
        
        return -1;
    }
}