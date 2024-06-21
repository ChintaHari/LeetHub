class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfiedPeople = 0, satisfiedPeopleWithTechnique = 0;
        int left = 0, right = 0, max = Integer.MIN_VALUE;
        
        for(right = 0; right < customers.length; right++){
            if(grumpy[right] == 1)
                satisfiedPeopleWithTechnique = satisfiedPeopleWithTechnique + customers[right];
            else
                satisfiedPeople = satisfiedPeople + customers[right];
            
            while(right - left + 1 > minutes){
                if(grumpy[left] == 1)
                    satisfiedPeopleWithTechnique = satisfiedPeopleWithTechnique - customers[left];
                   
                 left++;
            }
            
            max = Math.max(satisfiedPeopleWithTechnique, max);
        }
        
        return satisfiedPeople + max;
    }
}