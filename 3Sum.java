#include <vector>
#include <algorithm>
#include <set>
using namespace std;
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        set<vector<int>> uniqueTriplets;
        vector<vector<int>> result;
        for (int i = 0; i < nums.size(); ++i) {
            int left = i + 1;
            int right = nums.size() - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    uniqueTriplets.insert({nums[i], nums[left], nums[right]});
                    ++left;
                    --right;
                } else if (sum > 0) {
                    --right;
                } else {
                    ++left;}}}
        for (const auto& triplet : uniqueTriplets) {
            result.push_back(triplet);
        }
        return result;
    }};