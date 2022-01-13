package org.zerock.ex2;

import org.junit.jupiter.api.Test;

public class Solution_72410 {

    @Test
    public void test() {

        String new_id = "..1.2.3.@!#$-qwe.....1..";

        String answer =  solution(new_id);

        System.out.println("###### answer : " + answer);

    }

    // https://programmers.co.kr/learn/challenges
    /*
    * 문제 : 신규 아이디 추천
    * 문제점 및 배운점 : replaceAll 에 정규식으로 처리하면 깔끔하게 떨어진다.
    * while 처리
    * */
    public String solution(String new_id) {
        String answer = "";
        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();
        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        answer = new_id.replaceAll("[^a-zA-Z0-9-_.]", "");

        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        answer = answer.replaceAll("[.]+", ".");

        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        answer = answer.replaceAll("^[.]|[.]$", "");

        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (answer.equals("")){
            answer = "a";
        }

        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if ( answer.length() >= 16 ){
            answer = answer.substring(0, 15);
        }
        //      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if ( answer.endsWith(".")){
            answer = answer.substring(0, answer.length() - 1);
        }

        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if ( answer.length() < 3 ){
            String endString = answer.substring(answer.length() -1);
            for (int i = answer.length(); i < 3; i ++){
                answer = answer + endString;
            }
        }
        return answer;
    }
}
