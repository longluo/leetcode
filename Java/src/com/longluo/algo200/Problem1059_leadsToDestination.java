package com.longluo.algo200;

/**
 * 1059. 从始点到终点的所有路径
 * <p>
 * 给定有向图的边 edges，以及该图的始点 source 和目标终点 destination，确定从始点 source 出发的所有路径是否最终结束于目标终点 destination，
 * <p>
 * 即：
 * 从始点 source 到目标终点 destination 存在至少一条路径
 * 如果存在从始点 source 到没有出边的节点的路径，则该节点就是路径终点。
 * 从始点source到目标终点 destination 可能路径数是有限数字
 * 当从始点 source 出发的所有路径都可以到达目标终点 destination 时返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * 输入：n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
 * 输出：false
 * 说明：节点 1 和节点 2 都可以到达，但也会卡在那里。
 * <p>
 * 示例 2：
 * 输入：n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
 * 输出：false
 * 说明：有两种可能：在节点 3 处结束，或是在节点 1 和节点 2 之间无限循环。
 * <p>
 * 示例 3：
 * 输入：n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
 * 输出：true
 * <p>
 * 提示：
 * 1 <= n <= 10^4
 * 0 <= edges.length <= 10^4
 * edges.length == 2
 * 0 <= ai, bi <= n - 1
 * 0 <= source <= n - 1
 * 0 <= destination <= n - 1
 * 给定的图中可能带有自环和平行边。
 * <p>
 * https://leetcode.cn/problems/all-paths-from-source-lead-to-destination/
 */
public class Problem1059_leadsToDestination {

    public static boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

        return false;
    }

    public static void main(String[] args) {

    }
}
