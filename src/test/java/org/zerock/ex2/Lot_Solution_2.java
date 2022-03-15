package org.zerock.ex2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Lot_Solution_2 {

    @Test
    public void test(){

        System.out.println("#### answer 1 :: " + solution(new int[][]{{0,0,1,0,0},{0,1,1,0,1},{0,0,1,0,1},{1,1,1,0,1}}));


    }

    public int solution(int[][] maps){

        List<List<Node>> temp = new ArrayList<>();

        for (int x = 0; x < maps.length; x++) {
            for (int y = 0; y < maps[0].length; y++) {

                if (maps[x][y] == 0){
                    continue;
                }

                List<Node> nodes = check(x, y, temp);

                boolean isFirst = false;

                if ( temp.size() == 0 ){
                    nodes = new ArrayList<>();
                    nodes.add(new Node(x, y));
                    temp.add(nodes);
                    isFirst = true;
                }

                boolean test = false;
                for (int i = 0; i < maps[0].length; i++) {
                    if (!addFriend(x, i, maps, nodes, temp) ){
                        test = true;
                    }
                }

                for (int i = maps[0].length -1 ; i >= 0; i--) {
                    if (!addFriend(x, i, maps, nodes, temp) ){
                        test = true;
                    }
                }

               /* if ( !isFirst && !test ){
                    nodes = new ArrayList<>();
                    nodes.add(new Node(x, y));
                    temp.add(nodes);
                }*/

                if ( !isFirst && check(x, y, temp) == null ){
                    nodes = new ArrayList<>();
                    nodes.add(new Node(x, y));
                    temp.add(nodes);
                }

            }
        }

        int maxValue = 0;
        for (List<Node> nodes : temp) {
            int nodeValue = 0;
            for (Node node : nodes) {
                nodeValue = nodeValue + getValue(node, nodes);
            }

            if ( maxValue < nodeValue ){
                maxValue = nodeValue;
            }
        }



        return maxValue;
    }

    public int getValue(Node node, List<Node> temp){
        int value = 4;

        for (Node tempNode : temp) {
            if (node.getX() - 1 == tempNode.getX() && node.getY() == tempNode.getY()) {
                value--;
            }
            if (node.getX() + 1 == tempNode.getX() && node.getY() == tempNode.getY()) {
                value--;
            }
            if (node.getX() == tempNode.getX() && node.getY() - 1 == tempNode.getY()) {
                value--;
            }
            if (node.getX() == tempNode.getX() && node.getY() + 1 == tempNode.getY()) {
                value--;
            }
        }
        return value;
    }

    public boolean addFriend(int x, int y, int[][] maps, List<Node> nodes, List<List<Node>> temp){

        boolean result = false;

        if ( maps[x][y] != 1 ){
            return false;
        }
        boolean includeCheck = false;

        if ( nodes == null ){
            return false;
        }

        for (Node node : nodes) {
            if ( node.getX() == x && node.getY() == y){
                includeCheck = true;
            }
        }
        if ( !includeCheck ){
            return false;
        }

        if ( x - 1 >= 0 ){
            if ( maps[x-1][y] == 1) {
                if ( nodes != null && !checkNode(x-1, y, nodes) ){
                    nodes.add(new Node(x-1, y));
                    result = true;
                } else {
                    List<Node> tempNodes = check(x-1, y, temp);
                    if ( tempNodes != null ) {
                        tempNodes.add(new Node(x - 1, y));
                        result = true;
                    }
                }
            }
        }
        if ( x + 1 < maps.length ){
            if ( maps[x+1][y] == 1) {
                if ( nodes != null && !checkNode(x+1, y, nodes) ){
                    nodes.add(new Node(x+1, y));
                    result = true;
                } else {
                    List<Node> tempNodes = check(x+1, y, temp);
                    if ( tempNodes != null ) {
                        tempNodes.add(new Node(x + 1, y));
                        result = true;
                    }
                }
            }
        }
        if ( y - 1 >= 0 ){
            if ( maps[x][y-1] == 1) {
                if ( nodes != null && !checkNode(x, y-1, nodes) ){
                    nodes.add(new Node(x, y-1));
                    result = true;
                } else {
                    List<Node> tempNodes = check(x, y-1, temp);
                    if ( tempNodes != null ) {
                        tempNodes.add(new Node(x, y - 1));
                        result = true;
                    }
                }
            }
        }
        if ( y + 1 < maps[x].length){
            if ( maps[x][y+1] == 1) {
                if ( nodes != null && !checkNode(x, y+1, nodes) ){
                    nodes.add(new Node(x, y+1));
                    result = true;
                } else {
                    List<Node> tempNodes = check(x, y+1, temp);
                    if ( tempNodes != null ){
                        tempNodes.add(new Node(x, y+1));
                        result = true;
                    }

                }
            }
        }
        return result;
    }

    public boolean checkNode(int i, int y, List<Node> nodes){
        for (Node node : nodes) {
            if(node.getX() == i && node.getY() == y){
                return true;
            }
        }
        return false;
    }

    public List<Node> check(int i, int y, List<List<Node>> temp){
        for (List<Node> nodes : temp) {
            for (Node node : nodes) {
                if(node.getX() == i && node.getY() == y){
                    return nodes;
                }
            }
        }
        return null;
    }

    public class Node {
        int x;
        int y;

        Node (int x, int y){
            this.x = x;
            this.y = y;

        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }


}
