package solution;

class Solution {
    public int solution(int[] money) {
    	
        //dp배열 2개선언(dp[n]은 0부터 n까지 집을 털면서 훔친 돈의 최댓값)
        int[] dp1 = new int[money.length-1];
        int[] dp2 = new int[money.length];
        
        dp1[0] = money[0];
        dp1[0] = money[0];
        dp2[1] = money[1];
        
        //하나는 첫 집을 무조건 터는 경우(마지막 집은 무조건 털 수 없음)
        for(int i=2; i<money.length-1; i++) 
        	dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]); 
        
        //첫 집을 털지 않은 경우
        for(int i=2; i<money.length; i++) 
        	dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]); 
        
        return Math.max(dp1[dp1.length-1], dp2[dp2.length-1]);
    }
}