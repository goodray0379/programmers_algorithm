class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int t=0;
            int[] temp = new int[commands[i][1]-commands[i][0]+1];
            //1번과정 - 추출
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                temp[t] = array[j]; //temp배열은 array배열의 일부분을 저장할 배열입니다.
                t++;
            }
            //2번과정 - 정렬
            Arrays.sort(temp);
            //3번과정 - n번째의 숫자 반환
            answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }
}