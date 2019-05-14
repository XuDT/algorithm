package com.xudt.algorithm.algorithm.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static com.xudt.algorithm.algorithm.sort.Sort.bubbleSort;
import static com.xudt.algorithm.algorithm.sort.Sort.heapSort;
import static com.xudt.algorithm.algorithm.sort.Sort.insertSort;
import static com.xudt.algorithm.algorithm.sort.Sort.mergeSort;
import static com.xudt.algorithm.algorithm.sort.Sort.quickSort;
import static com.xudt.algorithm.algorithm.sort.Sort.selectSort;
import static com.xudt.algorithm.algorithm.sort.Sort.shellSort;

/**
 * @Description: 排序测试类
 * @Author: XuDT
 */
public class SortTest {
    private static final Logger log = LoggerFactory.getLogger(SortTest.class);

    public static void main(String[] args) {
        final int SIZE = 10000;
        //冒泡排序
        int[] bubleArr = create(SIZE);
        bubbleSort(bubleArr);
        output(bubleArr);
        //选择排序
        int[] selectArr = create(SIZE);
        selectSort(selectArr);
        output(selectArr);
        //直接插入排序
        int[] insertArr = create(SIZE);
        insertSort(insertArr);
        output(insertArr);
        //希尔排序
        int[] shellArr = create(SIZE);
        shellSort(shellArr);
        output(shellArr);
        //堆排序
        int[] heapArr = create(SIZE);
        heapSort(heapArr);
        output(heapArr);
        //归并排序
        int[] mergeArr = create(SIZE);
        long mergeSortStartTime = System.currentTimeMillis();
        mergeSort(mergeArr, 0 , mergeArr.length-1);
        long mergeSortEndTime = System.currentTimeMillis();
        long mergeSortTime = mergeSortEndTime - mergeSortStartTime;
        log.info("对{}个随机数进行归并排序所需的时间为：{}ms", mergeArr.length, mergeSortTime);
        output(mergeArr);
        //快速排序
        int[] quickArr = create(SIZE);
        long quickSortStartTime = System.currentTimeMillis();
        quickSort(quickArr, 0 , quickArr.length-1);
        long quickSortEndTime = System.currentTimeMillis();
        long quickSortTime = quickSortEndTime - quickSortStartTime;
        log.info("对{}个随机数进行快速排序所需的时间为：{}ms", quickArr.length, quickSortTime);
        output(quickArr);
    }

    /**
     * 创建随机数数组
     *
     * @param size 数组大小
     * @return 数组
     */
    public static int[] create(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        long randomStartTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(size);
        }
        long randomEndTime = System.currentTimeMillis();
        long randomTime = randomEndTime - randomStartTime;
        log.info("生成{}个随机数所需时间为：{}ms", size, randomTime);
        return arr;
    }

    /**
     * 输出数组
     *
     * @param arr 目标数组
     */
    public static void output(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        log.info("输出数组为：{}", sb.toString());
    }
}
