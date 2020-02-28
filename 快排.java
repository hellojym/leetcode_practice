
/**
 * 快排
 * 递归分治，核心思想就是每次找数组中一个值，把所有比它小的移到左边来，
 * 大的移到右边，难点就是怎么个挪法。
 * 
 */

class QuickSort {

    public void quickSort(int[] array) {
        sort(0, array.length - 1, array);
    }

    public void sort(int l, int r, int[] array) {

        if (l < r) {
            //用i 和 j两个游标分别记录小区间和大区间的临界点。
            //也就是说，i左边的都比X小，右边的都比X大。
            // 当i==j的时候，所有的元素就被分成了大小两个区间了。
            int i = l, j = r;
            int x = array[l];
            while (i < j) {
                while (i < j && array[j] >= x) {
                    j--;
                }
                if (i < j) {
                    array[i++] = array[j];
                }
                while (i < j && array[i] < x) {
                    i++;
                }
                if (i < j) {
                    array[j--] = array[i];
                }
            }
            array[i] = x;
            sort(l, i - 1, array);
            sort(i + 1, r, array);
        }

    }
}