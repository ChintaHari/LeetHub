class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String detail : details){
            int age = Integer.parseInt("" + detail.charAt(11) + detail.charAt(12));
            if(age > 60)
                count++;
        }
        return count;
    }
}