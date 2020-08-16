import java.util.*;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        
        int idx=0;
        for(int i=0; i<k; i++){
            if(idx<dates.length&&dates[idx]==i)
                q.offer(supplies[idx++]);
            
            if(stock==0){
                stock = q.poll();
                answer++;
            }
            stock--;
        }
        return answer;
    }
}