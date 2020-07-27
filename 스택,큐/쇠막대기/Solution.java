import java.util.*;

class Solution {
    public int solution(String arrangement) {
        Stack<Integer> stack = new Stack<Integer>(); //이 스택에는 '('가 나올때마다 인덱스를 보관 
        int answer = 0;
        
        for(int i=0; i<arrangement.length(); i++){
            //'(' 는 스택에 바로 넣어준다.
            if(arrangement.charAt(i) == '('){
                stack.push(i);
            }else{
                //')'는 이게 레이저의 것인지 쇠막대기의 것인지 구분해줘야한다.
                //스택의 가장 최근 저장된 인덱스 데이터와 비교
                if(stack.peek()+1==i){ //레이저인 경우
                    stack.pop();
                    answer += stack.size();
                }else{ //쇠막대기인 경우
                    stack.pop();
                    answer += 1;
                }
            }
        }
        return answer;
    }
}