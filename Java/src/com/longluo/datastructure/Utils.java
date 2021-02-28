package com.longluo.datastructure;

import java.util.Arrays;

/**
 * The Utility of ListNode
 */
public class Utils {

    public static void printListNode(ListNode head) {
        if (head == null) {
            System.out.println("");
        }

        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        System.out.println(sb.toString());
    }

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
