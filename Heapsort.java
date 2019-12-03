/**
 * 堆排序 
 * 需要分两步：1.建立堆 2.把头元素放到末尾，然后调整剩下的0-i子数组 
 * 调整个建堆都用到一个关键的函数，ajustDown，从上到下调整一颗树,即调整以该节点为根节点的整个“子树”，通过递归实现
 * 
 * 复杂度分析：建堆和调整时间复杂度都是nlogn，所以总的复杂度也是nlogn
 * 其中，n消耗在遍历所有节点上，logn消耗在递归调整子树上。
 */
public class Heapsort {

    public int[] heapSort(int[] array) {
        // 建堆
        buildMaxHeap(array);
        // 排序
        sort(array);
        return array;
    }

    private void buildMaxHeap(int[] array) {
        int startIndex = array.length / 2 + 1;
        for (int i = startIndex; i >= 0; i--) {
            ajustDown(array, i, array.length);
        }
    }

    private void sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            ajustDown(array, 0, i);
        }
    }

    /**
     * 堆排序的关键，局部调整，如果需要调整，需要递归调整子树
     * 
     * @param array 整个树对应的数组
     * @param index 要调整的位置index
     * @param size  最多调整到哪个位置之前,用来调整子数组,也就是子数组的长度-1
     */
    private void ajustDown(int[] array, int index, int size) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        int maxIndex = index;

        if (leftChild < size && array[leftChild] > array[index]) {
            maxIndex = leftChild;
        }
        if (rightChild < size && array[rightChild] > array[maxIndex]) {
            maxIndex = rightChild;
        }

        if (maxIndex != index) {
            swap(array, maxIndex, index);
            ajustDown(array, maxIndex, size);
        }

    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}