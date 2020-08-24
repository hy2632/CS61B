import java.util.Arrays;

/**
 * https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247484184&idx=1&sn=62965b401aa42107b3c17d1d8ea17454&chksm=fa0e6c99cd79e58f298e9026f677f912bd8c8e55edb48fc509b2b5834f05e529a9b47d59d202&scene=21#wechat_redirect
 */
public class Sort {

    // 1. 冒泡排序 O(n2)
    // public static int[] BubbleSort(int[] sourceArray) {
    // int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
    // for (int i = 0; i <= sourceArray.length - 1; i++) {
    // boolean flag = true;
    // for (int j = 0; j <= sourceArray.length - i - 2; j++) {
    // if (arr[j + 1] < arr[j]) {
    // flag = false;
    // int temp = arr[j];
    // arr[j] = arr[j + 1];
    // arr[j + 1] = temp;
    // }
    // }
    // if (flag == true)
    // break;
    // }
    // return arr;
    // }
    public static int[] BubbleSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int temp;
        boolean flag;

        for (int i = 0; i < arr.length; i++) {
            flag = true; // 默认存在逆序对，会发生交换
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    flag = false;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag)
                break; // 如果全部顺序就提前结束外循环
        }
        return arr;
    }

    // 2. 选择排序 O(n2)
    // 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
    // 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
    // 重复第二步，直到所有元素均排序完毕。
    public static int[] SelectionSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 0; i < arr.length; i++) {
            int argmin = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[argmin]) {
                    argmin = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[argmin];
            arr[argmin] = temp;
        }
        return arr;
    }

    // 3. 插入排序 O(n2)
    // 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
    // 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）

    public static int[] InsertSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
        return arr;
    }

    // 4. 希尔排序
    // 选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
    // 按增量序列个数 k，对序列进行 k 趟排序；
    // 每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。仅增量因子为 1
    // 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
    // https://www.zhihu.com/search?type=content&q=%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F

    public static int[] ShellSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int gap = arr.length >> 1; gap >= 1; gap >>= 1) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                } // j到达插入位置
                arr[j] = temp;
            }
        }
        return arr;
    }

    // 5. 归并排序
    // 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
    // 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
    // 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
    // 重复步骤 3 直到某一指针达到序列尾；
    // 将另一序列剩下的所有元素直接复制到合并序列尾。
    public static int[] MergeSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2)
            return arr;

        int middle = arr.length >> 1;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(MergeSort(left), MergeSort(right));
    }

    static int[] merge(int[] left, int[] right) {// 两个有序序列
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i] = left[0];
                i++;
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i] = right[0];
                i++;
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i] = left[0];
            i++;
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i] = right[0];
            i++;
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

    // // 6. 快速排序
    public static int[] QuickSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return quicksort(arr, 0, arr.length - 1);
    }

    static int[] quicksort(int[] arr, int left, int right) {
        if (left < right) { // 约束，防止partitionIndex到0
            int partitionIndex = partition(arr, left, right); // partition实际执行排序操作
            quicksort(arr, left, partitionIndex - 1); // 不含中间
            quicksort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    // partition方法对arr进行修改
    static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1; // 从左端开始
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index); // pivot右边一位作为index不断地和后续比arr[pivot]小的元素交换位置，
                index++; // index位向右挪
                // 最终pivot往右直到index-1都是小于基准的，再把pivot放到中间位置index-1
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // 7.堆排序, 一个父节点和两个子节点
    static void heapify(int[] arr, int i, int len){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest] ){ //注意次序，先判断index
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]){
            largest = right;
        }

        if (i < largest){
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    static void buildMaxHeap(int[] arr, int len){
        for (int i = len >> 1; i >= 0; i--){ //i >= 0
            heapify(arr, i, len);
        }
    }

    static int[] heapSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;

        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--){
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }



    // 8. 计数排序
    static int[] CountingSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return (countingsort(arr, getMaxValue(arr)));
    }
    
    static int[] countingsort(int[] arr, int maxValue){
        int bucketlen = maxValue + 1;
        int[] bucketarr = new int[bucketlen];
        for (int value: arr){
            bucketarr[value] ++;
        }
        int sortedIndex = 0;
        for (int i = 0; i < bucketlen; i++){ // i < bucketlen
            while (bucketarr[i]>0){
                arr[sortedIndex++] = i;
                bucketarr[i]--;
            }
        }
        return arr;
    }
    
    static int getMaxValue(int[] arr){
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++){
            maxValue = arr[i] > maxValue ? arr[i] : maxValue;
        }
        return maxValue;
    }

    // 9. 桶排序
    static int[] BucketSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return (bucketSort(arr, 5));
    }

    static int[] bucketSort(int[] arr, int bucketSize){
        if (arr.length == 0)
            return arr;

        int minValue = arr[0];
        int maxValue = arr[0];

        for(int value: arr){
            minValue = value < minValue ? value : minValue;
            maxValue = maxValue < value ? value : maxValue;
        }

        int bucketCount = (int) Math.floor((maxValue-minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        for (int i = 0; i < arr.length; i++){
            int index =(int) Math.floor((arr[i]-minValue)/bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for(int[] bucket: buckets){
            if(bucket.length <= 0){
                continue;
            }

            bucket = InsertSort(bucket);
            for(int value: bucket){
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }
    // array扩容
    static int[] arrAppend(int[] arr, int value){
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length-1] = value;
        return arr;
    }

    
    static int[] InsertSort1(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for(int i = 1; i < arr.length; i++){
            int j = i;
            int temp = arr[j];
            while(j >= 1 && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] src_arr = { 1, 5, 8, 3, 5, 1, 2, 5, 3, 4, 3, 2 };
        System.out.println(Arrays.toString(InsertSort1(src_arr)));
    }
}



