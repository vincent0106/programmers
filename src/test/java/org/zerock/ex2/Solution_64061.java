package org.zerock.ex2;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution_64061 {

    @Test
    public void test() {


        System.out.println("###" + solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));

    }

    /*
    * 크레인 인형 뽑기 게임
    * Stack 사용 peek 처리로 수정
    * Stack.isEmpty 처리가 어디에 있느냐에 따른 수정
    * */
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> box = new Stack<>();

        for (int move : moves) {
            int doll = 0;
            for (int[] temp : board) {
                if (temp[move -1] != 0){
                    doll = temp[move -1];
                    temp[move -1] = 0;
                    break;
                }
            }

            System.out.println("### Stack :: " + box + "  / doll :: " + doll);

            if ( !box.isEmpty() && box.peek() == doll ){
                box.pop();
                answer = answer + 2;
                continue;
            }
            if ( doll != 0 ){
                box.push(doll);
            }
        }

        return answer;
    }

}
