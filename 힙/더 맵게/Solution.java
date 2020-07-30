import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++)
            q.offer(scoville[i]);
        
        while(K>=q.peek()){
            if(q.size()==1)
                return -1;
            int temp = q.poll() + (q.poll()*2);
            q.offer(temp);
            answer++;
        }
        return answer;
    }
}