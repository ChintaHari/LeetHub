class Solution {
    public int[] singleNumber(int[] nums) {
        int firstUnique = 0, secondUnique = 0;
        int XOR = 0;
        
        for(int num : nums)
            XOR = XOR ^ num;
        
        int difference_bit = 1;
        
        while((XOR & difference_bit) == 0)
            difference_bit = difference_bit << 1;
        
        for(int num : nums){
            if ((num & difference_bit) == 0)
                firstUnique = firstUnique ^ num;
            else
                secondUnique = secondUnique ^ num;
        }
        
        return new int[]{firstUnique, secondUnique};
    }
}