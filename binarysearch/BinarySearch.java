package com.xudt.algorithm.algorithm.binarysearch;

/**
 * @Description: 实现二分查找算法
 * @Author: XuDT
 */
public class BinarySearch {
    /**
     * 有序数组
     */
    private int[] arr;
    /**
     * 数组长度
     */


    public static int binarySearch(int[] arr, int val){
        if (arr.length == 0){
            throw new IllegalArgumentException("");
        }
        int high = arr.length;
        for (int low = 0; low <= high;){
            int mid = (low + high) / 2;
            if (arr[mid] == val){
                return mid;
            }else if (arr[mid] > val){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
