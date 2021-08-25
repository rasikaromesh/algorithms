package leet_code.medium;

import java.util.*;

public class _3Sum {

    public List<Integer> createTriplet(int x, int y, int z) {
        List<Integer> resultTriplet = new ArrayList<>();
        resultTriplet.add(x);
        resultTriplet.add(y);
        resultTriplet.add(z);
        Collections.sort(resultTriplet);
        return resultTriplet;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length < 2) {
            return resultList;
        }
        for (int x = 0; x < nums.length - 2; x++) {
            int low = x + 1;
            int high = nums.length - 1;
            if (x == 0 || (x > 0 && nums[x] != nums[x-1])){
                while (low < high){
                    int balance = -(nums[low] + nums[high]);
                    if (nums[x] == balance){
                        resultList.add(Arrays.asList(nums[x], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    } else if (nums[x] > balance){
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return new ArrayList<>(resultList);
    }
}
