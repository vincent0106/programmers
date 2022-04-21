package org.zerock.ex2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution_1829 {

    /*
    * 1829번 초기화 안하면 에러남.
    * 뭔지 모르겠음.
    * 4방향 체크 하는 방식으로 처리
    * */

    @Test
    public void test(){
        System.out.println("#### answer 1 :: " + Arrays.toString(solution(6,4,
                new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }

    /*

    1   1   1   0
    1   2   2   0
    1   0   0   1
    0   0   0   1
    0   0   0   3
    0   0   0   3

    area 1 = "1,2"

    row 기준 첫번째 라인 0, 0 에서 주변 숫자를 가져온다. -> 각각 진행 여부 확인.
    - 영역에 사용된 숫자는  null 안되면 0 처리 -> 숫자가 존재 하는 부분 값만 구함.

    - 영역의 갯수와
    - 넓이
    */


    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] visited = new int[m][n];

        for (int i = 0; i < picture.length; i++) {
            for (int i1 = 0; i1 < picture[i].length; i1++) {
                visited[i][i1] = picture[i][i1];
            }
        }

        for (int i = 0; i < visited.length; i++) {
            int[] row = visited[i];

            for (int k = 0; k < row.length; k++) {

                int sizeOfOneArea = 0;
                int c = 1;

                // 현재 숫자
                int now = row[k];

                // 0 이면 스킵
                if ( now == 0 ){
                    continue;
                }

                visited[i][k] = 0;
                sizeOfOneArea = check4way(now, i, k , visited);

                if ( maxSizeOfOneArea < sizeOfOneArea ){
                    maxSizeOfOneArea = sizeOfOneArea;
                }

                numberOfArea++;

            }

        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int check4way(int now, int x, int y, int[][] visited){

        boolean result = false;
        int move = 1;

        // 1. row -1
        for ( int a = x - 1; a >= 0; a --){
            if (check(now, a, y, visited)){
                move = move + check4way(now, a, y, visited);
            } else {
                break;
            }
        }
        // 2. row + 1
        for ( int a = x + 1; a <= visited.length - 1; a ++){
            if (check(now, a, y, visited)){
                move = move + check4way(now, a, y, visited);
            } else {
                break;
            }
        }

        // 3. column - 1
        for ( int c = y - 1; c >= 0; c --){
            if (check(now, x, c, visited)){
                move = move + check4way(now, x, c, visited);
            } else {
                break;
            }
        }

        // 4. column + 1
        for ( int c = y + 1 ; c <= visited[0].length - 1; c ++){
            if (check(now, x, c, visited)){
                move = move + check4way(now, x, c, visited);
            } else {
                break;
            }
        }

        return move;

    }
    public boolean check(int now, int x, int y, int[][] visited){
        if ( x < 0 || y < 0 ) return false;
        if ( visited[x][y] == 0
                || now != visited[x][y] ){
            return false;
        }
        visited[x][y] = 0;
        return true;
    }


}
