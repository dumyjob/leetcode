package com.markbolo.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {


    @Test
    public void testFindMedianSortedArrays(){
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3};

        Solution solution = new Solution();

        double mid = solution.findMedianSortedArrays(nums1, nums2);

        Assert.assertEquals(2.0d, mid,0);


        nums1 = new int[]{2,3,5};
        nums2 = new int[]{1,4,7,9};

        mid = solution.findMedianSortedArrays(nums1, nums2);

        Assert.assertEquals(4.0d, mid,0);


        nums1 = new int[]{1,2};
        nums2 = new int[]{3,4};

        mid = solution.findMedianSortedArrays(nums1,nums2);

        Assert.assertEquals(2.5d, mid, 0);
    }

}
