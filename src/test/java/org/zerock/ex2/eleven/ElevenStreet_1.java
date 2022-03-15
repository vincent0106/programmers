package org.zerock.ex2.eleven;

import org.junit.jupiter.api.Test;

public class ElevenStreet_1 {

    @Test
    public void test_1(){
        System.out.println("### 16 :: " + solution(28));
    }

    public int solution(int N) {
        // write your code in Java SE 8
        int sumValue = Integer.toString(N).chars().map(num -> Character.getNumericValue(num)).sum();
        for (int i = N+1; i <= 50000; i++) {
            if ( sumValue == Integer.toString(i).chars().map(num -> Character.getNumericValue(num)).sum()){
                return i;
            }
        }
        return N;

    }
}
