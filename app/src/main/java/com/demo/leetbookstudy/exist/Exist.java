package com.demo.leetbookstudy.exist;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58wowd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * [["C","A","A"],["A","A","A"],["B","C","D"]]
 * "AAB"
 *
 */
public class Exist {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        System.out.println(exist(board,"AAB"));
    }

    /**
     *  失败的
     * @param board
     * @param word
     * @return
     */
    public static boolean exist1(char[][] board,String word){
        if (word == null){
            return false;
        }
        char[] chars =word.toCharArray();
        char firstWord = chars[0];
        int x,y;
        // 1. 找到第一个坐标
        for (int i = 0; i < board.length; i++) {
            char[] firsts = board[i];
            for (int j = 0; j < firsts.length; j++) {
                char str = board[i][j];
                System.out.println("str: "+str);
                if (str == firstWord){
                    char[][] tmp = board.clone();
                    tmp[i][j] = ' ';
                    x = i;
                    y = j;
                    // 第一个
                    for (int k = 1; k < chars.length; k++) {
                        char strW = chars[k];
                        System.out.println("x: "+x+" y:"+y);
                        if (x-1>=0){
                            char str1 = tmp[x-1][y];
                            if (strW == str1){
                                tmp[x-1][y] = ' ';
                                x = x-1;
                                continue;
                            }
                        }
                        if (x+1<board.length){
                            char str2 = tmp[x+1][y];
                            System.out.println(str2);
                            if (strW == str2){
                                tmp[x+1][y] = ' ';
                                x = x+1;
                                continue;
                            }
                        }

                        if (y-1>=0){
                            System.out.println("x: "+x+" y:"+(y-1));
                            char str3 = tmp[x][y-1];
                            System.out.println(str3);
                            if (strW == str3){
                                tmp[x][y-1] = ' ';
                                y=y-1;
                                continue;
                            }
                        }

                        if (y+1<firsts.length){
                            char str4 = tmp[x][y+1];
                            if (strW == str4){
                                tmp[x][y+1] = ' ';
                                y=y+1;
                                continue;
                            }else {
                                return false;
                            }
                        }else {
                            return false;
                        }
                    }

                    return true;
                }

            }
        }
        return false;
    }


    /**
     *  官方解答
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean  dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if(k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

}
