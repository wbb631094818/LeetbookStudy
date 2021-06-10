package com.demo.leetbookstudy.findnumberIn2Darray;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5v76yi/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            int[] nums = matrix[i];
            if (nums[0] > target) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (nums[j] == target) {
                    return true;
                }
                if (nums[j] > target) {
                    n = j;
                    break;
                }
            }
        }
        return false;
    }


    /**
     * 从左下角开始，判断如果该数大于target 纵坐标m-1(说明横坐标右边所有的数都比它大) 如果小于 横坐标你n+1
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }


}