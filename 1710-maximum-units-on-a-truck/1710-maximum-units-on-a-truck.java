import java.util.*;
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, (arr1,arr2) -> arr2[1] - arr1[1]);
        
        int index = 0;
        int sum = 0;
        while(truckSize > 0 && index < boxTypes.length){
            int[] arr = boxTypes[index++];            
            if(truckSize >= arr[0]){
                truckSize = truckSize - arr[0];
                sum += arr[1]*arr[0];
            }else{
                sum += arr[1]*truckSize;
                truckSize = 0;
            }                  
        }
           
        return sum;
        
    }
}