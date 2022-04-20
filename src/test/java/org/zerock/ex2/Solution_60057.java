package org.zerock.ex2;

import org.junit.jupiter.api.Test;

public class Solution_60057 {

    @Test
    public void test() {
//        System.out.println("### 7 aabbaccc :: " + solution("aabbaccc"));
//        System.out.println("### 9 ababcdcdababcdcd :: " + solution("ababcdcdababcdcd"));
//        System.out.println("### 8 abcabcdede :: " + solution("abcabcdede"));
//        System.out.println("### 14 abcabcabcabcdededededede :: " + solution("abcabcabcabcdededededede"));
//        System.out.println("### 17 xababcdcdababcdcd :: " + solution("xababcdcdababcdcd"));

//        System.out.println("### 5 xxxxxxxxxxyyy :: " + solution("xxxxxxxxxxyyy"));
//        System.out.println("### 8 bbaabaaaab :: " + solution("bbaabaaaab"));
//        System.out.println("### 7 zzzbbabbabba :: " + solution("zzzbbabbabba"));

//        System.out.println("### 9 acacacbacacac ( 3acba2cac ) :: " + solution("acacacbacacac"));
//        System.out.println("### 9 acacacacacacbacacacacacac ( 6acba5cac ) :: " + solution("acacacacacacbacacacacacac"));
//        System.out.println("### 100a aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa :: " + solution("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));

        System.out.println("### 1 a ( a ) :: " + solution("a"));

    }

    /*
    * 문자열 압축
    * 다른 사람은 재귀 함수 를 이용해서 풀이함.
    * 틀림점 : acacacbacacac - 마지막 cacac 에서 2caca 출력 하지 않았음.
    * 틀림점 : a - 한개일 경우 체크 안했음
    * */


    public int solution(String s) {

        String shortString = "";
        //  i = 길이
        for (int i = 1; i < s.length(); i++) {

            int start = 0;
            String result = "";
            String value = s.substring(0, i);
            int count = 1;

            for (int k = i; k < s.length(); k = k + i){

                if ( k + i > s.length()){
                    result = result + ( count > 1 ? count : "") + value + s.substring(k);
                    break;
                }

                String target = s.substring(k, k + i);

                if ( value.equals(target)){
                    count ++;
                    if ( k + i >= s.length()){
                        result = result + ( count > 1 ? count : "") + value;
                    }
                    continue;
                }
                result = result + ( count > 1 ? count : "") + value;
                value = target;
                count = 1;

                if ( k + i == s.length()){
                    result = result + target;
                    break;
                }

            }

            if ( shortString.isEmpty()
                || ( shortString.length() > result.length() ) ){
                shortString = result;
            }
        }

        if ( shortString.isEmpty() ){
            shortString = s;
        }

        System.out.println(" S :: " + shortString);

        return shortString.length();
    }


}
