package org.zerock.ex2;

import org.junit.jupiter.api.Test;

public class ElevenStreet_2 {

    @Test
    public void test_1(){
//        System.out.println("### 1,1,2,3,3 : 3 : t :" + solution(new int[]{1,1,2,3,3}, 3));
//        System.out.println("### 1,1,3 : 2 : f :" + solution(new int[]{1,1,3}, 2));
        System.out.println("### 1,2,3 : 2 : t :" + solution_2(new int[]{1,2,3}, 2));


        System.out.println("### 1,1,3 : 3 : t :" + solution(new int[]{1,1,3}, 3));

        System.out.println("### 1,1,3 : 5 : f :" + solution(new int[]{5,1,3}, 5));
        System.out.println("### 1,1,2,3,3 : 5 : f" + solution(new int[]{1,1,2,3,3}, 5));
    }

    public boolean solution_2(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] != A[i + 1] && A[i] + 1 > A[i + 1])
                return false;
        }
        if (!java.util.Arrays.stream(A).anyMatch(a -> a == K))
            return false;
        else
            return true;
    }

    public boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] != A[i + 1] && A[i] + 1 > A[i + 1])
                return false;
        }
        if (!java.util.Arrays.stream(A).anyMatch(a -> a == K))
            return false;
        else
            return true;
    }
}
