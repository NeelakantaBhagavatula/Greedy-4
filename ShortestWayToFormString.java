// Time Complexity : O(nlogk) where n = length of target string, k = average number of character in source string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1055. Shortest Way to Form String (Medium) - https://leetcode.com/problems/shortest-way-to-form-string/
// Time Complexity : O(m*n) where m = length of source string, n = length of target string
// Space Complexity : O(1)
//class Solution {
//	public int shortestWay(String source, String target) {
//		int sl = source.length(), tl = target.length();
//		int count = 1;
//		int sp = 0, tp = 0;
//
//		HashSet<Character> set = new HashSet<>(); // O(1)
//
//		for (char ch : source.toCharArray()) { // O(m)
//			set.add(ch);
//		}
//
//		while (tp < tl) { // O(n)
//			char sourceChar = source.charAt(sp);
//			char targetChar = target.charAt(tp);
//
//			if (!set.contains(targetChar))
//				return -1;
//
//			if (sourceChar == targetChar) {
//				sp++;
//				tp++;
//
//				if (tp == tl)
//					return count;
//			} else {
//				sp++;
//			}
//
//			if (sp == sl) {
//				sp = 0;
//				count++;
//			}
//		}
//
//		return count;
//	}
//}

// Time Complexity : O(nlogk) where n = length of target string, k = average number of character in source string
// Space Complexity : O(1)
class Solution {
	public int shortestWay(String source, String target) {
		int sl = source.length(), tl = target.length();
		int count = 1;
		int sp = 0, tp = 0;

		HashMap<Character, List<Integer>> map = new HashMap<>(); // O(1)

		for (int i = 0; i < sl; i++) { // O(m)
			char ch = source.charAt(i);

			if (!map.containsKey(ch)) {
				map.put(ch, new ArrayList<>());
			}
			map.get(ch).add(i);
		}

		while (tp < tl) { // O(n)
			char ch = target.charAt(tp);

			if (!map.containsKey(ch))
				return -1;

			List<Integer> list = map.get(ch);
			int k = Collections.binarySearch(list, sp); // k elements, O(logk)

			if (k < 0) { // if element not found
				// sp = 13
				// [0, 1, 6, 9, 17, 19] --> -4-1 = -5
				k = -k - 1; // 5-1 = 4
			}

			if (k >= list.size()) {
				count++;
				sp = list.get(0); // reset the pointer to starting index of the character if k > size of list,
									// meaning subsequence has ended so reset the pointer to the first occurence of
									// the character and increment the pointer to point to next character
			} else {
				sp = list.get(k);
			}
			sp++;
			tp++;
		}

		return count;
	}
}