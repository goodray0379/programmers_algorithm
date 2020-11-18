import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n+1]; //그래프를 표현할 변수
        int[] distance = new int[n+1]; //1번 노드에서 각각의 노드까지의 distance를 저장할 변수
        int max = 0; //최대거리를 저장할 변수
        Queue<Integer> q = new LinkedList<Integer>(); //BFS 알고리즘의 큐
        boolean check[] = new boolean[n+1]; //방문했던 노드는 true로
        
        for(int i=1; i<=n; i++){
            g[i] = new ArrayList<>();
        }
        for(int i=0; i<edge.length; i++){
            g[edge[i][0]].add(edge[i][1]); //그래프의 정보를 ArrayList에 저장
            g[edge[i][1]].add(edge[i][0]); //양방향으로 넣어줘야함
        }
        
        q.add(1); check[1]=true; distance[1] = 0; //1번부터 출발 : bfs알고리즘

        //bfs 알고리즘 부분이고, 메소드로 따로 분리해서 호출하는 식의 구조도 좋음
        while (!q.isEmpty()) {
            int x = q.remove();
            for(int i : g[x]){
                if(check[i]==false){
                    q.add(i);
                    check[i]=true;
                    distance[i] += distance[x] + 1;
                    if(distance[i]>max)
                        max = distance[i];
                }
            }
        }
        
        for(int i : distance){
            if(i==max)
                answer++;
        }
        
        return answer;
    }
}