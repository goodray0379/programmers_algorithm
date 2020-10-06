class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        if((int)Math.pow((int)Math.sqrt(red),2)==red){
            answer[0] = (int)Math.sqrt(red)+2;
            answer[1] = (int)Math.sqrt(red)+2;
        }
        else{
            loop :
            for(int i=1; i<=red; i++){
                for(int j=1; j<i; j++){
                    if(i*j==red){
                        if(2*(i+j+2)==brown){
                            answer[0] = i+2;
                            answer[1] = j+2;
                            break loop;
                        }
                    }
                }
            }
        }
        return answer;
    }
}