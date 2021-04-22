package com.demo.leetbookstudy.movingcount;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9h6vo2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MovingCount {

    public static void main(String[] args) {
        System.out.println(movingCount(26,9,4));
    }


    /**
     * 方法一：广度优先搜索
     * 时间复杂度：O(mn)O(mn)，其中 m 为方格的行数，n 为方格的列数。考虑所有格子都能进入，那么搜索的时候一个格子最多会被访问的次数为常数，所以时间复杂度为 O(2mn)=O(mn)O(2mn)=O(mn)。
     *
     * 空间复杂度：O(mn)O(mn)，其中 m 为方格的行数，n 为方格的列数。搜索的时候需要一个大小为 O(mn)O(mn) 的标记结构用来标记每个格子是否被走过。
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount1(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    /**
     *  方法二
     *  递推
     * 思路
     *
     * 考虑到方法一提到搜索的方向只需要朝下或朝右，我们可以得出一种递推的求解方法。
     * @param m
     * @param n
     * @param k
     * @return
     * 复杂度分析
     *
     * 时间复杂度：O(mn)O(mn)，其中 m 为方格的行数， n 为方格的列数。一共有 O(mn)O(mn) 个状态需要计算，每个状态递推计算的时间复杂度为 O(1)O(1)，所以总时间复杂度为 O(mn)O(mn)。
     *
     * 空间复杂度：O(mn)O(mn)，其中 m 为方格的行数，n 为方格的列数。我们需要 O(mn)O(mn) 大小的结构来记录每个位置是否可达。
     *
     */
    public int movingCount2(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        vis[0][0] = true;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;
                }
                // 边界判断
                if (i - 1 >= 0) {
                    vis[i][j] |= vis[i - 1][j];
                }
                if (j - 1 >= 0) {
                    vis[i][j] |= vis[i][j - 1];
                }
                ans += vis[i][j] ? 1 : 0;
            }
        }
        return ans;
    }

    /**
     *  方法三，dps 递推
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }
    public static int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if(i >= m || j >= n || k < sunNumber(i) + sunNumber(j) || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
    }



    /**
     *  自己写的错误方法
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int movingCountError(int m,int n,int k){
        int number = 0;
        boolean is = isLessThanK(m/2,n/2,k);
        for (int i = 0; i < m; i++) {
            if (!is && i>m/2){
                break;
            }
            for (int j = 0; j <n ; j++) {
                if (isLessThanK(i,j,k)){
                    // +1
                    number++;
                }else {
                    break;
                }
            }
        }
        return number;
    }



    /**
     * 判断
     * @param m
     * @param n
     * @param k
     * @return
     */
    private static boolean isLessThanK(int m,int n,int k){
        int number = 0;
        number += sunNumber(m);
        number += sunNumber(n);
        System.out.println("m: "+m+" n: "+n+" k: "+k+" number: "+number);
        return number <= k;
    }


    public static int sunNumber(int x){
        int s = 0;
        while(x != 0) {
            s += x % 10;
            x = x / 10;
        }
        return s;
    }


}
