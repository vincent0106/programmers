package org.zerock.ex2.lot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lot_Solution_1 {

    @Test
    public void test(){

        System.out.println("#### answer 1 :: " + solution(7, new int[][]{{1,2},{2,5},{2,6},{1,3},{1,4},{3,7}},
                new String[]{"root","abcd","cs","hello","etc","hello","solution"}));

        System.out.println("#### answer 2 :: " + solution(7, new int[][]{{1,2},{2,3},{3,4},{4,5},{1,6},{6,7}},
                new String[]{"root","a","b","c","d","efghij","k"}));

    }

    public int solution(int N, int[][] relation, String[] dirname) {

        int maxLength = dirname[0].length();

        for (int[] node : relation) {
            if ( node[0] != 1 ){
                continue;
            }
            List<int[]> target = Arrays.stream(relation).filter(a -> a[0] == node[1]).collect(Collectors.toList());
            int newLength = getLength(dirname[0].length() + ("/" + dirname[node[1]-1]).length(), node, target, relation, dirname);
            if ( maxLength < newLength ){
                maxLength = newLength;
            }
        }

        return maxLength;
    }

    public int getLength(int length, int[] node, List<int[]> target, int[][] relation, String[] dirname){
        int maxLength = length;

        if ( target.size() == 0 ){
            return length;
        }

        for (int i = 0; i < target.size(); i++) {
            int targetVal = target.get(i)[1];
            List<int[]> newTarget = Arrays.stream(relation).filter(a -> a[0] == targetVal).collect(Collectors.toList());
            int len  = length + getLength(("/" + dirname[targetVal-1]).length(), target.get(i), newTarget, relation, dirname);;
            if ( len > maxLength ){
                maxLength = len;
            }
        }
        return maxLength;
    }
}
