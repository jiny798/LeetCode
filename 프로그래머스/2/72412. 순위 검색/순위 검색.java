import java.util.*;
class Solution {
    public static Map<String,List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        List<Integer> answer =new ArrayList<>();
        
        for(int i = 0 ; i < info.length ; i++ ){
            String str = info[i];
            String[] arr = str.split(" ");
            BT(0,arr,"");          
        }
        for(Map.Entry<String,List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            Collections.sort(list);
        }
        
        for(int i = 0 ; i < query.length ; i++) {
            String str = query[i];
            String[] arr = str.split(" ");
            String num = arr[7]; // 100 점 이상 찾기
            str = str.replaceAll(num,"");
            // 10 20 30 40 50 left 2  size 5
            if(map.get(str) != null){
                List<Integer> list = map.get(str);
                // Collections.sort(list); // 위 for문에서 같은거 꺼내서 또 같은것을 정렬할 수 있음
                int left = 0 ;
                int right = list.size() - 1;
                while(left <= right) {
                    int pivot = (left + right) / 2;
                    int key = list.get(pivot);
                    if(key < Integer.parseInt(num)) { // 중간30점 < 25 이상
                        left = pivot + 1;
                    }else { // 중간30점 < 찾고자하는 25점
                        right = pivot - 1;
                    }
                }
                answer.add(list.size() - left);
                
            }else {
                answer.add(0);
            }
           
        }
        int[] ans = new int[answer.size()];
        for(int i = 0 ; i < answer.size() ; i++) {
            ans[i] = answer.get(i);
        }
        
        return ans;

    }
    private void BT(int index, String[] arr, String target ) {
        if(index == 4){
            List<Integer> list;
            if(map.get(target) == null){
                list = new ArrayList<>();
                list.add(Integer.parseInt(arr[4]));
                map.put(target,list);
            }else {
                list = map.get(target);
                list.add(Integer.parseInt(arr[4]));
            }
        
            return;
        }
        
        if(index < 3){
            BT(index+1,arr,target+arr[index]+" and "); // ""+"java"
            BT(index+1,arr,target+"- and "); // ""
        }else if(index == 3) {
            BT(index+1,arr,target+arr[index]+" "); // ""+"java"
            BT(index+1,arr,target+"- "); // ""
        }
        
    }
}