class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        char[] convertedX = String.valueOf(x).toCharArray();
        StringBuilder reversed = new StringBuilder();
        for(int i = convertedX.length - 1; i >= 0 ; i--){
            reversed.append(convertedX[i]);
        }

        return reversed.toString().equals(String.valueOf(x));
    }
}