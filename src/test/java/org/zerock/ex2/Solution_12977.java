package org.zerock.ex2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_12977 {

    // 소수 만들기
    // 에라토스트네스의 체 : 소수 판별 알고리즘 - 사용 해도 되고 안써 도 되고
    @Test
    public void test(){
        System.out.println("### " + solution(new int[]{1,2,3,4}));
        System.out.println("### " + solution(new int[]{1,2,7,6,4}));
//        System.out.println("### " + solution2(new int[]{1,2,3,4}));
//        System.out.println("### " + solution2(new int[]{1,2,7,6,4}));
//        System.out.println("### 10 : " + Arrays.toString(temp1(100)));
    }


    // 에라토스트네스의 체 : X
    public int solution(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i <= nums.length - 3; i++){
            for (int k = i + 1; k <= nums.length - 2; k++){
                for (int j = k +1; j <= nums.length -1; j++){
                    list.add(nums[i] + nums[k] + nums[j]);
                }
            }
        }

        return Integer.parseInt(String.valueOf(list.stream().filter(this::isPrime).count()));
    }

    // 에라토스트네스의 체 : O
    public int solution2(int[] nums) {

        // 소수 : false
        boolean[] temp = new boolean[3000];

        for (int i = 2; i < temp.length; i++) {
            for ( int k = 2; i * k < temp.length; k++){
                temp[i * k] = true;
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i <= nums.length - 3; i++){
            for (int k = i + 1; k <= nums.length - 2; k++){
                for (int j = k +1; j <= nums.length -1; j++){
                    list.add(nums[i] + nums[k] + nums[j]);
                }
            }
        }

        return Integer.parseInt(String.valueOf(list.stream().filter(a -> !temp[a]).count()));
    }

    public boolean isPrime(int value){
        for ( int i = 2; i < value; i ++){
            if ( value % i == 0 ) return false;
        }
        return value > 1;
    }



    // 에라토스트네스의 체 : 소수 판별 알고리즘
    public int[] temp1(int num) {

        int[] nums = new int[num + 1];

        for (int i = 2; i <= num; i++) {
            nums[i] = i;
        }

        for (int i : nums) {
            if ( i == 0 ) continue;
            for ( int k = 2; num >= i * k; k++){
                nums[i * k] = 0;
            }
        }

        return Arrays.stream(nums).filter(val -> val != 0).toArray();
    }
}
