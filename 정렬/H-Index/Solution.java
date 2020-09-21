import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int ﻿H-Index= 0; //최종적으로 도출해야하는 H-Index
        int n = citations.length; //논문의 수
        Arrays.sort(citations); //인용 횟수로 정렬
        
        for(int h=n; h>0; h--){   
            int count = 0; //h번 이상 인용된 논문 개수

            for(int i=n-1; i>=0; i--){
                if(citations[i]>=h)
                    count++;
                else
                    break;
            }
            
            if(count>=h){
                ﻿H-Index = h; //answer=count가 아닙니다! count변수는 h보다 큰지 확인차 선언한 변수
                break;
            }     
   
        }
    
     return ﻿H-Index;
    }
}