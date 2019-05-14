package com.xudt.algorithm.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 排序算法
 * @Author: XuDT
 */
public class Sort {
    private static final Logger log = LoggerFactory.getLogger(Sort.class);

    /**
     * 冒泡排序
     * 实现思路：当i=1时，j反向循环到1，逐个比较，将较小值交换到前面，直到最后找到最小值放在第一的位置。
     * 在不断循环的过程中，不仅将最小值放在了第一的位置，还将另一关键字的位置提前。
     * @param arr 待排序数据
     */
    public static void bubbleSort(int[] arr) {
        long sortStartTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i; j--) {
                if (arr[i] > arr[j]) {
                    swapElem(arr, i, j);
                }
            }
        }
        long sortEndTime = System.currentTimeMillis();
        long sortTime = sortEndTime - sortStartTime;
        log.info("对{}个随机数进行冒泡排序所需的时间为：{}ms", arr.length, sortTime);
    }

    /**
     * 选择排序
     * 实现思路：将当前下标定义为最小值，与之后的数据进行比较，如果小于当前最小值，则将此关键字的下标赋值给min，若min≠i，则说明找到最小值，进行交换
     * @param arr 待排序数据
     */
    public static void selectSort(int[] arr) {
        long sortStartTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                swapElem(arr, i, min);
            }
        }
        long sortEndTime = System.currentTimeMillis();
        long sortTime = sortEndTime - sortStartTime;
        log.info("对{}个随机数进行选择排序所需的时间为：{}ms", arr.length, sortTime);
    }

    /**
     * 直接插入排序
     * @param arr 待排序数据
     */
    public static void insertSort(int[] arr) {
        long sortStartTime = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swapElem(arr, j, j + 1);
            }
        }
        long sortEndTime = System.currentTimeMillis();
        long sortTime = sortEndTime - sortStartTime;
        log.info("对{}个随机数进行直接插入排序所需的时间为：{}ms", arr.length, sortTime);
    }

    /**
     * 希尔排序
     * @param arr 待排序数据
     */
    public static void shellSort(int[] arr) {
        long sortStartTime = System.currentTimeMillis();
        int length = arr.length / 2;
        while (length >= 1) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length - length; j = j + length) {
                    if (arr[j] > arr[j + length]) {
                        swapElem(arr, j, j + length);
                    }
                }
            }
            //设置新的增量
            length = length / 2;
        }
        long sortEndTime = System.currentTimeMillis();
        long sortTime = sortEndTime - sortStartTime;
        log.info("对{}个随机数进行希尔排序所需的时间为：{}ms", arr.length, sortTime);
    }

    /**
     * 堆排序
     * 将待排序的序列构造成一个大顶堆,此时，整个序列的最大值就是堆顶的根结点。
     * 将其与堆数组的末尾元素交换，此时末尾元素就是最大值，然后将剩余的n-1个序列重新构造成一个堆，这样就得到n-1个元素中的次大值
     * @param arr 待排序数组
     */
    public static void heapSort(int[] arr) {
        long sortStartTime = System.currentTimeMillis();
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i >= 1; i--) {
            swapElem(arr, 0, i);
            heapAdjust(arr, 0, i);
        }
        long sortEndTime = System.currentTimeMillis();
        long sortTime = sortEndTime - sortStartTime;
        log.info("对{}个随机数进行堆排序所需的时间为：{}ms", arr.length, sortTime);
    }

    /**
     * 构建大顶堆
     */
    public static void heapAdjust(int[] arr, int i, int length) {
        //当前元素
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    /**
     * 归并排序
     * 实现思路：将每两个相邻的长度为1的子序列进行归并，得到 n/2（向上取整）个长度为2或1的有序子序列，再将其两两归并
     * @param arr 待排序数组
     */
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    /**
     * 归并
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[arr.length];
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i != mid + 1 && j != high + 1) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i != mid + 1) {
            temp[k++] = arr[i++];
        }
        while (j != high + 1) {
            temp[k++] = arr[j++];
        }
        for (i = low; i <= high; i++) {
            arr[i] = temp[i];
        }

    }

    /**
     * 快速排序
     * @param arr 待排序数组
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (arr == null || start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int k = arr[start];
        while (i < j) {
            while (i < j && arr[j] >= k) j--;
            if (i < j) arr[i++] = arr[j];
            while (i < j && arr[i] <= k) i++;
            if (i < j) arr[j--] = arr[i];
        }
        arr[i] = k;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    /**
     * 交换元素位置
     * @param arr 数组
     * @param i   元素
     * @param j   元素
     */
    public static void swapElem(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
