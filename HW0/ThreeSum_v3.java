import java.util.*;

public class ThreeSum_v3 {
    public static void main(String[] args) {
        int[] a = new int[] { 0, 0, 0, 0 };
        List<List<Integer>> solution_set = threeSum(a);
        System.out.println(Arrays.toString(solution_set.toArray()));
    }

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

            if (i >= 1 && nums[i] == nums[i - 1])
                continue;

            while (start < end) {
                // start不管，两头i和end防止重复
                if (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }

                if (nums[i] + nums[start] + nums[end] == 0) {
                    solution_set.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[start], nums[end])));
                    start++;
                    end--;

                } else if (nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                } else
                    start++;
            }
        }

        return solution_set;
    }

}