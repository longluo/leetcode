package com.longluo.algorithm;

/**
 * UnionFind
 * <p>
 * 如何表示节点与节点之间的连通性关系呢？？
 * <p>
 * 如果 p 和 q 连通，则它们有相同的根节点
 * <p>
 * 用数组 parent[] 来表示这种关系
 * 如果自己就是根节点，那么 parent[i] = i，即自己指向自己
 * 如果自己不是根节点，则 parent[i] = root id
 */
public class UnionFind {

    private int count;

    private int[] parent;
    private int[] size;

    // 构造函数
    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            // 最初，每个节点均是独立的
            parent[i] = i;
            // 最初，每个连通分量均为 1
            size[i] = 1;
        }
    }

    // 将 x 和 y 连接
    // 只有在调用 union() 方法时，才可能改变连通分量的数量
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }

        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }

        // 连通分量 -1
        count--;
    }

    // 判断 x 和 y 是否连通
    public boolean isConnected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        return rootX == rootY;
    }

    // 返回图中有多少个连通分量
    // 维护一个全局变量，来记录图的连通分量的数量
    public int count() {
        return this.count;
    }

    // 返回当前节点的根节点
    // 路径压缩
    //  思路：使树高始终保持为常数
    public int find(int x) {
        while (x != parent[x]) {
            // 进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);

    }
}
