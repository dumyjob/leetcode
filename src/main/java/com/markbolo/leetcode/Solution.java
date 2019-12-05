package com.markbolo.leetcode;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 查找2个有序数组的中位数
        int m = nums1.length;
        int n = nums2.length;

        if(m>n){
            // 总是从长度最小的数组进行2分
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0, hi = 2*m;

        // 切点
        int ci, cj;
        // 切割的左右元素
        int li = 0, ri = 0 , lj = 0 ,rj = 0;
        while(low <= hi){
            // 二分操作
            ci = (low + hi) /2;
            cj = (m +n)  - ci;

            li = ci==0 ? Integer.MIN_VALUE: nums1[(ci-1)/2];
            ri = ci==2*m ? Integer.MAX_VALUE : nums1[ci/2];

            lj = cj==0 ? Integer.MIN_VALUE : nums2[(cj-1)/2];
            rj = cj==2*n ? Integer.MAX_VALUE : nums2[cj/2];

            // 下一波二分准备
            if(li > rj){
                // 数组nums1大的元素多, ci↓ cj ↑
                // 通过改变hi值来推进ci ↓
                hi = ci -1;
            } else if (lj > ri){
                // 数组nums2大的元素多, ci↑ cj ↓
                // 通过改变low值来推进ci↑
                low = ci +1;
            } else {
                // 满足条件： li < rj && lj < ri && i + j = m+n , 找到中位数值
                break;
            }
        }

        // 这里就不能是整除了
        return  ((double)(max(li, lj) + min(ri, rj)))  /2;
    }


    private static int max(int num1, int num2){
        // 找出2数大值
        return num1 >= num2 ? num1 : num2;
    }

    private static int min(int num1, int num2){
        // 找出2数小值
        return num1 <= num2 ? num1 : num2;
    }
}
