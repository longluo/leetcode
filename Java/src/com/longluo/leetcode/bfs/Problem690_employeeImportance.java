package com.longluo.leetcode.bfs;

import java.util.*;

/**
 * 690. 员工的重要性
 * <p>
 * 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
 * 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。
 * 那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。
 * 注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 * <p>
 * 示例：
 * 输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出：11
 * 解释：
 * 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。
 * 因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 * <p>
 * <p>
 * 提示：
 * 一个员工最多有一个 直系 领导，但是可以有多个 直系 下属
 * 员工数量不超过 2000。
 * <p>
 * https://leetcode-cn.com/problems/employee-importance/
 */
public class Problem690_employeeImportance {

    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public static int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }

        int n = employees.size();
        int ans = 0;
        Queue<Employee> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (employees.get(i).id == id) {
                queue.offer(employees.get(i));
                ans += employees.get(i).importance;
            }
        }

        while (!queue.isEmpty()) {
            Employee employee = queue.poll();
            List<Integer> subs = employee.subordinates;
            if (subs != null && subs.size() > 0) {
                for (int i = 0; i < subs.size(); i++) {
                    for (int j = 0; j < employees.size(); j++) {
                        if (subs.get(i).intValue() == employees.get(j).id) {
                            queue.offer(employees.get(j));
                            ans += employees.get(j).importance;
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static int total = 0;

    public static int getImportance_dfs(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }

        int n = employees.size();
        for (int i = 0; i < n; i++) {
            if (employees.get(i).id == id) {
                total += employees.get(i).importance;
                List<Integer> subs = employees.get(i).subordinates;
                for (int j = 0; j < subs.size(); j++) {
                    getImportance_dfs(employees, subs.get(j).intValue());
                }
            }
        }

        return total;
    }

    public static int getImportance_hash(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int ans = 0;
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            Employee employee = map.get(curId);
            ans += employee.importance;
            List<Integer> subs = employee.subordinates;
            for (int subId : subs) {
                queue.offer(subId);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
