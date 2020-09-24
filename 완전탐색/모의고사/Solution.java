import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer ={};
        int[] count = {0,0,0};
        int[] A = {1,2,3,4,5};
        int[] B = {2,1,2,3,2,4,2,5};
        int[] C = {3,3,1,1,2,2,4,4,5,5};
        for(int i=0; i<answers.length; i++){
            count[0] = (A[i%5]==answers[i])?count[0]+1:count[0];
            count[1] = B[i%8]==answers[i]?count[1]+1:count[1];
            count[2] = C[i%10]==answers[i]?count[2]+1:count[2];
        }
        
        int max = count[0];
        for(int i=1; i<3; i++){
            if(max<count[i])
                max= count[i];
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<3; i++){
            if(count[i]==max){
                list.add(i+1);
            }
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}