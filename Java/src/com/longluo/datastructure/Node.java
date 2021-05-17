package com.longluo.datastructure;

import java.util.List;

/**
 *  The Node Structure
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {

    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
