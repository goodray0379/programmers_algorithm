import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        
        int mid;   //거리의 최소값
        int count; //돌 제거 개수
        int prev;  //마지막 돌의 위치
        while(right>=left){
            count = 0;
            prev = 0;
            mid = (right+left)/2;
            
            for(int i=0; i<rocks.length; i++){
                if(mid > rocks[i]-prev){
                    //돌을 제거
                    count++;
                }else{
                    //돌을 제거하지 않음
                    prev = rocks[i];
                }
            }
            
            if(count>n){
                //돌 제거 개수를 낮춰야 하기 때문에 mid값을 아래로 조정
                right = mid - 1;
            }else{
                //돌 제거 개수를 높여야 하기 때문에 mid값을 위로 조정
                left = mid + 1;
                answer = mid>answer?mid:answer;
            }
        }
        
        return answer;
    }
}
​