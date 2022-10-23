// Time Complexity : O(n) where n = length of tops or bottom array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1007. Minimum Domino Rotations For Equal Row (Medium) - https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
// Time Complexity : O(n) where n = length of tops or bottom array
// Space Complexity : O(1)
//class Solution {
//	public int minDominoRotations(int[] tops, int[] bottoms) {
//		int n = tops.length;
//
//		HashMap<Integer, Integer> map = new HashMap<>(); // O(1)
//
//		for (int i = 0; i < n; i++) { // O(n)
//			if (tops[i] != bottoms[i]) {
//				map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1);
//			}
//			map.put(tops[i], map.getOrDefault(tops[i], 0) + 1);
//		}
//
//		int max = 0, valueToBeRotated = 0;
//
//		for (int key : map.keySet()) {
//			int count = map.get(key);
//
//			if (max < count) {
//				max = count;
//				valueToBeRotated = key;
//			}
//		}
//
//		if (max < n)
//			return -1;
//
//		int topRotation = 0, bottomRotation = 0;
//
//		for (int i = 0; i < n; i++) { // O(n)
//			if (tops[i] != valueToBeRotated)
//				topRotation++;
//			if (bottoms[i] != valueToBeRotated)
//				bottomRotation++;
//		}
//
//		return Math.min(topRotation, bottomRotation);
//	}
//}

// Time Complexity : O(n) where n = length of tops or bottom array
// Space Complexity : O(1)
class Solution {
	public int minDominoRotations(int[] tops, int[] bottoms) {
		int result = check(tops, bottoms, tops[0]);

		if (result != -1)
			return result;

		return check(tops, bottoms, bottoms[0]);
	}

	private int check(int[] tops, int[] bottoms, int candidate) {
		int topRotation = 0, bottomRotation = 0;

		for (int i = 0; i < tops.length; i++) { // O(n)
			if (tops[i] != candidate && bottoms[i] != candidate)
				return -1;
			if (tops[i] != candidate)
				topRotation++;
			if (bottoms[i] != candidate)
				bottomRotation++;
		}

		return Math.min(topRotation, bottomRotation);
	}
}