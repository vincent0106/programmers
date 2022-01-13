package org.zerock.ex2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution_67256 {

    @Test
    public void test() {

        System.out.println("###### answer : " + solution(new int[] {0,9,5,3,3,2}, "left"));

       // System.out.println("###### answer : " + solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
       // System.out.println("###### answer : " + solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        // LRLLRRLLLRR
        // LRLLRRLLLRR
       // System.out.println("###### answer : " + solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
        // LLRLLRLLRL
        // LLRLLRLLRL

    }

    int[][] two = {{1,3,5}, {4,6,8}, {7,9,0}, {10, 11}};
    int[][] five = {{2,4,6,8}, {1,3,7,9,0}, {10, 11}};
    int[][] eight = {{5,7,9,0}, {2,4,6,10,11}, {1,3}};
    int[][] zero = {{8, 10, 11}, {5,7,9}, {2,4,6}, {1,3}};

    int[] leftNum = {1,4,7};
    int[] rightNum = {3,6,9};
    int[] middleNum = {2,5,8,0};

    public String solution(int[] numbers, String hand) {

        String answer = "";

        //LRLL L RLL RRL
        //LRLL L RLL RRL

        /*int[][] one = {{2},{5},{8},{0}};
        int[][] four = {{5},{2,8},{0}};
        int[][] seven = {{8},{5,0},{2}};
        int[][] snow = {{0},{8},{5},{2}};
*/

        int leftFinger = 10;
        int rightFinger = 11;


        for (int i = 0; i < numbers.length; i++) {

            for (int l : leftNum) {
                if ( numbers[i] == l ){
                    answer += "L";
                    leftFinger = numbers[i];
                    break;
                }
            }

            for (int r : rightNum) {
                if ( numbers[i] == r ){
                    answer += "R";
                    rightFinger = numbers[i];
                    break;
                }
            }

            for (int mid : middleNum){
                if ( numbers[i] == mid ){
                    String result = null;

                    if ( numbers[i] == 2 ){
                        result = finger(leftFinger, rightFinger, hand, two);
                    }

                    if ( numbers[i] == 5 ){
                        result = finger(leftFinger, rightFinger, hand, five);
                    }

                    if ( numbers[i] == 8 ){
                        result = finger(leftFinger, rightFinger, hand, eight);
                    }

                    if ( numbers[i] == 0 ){
                        result = finger(leftFinger, rightFinger, hand, zero);
                    }

                    if ( result == null ){
                        continue;
                    }

                    answer += result;

                    if ( "L".equals(result) ){
                        leftFinger = numbers[i];
                    }

                    if ( "R".equals(result) ){
                        rightFinger = numbers[i];
                    }

                    break;
                }
            }

            //System.out.println("#  " + leftFinger + " / "+ rightFinger + " / "+ numbers[i] + " / "+ answer);
        }

        return answer;
    }


    public String finger(int leftFinger, int rightFinger, String hand, int[][] array){

        for (int i = 0; i < array.length; i++) {
            int left = 9;
            int right = 9;

            for (int k = 0; k < array[i].length; k++) {
                if ( array[i][k] == leftFinger ){
                    left = i;
                }
                if ( array[i][k] == rightFinger ){
                    right = i;
                }
                if ( left != 9 && right != 9){
                    break;
                }
            }

            if ( left == 9 && right == 9){
                continue;
            }

            if ( left < right ){
                return "L";
            }

            if ( left > right ){
                return "R";
            }

            if ( "left".equals(hand) ){
                return "L";
            }

            if ( "right".equals(hand) ){
                return "R";
            }
            break;
        }

        return null;
    }


}
