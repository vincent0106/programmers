package org.zerock.ex2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Solution_77484 {

    @Test
    public void test() {

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] answer =  solution(lottos, win_nums);

        System.out.println("###### answer : " + answer);

    }

    // 로또
    public int[] solution(int[] lottos, int[] win_nums) {

        //        int[] lottos = {44, 1, 0, 0, 31, 25};
        //int[] lottos = {0, 0, 0, 0, 0, 0};
        //int[] lottos = {45, 4, 35, 20, 3, 9};
        //  int[] lottos = {9,0,0,14,15,16};
//        int[] lottos = {21,22,23,24,25,36};
//        int[] win_nums = {31, 10, 45, 1, 6, 19};
//        int[] win_nums = {20, 9, 3, 45, 4, 35};

        List<Integer> result = new ArrayList<>();

        //int matchingCount = 0;
        int failCount = 0;
        int zeroCount = 0;

        for (int lotto : lottos) {

            boolean isEquals = false;

            if ( lotto == 0 ){
                zeroCount ++;
                continue;
            }

            for (int win_num : win_nums) {
                if (win_num == lotto) {
                    //matchingCount++;
                    isEquals = true;
                    break;
                }
            }
            if (!isEquals){
                failCount ++;
            }
        }

        // 6개일치 1등
        // 5개일치 2등
        // 4개일치 3등
        // 2개일치 5등
        // 그외 6등

        if ( failCount < 6 ){
            result.add(failCount + 1);
        }

        if ( failCount + zeroCount < 6 ){
            result.add(failCount + zeroCount + 1);
        }

        if ( failCount == 6 ){
            result.add(6);
            result.add(6);
        }

        if ( zeroCount == 6 ){
            result.add(6);
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
