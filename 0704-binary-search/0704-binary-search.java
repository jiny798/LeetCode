class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int answer = -1;
        // 10 20 30 40 50
        // 0 1 2 3 4 5
        while(left <= right){
            int pivot = (left+right) / 2 ;
            int num = nums[pivot];
            if(num == target){
                answer = pivot;
                break;
            }
            if(num < target) {
                left = pivot + 1;
            }else {
                right = pivot - 1;
            }            
        }
        return answer;
    }
}