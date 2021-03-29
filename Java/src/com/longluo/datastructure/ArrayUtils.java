package com.longluo.datastructure;

import java.util.Arrays;

/**
 *  Array Utils To process The Array
 */
public class ArrayUtils {

    public static String print2DArray(int[][] arr) {
        int row = arr.length;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            sb.append(Arrays.toString(arr[i]));
            if (i < row - 1) {
                sb.append(",");
            }
        }

        return sb.toString();
    }

}
