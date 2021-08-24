class Solution {
    public int maxArea(int[] height) {
        int i = 0 ; 
        int j = height.length -1 ; 
        int area = (j-i) * Math.min(height[j],height[i]);
        while(i < j){
            if(height[i] < height[j]){
                i++;
            }else{
                j-- ;
            }
            int temp = (j-i) * Math.min(height[j],height[i]);
            area = Math.max(temp,area);
        }
        return area;
    }
}