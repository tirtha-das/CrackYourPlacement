import java.util.Arrays;

class Solution {
    public int reversePairs(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        return mergeSort(nums, copy, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] copy, int low, int high) {
        if (low >= high) return 0;

        int mid = low + (high - low) / 2;
        int count = mergeSort(nums, copy, low, mid) + mergeSort(nums, copy, mid + 1, high);
        count += merge(nums, copy, low, mid, high);
        return count;
    }

    private int merge(int[] nums, int[] copy, int low, int mid, int high) {
        int count = 0;
        int left = low;
        int right = mid + 1;
        int index = low;

        while (left <= mid && right <= high) {
            if ((long) nums[left] <= 2L * nums[right]) {
                left++;
            } else {
                count += mid - left + 1;
                right++;
            }
        }

        left = low;
        right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                copy[index++] = nums[left++];
            } else {
                copy[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            copy[index++] = nums[left++];
        }

        while (right <= high) {
            copy[index++] = nums[right++];
        }

        System.arraycopy(copy, low, nums, low, high - low + 1);

        return count;
    }
}

