class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);
        int boats = 0;
        
        while(left <= right){
            if(people[left] + people[right] <= limit)
                left++;
            boats++;
            right--;
        }
        return boats;
    }
}