package com.xudt.algorithm.algorithm.test;

import static com.xudt.algorithm.algorithm.binarysearch.BinarySearch.binarySearch;

/**
 * @Description: 二分查找测试类
 * @Author: XuDT
 */
public class BinarySearchTest {
    public static void main(String[] args){
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
        int index = binarySearch(arr, 10);
        System.out.println(index);
    }
}
