import java.util.*;

public class ThreeSum_v2 {
    public static void main(String[] args) {
        int[] a = new int[] { -4, -4, -4, -2, 5, 7, 3, -3, -3 };

        // int[][] solution_set = new int[][] {a};
        // solution_set = append(solution_set, new int[] {1,2,3,4});

        List<List<Integer>> solution_set = threeSum(a);
        System.out.println(Arrays.toString(solution_set.toArray()));
    }

    /**
     * 需要去重，sort()可以保证过程不重复， 不能一开始去重，如(-2,1,1) 需要在结束后去重
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        if (nums.length < 3)
            return new ArrayList<>();
        if (nums[0] > 0 || nums[nums.length - 1] < 0)
            return new ArrayList<>();
        List<List<Integer>> solution_set = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            // if (i >= 1 && nums[i] == nums[i - 1])
            // continue;

            while (start < end) {
                // // start不管，两头i和end防止重复
                // if (end < nums.length && nums[end] == nums[end-1]){
                // end -- ;
                // continue;
                // }

                if (nums[i] + nums[start] + nums[end] == 0) {
                    solution_set.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[start], nums[end])));
                    // 居然把这两行写漏了。。。
                    start++;
                    end--;

                } else if (nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                } else
                    start++;
            }
        }

        // 没有解决好跳过的问题如[0, 0, 0]，尝试用set
        solution_set = removeDuplicates(solution_set);

        return solution_set;
    }

    private static List<List<Integer>> removeDuplicates(List<List<Integer>> input){
        HashSet<List<Integer>> hset = new HashSet<List<Integer>> ();
        // Traverse and add elements;
        for (List<Integer> i : input){
            hset.add(i);
        }
        return new ArrayList<>(hset);
    }

}