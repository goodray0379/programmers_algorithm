import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long left = 1L;
        long right = (long)times[times.length-1] * (long)n;
        long mid;
        
        while(right>=left) {
        	//특정시간동안 각각의 입국 심사대에서 일을 처리할 수 있는 개수의 합
        	long done = 0;
        	mid = (left+right)/2;
        	
        	for(int time : times) {
        		done += mid/time;
        	}
        	
        	if(done>=n) {
        		if(answer>mid)
        			answer = mid;
        		right = mid -1;
        	}else {
        		left = mid +1;
        	}
        }
        return answer;
    }
}