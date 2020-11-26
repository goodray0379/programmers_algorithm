import java.util.*;

class Solution {
    
    static int[][] connect;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n+1];
        connect = new int[n+1][n+1];
        
        //연결관계 배열의 인덱스가 1부터 시작하게 변경(필수 아님)
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                connect[i+1][j+1] = computers[i][j];
            }
        }
        
        for(int i=1; i<=n; i++){
            if(visited[i]==false){
                System.out.println("새로운 탐색: " + i);
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    public void dfs(int i){
        visited[i]=true;
        for(int j=1; j<connect.length; j++){
            if(connect[i][j]==1 && visited[j]==false){
                dfs(j);
            }
        }
    }
}