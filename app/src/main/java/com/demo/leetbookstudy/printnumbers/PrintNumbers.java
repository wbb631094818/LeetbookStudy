package com.demo.leetbookstudy.printnumbers;

/**
 * 剑指 Offer 17. 打印从 1 到最大的 n 位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 这题不用管大数，比较简单
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/594wfg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class PrintNumbers {

    public int[] printNumbers(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append("9");
        }
        int max = Integer.parseInt(stringBuilder.toString());
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i]=i+1;
        }
        return res;
    }

    public int[] printNumbers2(int n) {
        int m=(int)Math.pow(10,n);
        int[] mm=new int[m-1];
        for(int i=1;i<m;i++){
            mm[i-1]=i;
        }
        return mm;
    }

    //   大数的方法，比较难
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers3(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }


    public static void main(String[] args) {

    }
}
