import java.util.Arrays;

public class RadixSort {
    static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxDigit = getMaxDigit(arr);
        return radixSort(arr, maxDigit);
    }

    static int[] radixSort(int[] arr, int maxDigit) {
        // 从个位比较开始数位 (低位)
        for (int i = 0; i < maxDigit; i++) {
            // 每次比较数位时初始化新的10个空桶
            int[][] buckets = new int[10][0]; // 0-9, 10 buckets, each store several values;
            // arr的值进入10个桶
            for (int value : arr) {
                buckets[getDigitValue(value, i)] = arrayAppend(buckets[getDigitValue(value, i)], value);
            }
            // 从桶中把值拿出来放回arr
            int sortedIndex = 0;
            for (int j = 0; j < 10; j++) {
                // System.out.printf("buckets[%d]: %s", j, Arrays.toString(buckets[j]));
                if (buckets[j].length == 0)
                    continue;
                for (int value : buckets[j]) {
                    arr[sortedIndex++] = value;
                }
            }
        }
        return arr;
    }

    // 个位为第0位
    static int getDigitValue(int a, int digit) {
        int digitCount = getDigitCount(a);
        if (digit > digitCount - 1)
            return 0;

        for (int i = 0; i < digit; i++) {
            a /= 10;
        }
        return a % 10;
    }

    static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getDigitCount(maxValue);
    }

    static int getDigitCount(int a) {
        int digitCount = 0;
        while (a > 0) {
            a /= 10;
            digitCount++;
        }
        return digitCount;
    }

    static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            maxValue = value > maxValue ? value : maxValue;
        }
        return maxValue;
    }

    static int[] arrayAppend(int[] arr, int a) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = a;
        return arr;
    }

    public static void main(String[] args) {
        int[] a = { 9, 28, 7, 345, 579, 42, 3, 2, 101 };
        System.out.println(Arrays.toString(sort(a)));
    }

}