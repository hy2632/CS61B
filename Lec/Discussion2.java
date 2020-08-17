import java.util.Arrays;

public class Discussion2 {

    /**
     * 给定一个序列， 一个idx k， 从k开始找序列最小值位置
     */
    public static int mystery1(int[] inputArray, int k) {
        int x = inputArray[k];
        int answer = k;
        int index = k + 1;
        while (index < inputArray.length) {
            if (inputArray[index] < x) {
                x = inputArray[index];
                answer = index;
            }
            index = index + 1;
        }
        return answer;
    }

    // 利用找argmin的方法排序
    public static void mystery2(int[] inputArray) {
        int index = 0;
        while (index < inputArray.length) {
            int targetIndex = mystery1(inputArray, index); //index起的argmin
            int temp = inputArray[targetIndex]; //index起的min
            System.out.printf("index:{%d}, targetIndex:{%d}, temp:{%d}\n", index, targetIndex, temp);
            inputArray[targetIndex] = inputArray[index]; //index的值和index起的min交换
            inputArray[index] = temp;
            System.out.println(Arrays.toString(inputArray)+"\n");
            index = index + 1;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] { 3, 0, 4, 6, 3 };
        System.out.println(mystery1(a, 2));
        mystery2(a);
    }

}