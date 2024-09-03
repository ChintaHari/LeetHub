class Solution {
    int sum = 0;
    String stringToNumber = "";
    public int getLucky(String s, int k) {
        for(char ch : s.toCharArray())
            stringToNumber = stringToNumber + String.valueOf((int)ch - 96);
            
        for(int i=0; i<k; i++){
            int digitSum = 0;
            for (char digit : stringToNumber.toCharArray()) 
                digitSum = digitSum + (digit - '0');
            stringToNumber = Integer.toString(digitSum);
        }
         
        return Integer.parseInt(stringToNumber);
    }
}