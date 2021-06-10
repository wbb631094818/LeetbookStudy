package com.demo.leetbookstudy.search;

public class Search {

    /**
     *  比较暴力法二分法
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length<=0){
            return 0;
        }
        int i = 0,j = nums.length;
        while (i<j){
            int m = (i+j)/2;
            System.out.println("m: "+m+" i: "+i);
            if (target > nums[m]){
                i = m+1;
            }else if (target <nums[m]){
                j = m-1;
            }else {
                int k = m+1;
                int count = 1;
                System.out.println("m: "+m+" k: "+k);
                while (k<nums.length && nums[k]==target){
                    k++;
                    count++;
                }
                k = m-1;
                System.out.println("m: "+m+" k: "+k);
                while (k>=0 && nums[k] == target){
                    k--;
                    count++;
                }
                return count;
            }
        }
        int count = 0;
        if (i!=0){
            i--;
        }
        if (j<nums.length-1) {
            j++;
        }
        for (int k = i; k < j; k++) {
            if (nums[k] == target){
                count++;
            }
        }
        return count;
    }

    public static int search1(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
   static int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) {
                i = m + 1;
            } else {
                j = m - 1;
            }
            System.out.println("i: "+i +"  target: "+tar);
        }
        return i;
    }


    public static void main(String[] args) {
        System.out.println("输出："+search1(new int[]{5,6,8,8,8,9},8));
    }
}
