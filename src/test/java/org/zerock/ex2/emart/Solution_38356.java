package org.zerock.ex2.emart;

import org.junit.jupiter.api.Test;

public class Solution_38356 {

    @Test
    public void test_1(){
        System.out.println("### hihihi :: " + solution("3(hi)"));
        System.out.println("### hihihicohihihico :: " + solution("2(3(hi)co)"));
        System.out.println("### pppppppppp :: " + solution("10(p)"));
        System.out.println("### hihicocohihicocoxbobo :: " + solution("2(2(hi)2(co))x2(bo)"));
    }

    public String solution(String compressed) {

        now = 0;
        return check(compressed);


    }

    int now = 0;

    public String check(String text){
        String result = "";

        int count = 0;
        String value = "";
        String before = null;

        for ( int i = 1; i < text.length() + 1; i ++ ){
            String compareStr = text.substring(now + i -1 , now +i);
            //now = i;
            if ( Character.isDigit(compareStr.charAt(0))){

                if ( count != 0 ){
                    now = i -1;
                    value = check(text);
                    continue;
                }

                if ( before != null && Character.isDigit(before.charAt(0)) ){
                    compareStr = before + compareStr;
                }
                count = Integer.parseInt(compareStr);
                before = compareStr;
                continue;
            }
            if ( "(".equals(compareStr) ){
//                value = check(text.substring(i -1 , i));
                before = compareStr;
                continue;
            }
            if ( ")".equals(compareStr)){

                for (int k = 0; k < count; k ++){
                    result += value;
                }
                before = compareStr;
                now = i -1;
                break;
            }
            before = compareStr;
            value += compareStr;

        }


        return result;
    }


    public String check2(String text){
        String result = "";
        long count = 0;
        for ( int i = 1; i < text.length() ; i ++ ){

//            String compareStr = result + text.substring(0, i);
            String compareStr = text.substring(0, i);

            if (text.split(compareStr, 2)[1].contains(compareStr)){
                result = compareStr;
            } else {
                count = text.replaceAll(result, "@").length();
                break;
            }
        }
        return count + "(" + result + ")";
    }
}
