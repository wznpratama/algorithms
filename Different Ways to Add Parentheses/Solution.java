// https://leetcode.com/problems/different-ways-to-add-parentheses/
// 
// Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
// 
// 
// Example 1
// Input: "2-1-1".
// 
// ((2-1)-1) = 0
// (2-(1-1)) = 2
// Output: [0, 2]
// 
// 
// Example 2
// Input: "2*3-4*5"
// 
// (2*(3-(4*5))) = -34
// ((2*3)-(4*5)) = -14
// ((2*(3-4))*5) = -10
// (2*((3-4)*5)) = -10
// (((2*3)-4)*5) = 10
// Output: [-34, -14, -10, -10, 10]
// 
// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.
class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (map.get(input) != null) return map.get(input);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                for (int a : diffWaysToCompute(input.substring(0, i))) {
                    for (int b : diffWaysToCompute(input.substring(i + 1))) {
                        result.add(c == '*' ? a * b : (c == '+' ? a + b : a - b));
                    }
                }
            }
        }
        if (result.isEmpty()) result.add(Integer.valueOf(input));
        map.put(input, result);
        return result;
    }
}
