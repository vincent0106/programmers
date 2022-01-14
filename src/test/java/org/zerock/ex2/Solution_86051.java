package org.zerock.ex2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_86051 {


    @Test
    public void test(){
        System.out.println("#### answer 1 :: " + solution(new int[]{1,2,3,4,6,7,8,0}));
        System.out.println("#### answer 2 :: " + solution(new int[]{5,8,4,0,6,7,9}));

    }


    /*
    * 없는 숫자 더하기
    * intStream 처리로 처리 가능
    * 모든수를 더한수 뺴기 처리 방안도 있지만 업무적으로는 배울점은 없음. 그냥 알고리즘 이므로
    * */
    public int solution(int[] numbers) {

        // intStream 으로 처리
        // return IntStream.range(0, 10).filter(key -> Arrays.stream(numbers).noneMatch(num -> key == num)).sum();

        int answer = 0;
        for (int i = 1; i <= 9; i++) {
            int finalI = i;
            if ( Arrays.stream(numbers).noneMatch(num -> finalI == num) ){
                answer += i;
            }
        }
        return answer;
    }

}
