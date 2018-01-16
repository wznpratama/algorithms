// https://leetcode.com/problems/rectangle-area
// 
// Find the total area covered by two rectilinear rectangles in a 2D plane.
// 
// Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
// 
// Rectangle Area
// Assume that the total area is never beyond the maximum possible value of int.
// 
// Credits:
// Special thanks to @mithmatt for adding this problem, creating the above image and all test cases.
class Solution {
    public int computeArea(int A, int B, int C, int D, 
                           int E, int F, int G, int H) {
        int firstArea = (C - A) * (D - B);
        int secondArea = (G - E) * (H - F);
        int overlappedArea = 0;
        int left = Math.max(A, E);
        int bottom = Math.max(B, F);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        if (right > left && top > bottom) {
            overlappedArea = (right - left) * (top - bottom);
        }

        return firstArea + secondArea - overlappedArea;
    }
}
