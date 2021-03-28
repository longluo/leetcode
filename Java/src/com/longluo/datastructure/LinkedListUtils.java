package com.longluo.datastructure;

import java.util.Arrays;

/**
 * The Utility of ListNode
 */
public class LinkedListUtils {
    
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

    public static ListNode makeListNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode backup = head;
        for (int i = 0; i < array.length; i++) {
            ListNode temp = new ListNode(array[i]);
            head.next = temp;
            head = head.next;
        }

        return backup.next;
    }

    public static String printLinkedList(ListNode head) {
        if (head == null) {
            return "[]";
        } else if (head.next == null) {
            return "[" + head.val + "]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            head = head.next;
            if (head != null) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
