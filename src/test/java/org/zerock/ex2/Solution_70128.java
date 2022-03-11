package org.zerock.ex2;

import org.junit.jupiter.api.Test;

public class Solution_70128 {

    /* 내적 */
    @Test
    public void test(){

        System.out.println("#### answer 1 :: " + solution(new int[]{1,2,3,4}, new int[]{-3,-1,0,2}));
        System.out.println("#### answer 1 :: " + solution(new int[]{-1, 0, 1}, new int[]{1,0,-1}));

    }

    public int solution(int[] a, int[] b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }
}
