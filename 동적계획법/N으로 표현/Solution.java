import java.util.*;

public class Solution {

    public int solution(int N, int number) {
        //초기값 설정
        //dp[n]은 숫자 N을 n번 이용하여 만들 수 있는 수들의 집합
        HashSet<Integer> dp[] = (HashSet<Integer>[]) new HashSet[9];
        dp[1] = new HashSet<Integer>();
        dp[1].add(N);
        int NN = N; //NN은 'NN....N'을 의미

        //모든 경우의 수 조사
        for(int i=2; i<9; i++){
            NN = N + NN*10;
            dp[i].add(NN);
            dp[i] = new HashSet<Integer>();

            for(int j=1; j<i; j++){
                for(Integer num1: dp[j]){
                    for(Integer num2: dp[i-j]){

                        dp[i].add(num1+num2);
                        dp[i].add(num1-num2);
                        dp[i].add(num1*num2);
                        dp[i].add(num1/num2);

                    }
                }
            }
            //연산결과가 0이면 싸그리 무시, 답안 도출에 도움이 안됨
            if(dp[i].contains(0)) dp[i].remove(0);
        }
        
        //최종탐색
        for(int i=1; i<9; i++){
            if(dp[i].contains(number))
                return i;
        }

        return -1;

    }
}