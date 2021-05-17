package com.longluo.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Array Utils To process The Array
 */
public class ArrayUtils {

    /**
     * Print the array.
     */
    public static String print2DArray(int[][] arr) {
        int row = arr.length;

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < row; i++) {
            sb.append(Arrays.toString(arr[i]));
            if (i < row - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Print the list.
     */
    public static String print2DList(List<List<Integer>> input) {
        if (input == null || input.size() == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder(input.size());
        sb.append("[");
        for (int i = 0; i < input.size(); i++) {
            sb.append("[");
            List<Integer> currList = input.get(i);
            for (int j = 0; j < currList.size(); j++) {
                sb.append(currList.get(j));
                if (j < currList.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            if (i < input.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("print2DArray -->");
        int[][] tstArr1 = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        System.out.println("[[1, 2, 3],[8, 9, 4],[7, 6, 5]] ?= " + print2DArray(tstArr1));

        System.out.println("print2DList -->");
        List<List<Integer>> tstList1 = new ArrayList<>();
        tstList1.add(new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }});
        tstList1.add(new ArrayList<>() {{
            add(4);
            add(5);
            add(6);
        }});
        tstList1.add(new ArrayList<>() {{
            add(7);
            add(8);
            add(9);
        }});
        System.out.println(" [[1,2,3][4,5,6][7,8,9]] ?= " + print2DList(tstList1));
        tstList1.remove(0);
        System.out.println(" [[4,5,6][7,8,9]] ?= " + print2DList(tstList1));
    }
}
