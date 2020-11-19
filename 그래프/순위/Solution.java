class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        final int INF = 1000000; //무한대는 절대 나올 수 없는 큰 값으로 설정
        int[][] FW = new int[n+1][n+1];
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++)
                FW[i][j] = INF;
        }
        
        for(int[] e : results)
            FW[e[0]][e[1]] = 1;
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                for(int k=1; k<n+1; k++){
                    FW[i][j] = FW[i][j] > FW[i][k]+FW[k][j]?FW[i][k] + FW[k][j]: break;
                    
                }
            }
        }
        
        for(int i=1; i<n+1; i++){
            boolean flag = true;
            
            for(int j=1; j<n+1; j++){
                if(i==j) continue;
                if(FW[i][j]==INF && FW[j][i]==INF){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}