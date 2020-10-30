import java.util.*;

class Solution {
    public int solution(int[][] triangle) {

        int length = triangle.length;
        //n줄엔 최대 n개의 값이 들어가는 피라미드 모양이라 다음과 같이 선언하면 됨
        int[][] dp = new int[length][length];

        //dp배열의 맨 아랫줄엔 triangle배열의 마지막 줄 값을 넣어주는 과정
        for(int i=0; i<length; i++){
            dp[length-1][i] = triangle[length-1][i];
        }
        
        for(int i=length-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
            }
        }

        return dp[0][0];
    }
}