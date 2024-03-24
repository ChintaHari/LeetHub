class Solution {
    int[] digits;

    public int nextGreaterElement(int n) {
        digits = Integer.toString(n).chars().map(c -> c - '0').toArray();

        int index = digits.length - 2;
        while (index >= 0 && digits[index] >= digits[index + 1]) {
            index--;
        }

        if (index < 0) {
            return -1;
        }

        int j = digits.length - 1;
        while (digits[index] >= digits[j]) {
            j--;
        }

        swap(digits, index, j);

        reverse(digits, index + 1, digits.length - 1);

        long result = 0;
        for (int digit : digits) {
            result = result * 10 + digit;
        }
        
        if (result > Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int) result;
        }
    }

    private void swap(int[] digits, int i, int j) {
        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    private void reverse(int[] digits, int start, int end) {
        while (start < end) {
            swap(digits, start, end);
            start++;
            end--;
        }
    }
}
