package leet_code.easy;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valIndexMap = new HashMap<>();
        boolean evenFlag = false;
        int similarNumFirstIndex = -1;

        if (target % 2 == 0) {
            evenFlag = true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (valIndexMap.get(nums[i]) == null) {
                valIndexMap.put(nums[i], i);
                if (evenFlag && (target/2) == nums[i]) {
                    similarNumFirstIndex = i;
                    continue;
                }
            }
            int k = target - nums[i];
            if (similarNumFirstIndex != -1 && nums[i] == k){
                return new int[]{similarNumFirstIndex, i};
            }
            if (nums[i] != k && valIndexMap.get(k) != null) {
                return new int[]{valIndexMap.get(k), valIndexMap.get(nums[i])};
            }
        }
        return null;
    }
}
