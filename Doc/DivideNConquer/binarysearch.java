public class binarysearch {
    public static void main(String[] args){
        int[] a = {1, 2, 2, 2, 3};
        System.out.println(right_bound(a, 2));
    }



    // 默认数组有序
    static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right){
            int mid = (left + right) >> 1;
            if (target == arr[mid]){
                return mid;
            } else if (arr[mid] < target){
                left = mid + 1;
            } else if (arr[mid] > target){
                right = mid - 1; 
            }
        }
        return -1;
    }

    // 寻找左侧边界
    static int left_bound(int[] arr, int target){
        int n = arr.length;
        int left, right;
        left = 0;
        right = n;

        while(left < right){
            int mid = (left + right) >> 1;
            if (arr[mid] == target){
                right = mid;
            } else if (arr[mid] > target){
                right = mid;
            } else if (arr[mid] < target){
                left = mid + 1;
            }
        }
        if (left == arr.length) return -1;
        return (arr[left] == target) ? left : -1;
    }

    // 寻找右侧边界
    static int right_bound(int[]arr, int target){
        int n = arr.length;
        int left, right;
        left = 0;
        right = n;

        while(left < right){
            int mid = (left + right) >> 1;
            if (arr[mid] == target){
                left = mid + 1;
            } else if (arr[mid] > target){
                right = mid;
            } else if (arr[mid] < target){
                left = mid + 1;
            }
        }
        if (left == 0) return -1;
        return (arr[left - 1] == target) ? left - 1 : -1;
    }


}
