package com.longluo.leetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 707. 设计链表
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
 * 假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * 示例：
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 * <p>
 * 提示：
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 * <p>
 * https://leetcode.cn/problems/design-linked-list/
 */
public class Problem707_designLinkedList {

    static class MyLinkedList {
        List<Integer> nums;

        public MyLinkedList() {
            nums = new LinkedList<>();
        }

        public int get(int index) {
            if (index < nums.size()) {
                return nums.get(index);
            }

            return -1;
        }

        public void addAtHead(int val) {
            nums.add(0, val);
        }

        public void addAtTail(int val) {
            nums.add(val);
        }

        public void addAtIndex(int index, int val) {
            index = Math.max(index, 0);
            if (index <= nums.size()) {
                nums.add(index, val);
            }
        }

        public void deleteAtIndex(int index) {
            if (index < nums.size()) {
                nums.remove(index);
            }
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */

    public static void main(String[] args) {
        MyLinkedList tst1 = new MyLinkedList();
        tst1.addAtHead(1);
        tst1.addAtTail(3);
        tst1.addAtIndex(3, 2);
        tst1.deleteAtIndex(1);
    }
}
