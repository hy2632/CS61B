public class QuanPaiLie {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5};
        fullSort(arr, 0, arr.length - 1);
    }

    static void fullSort(int[] arr, int start, int end) {
        if (start == end){
            for (int i : arr){
                System.out.print(i);
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= end; i++){
            swap(arr, i, start);
            fullSort(arr, start + 1, end);
            swap(arr, i, start);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
