# 学习笔记

## 小结

- 位运算：大学时位运算作为比较基础的内容讲了很多，根据老师举例的内容又复习了一遍
    - 可以用位运算处理时，往往比常规数值处理更快
    - N皇后问题，展示了位运算在用作存储时的优势，更节省空间
- Bloom Filter：不能确定数据一定在集合内，可以确定数据一定不在集合内
    - 主要应用：分布式系统、垃圾邮件过滤、爬虫重复URL过滤
    - 优点：查询速度快、存储空间少；缺陷：一个模糊的查询，用于判断数据不在集合内
- LRU cache：最早用于CPU缓存替换，现在常用于推荐系统

- 初级排序：
    - 选择排序：每次找到最小的值，然后放到待排序数组的起始位置
    - 插入排序：从前到后逐步构建有序序列；对于未排序的数据，在已排序序列中从后向前扫描，找到相应位置并插入
    - 冒牌排序：嵌套循环，每次查看相邻的元素如果逆序，则交换
- 高级排序：
    - 快速排序：数组取标杆 pivot，将小元素放右侧，然后依次对右边和右边的子数组继续快排
    - 归并排序：使用分治思想，将序列对半分成两个子序列，然后递归的调用归并排序，最终将排序好的子序列合并成一个序列
    - 堆排序：利用堆的特性（堆顶元素最大或最小），依次将堆顶元素取出即有序序列

## 初级排序

``` Java
// 选择排序
public void selectionSort(int[] array) {
    int minIndex;
    int temp;

    for (int i = 0; i < array.length - 1; i++) {
        minIndex = i;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
    }
}
```

``` Java
// 插入排序
public void insertionSort(int[] array) {
    int preIndex;
    int current;

    for (int i = 1; i < array.length; i++) {
        preIndex = i - 1;
        current = array[i];
        while (preIndex >= 0 && array[preIndex] > current) {
            arrary[preIndex + 1] = array[preIndex];
            preIndex--;
        }
        arrary[preIndex + 1] = current；
    }
}
```

``` Java
// 冒泡排序
public void bubbleSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
        for (int j = 0; j < array.length - 1 - i; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j + 1];
                array[j + 1] = array[j];
                array[j] = temp;
            }
        }
    } 
}
```