package org.zerock.ex2;

import org.junit.jupiter.api.Test;

public class Solution_81301 {

    @Test
    public void test(){
        System.out.println("#### answer 1 :: " + solution("one4seveneight"));
        System.out.println("#### answer 2 :: " + solution("23four5six7"));
        System.out.println("#### answer 3 :: " + solution("2three45sixseven"));
        System.out.println("#### answer 4 :: " + solution("123"));

    }

    /*
    * 문제 : 숫자 문자열과 영단어
    * 실무 일 경우 간단하게 빠르게 replaceAll을 사용 했을 듯.
    * */
    public int solution(String s) {

        s = s.replaceAll("zero", "0")
                .replaceAll("one", "1")
                .replaceAll("two", "2")
                .replaceAll("three", "3")
                .replaceAll("four", "4")
                .replaceAll("five", "5")
                .replaceAll("six", "6")
                .replaceAll("seven", "7")
                .replaceAll("eight", "8")
                .replaceAll("nine", "9");

        return Integer.parseInt(s);
    }

    /* 가장 마음에 드는 정답 */
    public int solution_other(String s) {
        String[] alphabet = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < alphabet.length; i++) {
            s = s.replaceAll(alphabet[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
