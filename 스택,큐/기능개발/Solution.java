import java.util.*;

class Solution {
    //하나의 기능에 대해서 클래스를 정의해봅니다
    class Function{
        int progress;
        int speed;
        Function(int progress, int speed){
          this.progress = progress;
          this.speed = speed;
        }
        boolean isFinish(int time){
            if(this.progress+ this.speed*time>=100) return true;
            else return false;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Function> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++)
            q.add(new Function(progresses[i], speeds[i]));
        
        int time=0; int count=0;
        
        while(!q.isEmpty()){ //해당 반복문은 시간의 흐름을 뜻합니다.
            time++;
            while(true){ //해당 반복문은 현재 시점(시간)에서 맨 앞의 기능부터 배포가 가능한지 순차적으로 확인합니다.
                if(!q.isEmpty()&&q.peek().isFinish(time)){
                    q.poll(); count++;
                }else{
                    if(count!=0)
                        list.add(count);
                    count =0;
                    break;
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++)
            answer[i] = list.get(i);
        return answer;
    }
}