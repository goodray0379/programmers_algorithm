import java.util.*;

//따로 문서클래스를 선언
public class Document{
    int idx;
    int priority;
    
    public Document(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        
        int answer = 0;
        Queue<Document> q = new LinkedList<Document>();
        int[] priCount = new int[10]; //작업의 중요도 개수 배열
        
        for(int i=0; i<priorities.length; i++){
            Document docu = new Document(i, priorities[i]);
            q.offer(docu);
            priCount[priorities[i]]++;
        }
        
        int priority=9;
        
        while(q.isEmpty()==false){
            //지금 큐에 남아있는 인쇄 작업들의 중요도 값들에서 최대값을 추출
            for(int i=9; i>0; i--){
                if(priCount[i]!=0){
                    priority = i;
                    break;
                }
            }
            
            Document docu = q.remove();
            //현재 남은 문서들 중 중요도가 가장 높다면 인쇄를 해야하며 찾고자 하는 문서인지 확인해야합니다.
            if(priority == docu.priority){
                answer++;
                priCount[priority]--; //중요도 카운팅 배열에서도 -1 해줍니다(인쇄해서 큐에 남아있지 않으니깐)
                if(location == docu.idx)
                    return answer;
            }
            //그게 아니라면 다시 큐 맨뒤에 삽입
            else{
                q.add(docu);
            }
        }
      
        return answer;
    }
}