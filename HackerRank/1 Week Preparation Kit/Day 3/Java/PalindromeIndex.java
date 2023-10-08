class Result {

    /**
     * This only works for small length strings
     */
    public static int palindromeIndexWithStringBuilder(String s) {

        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();
        if (reversed.equals(s)) {
            return -1;
        }

        int len = s.length();
        for (int i = 0; i < len; i++) {
            StringBuilder temp = new StringBuilder(s);
            temp.deleteCharAt(i);
            StringBuilder newReversed = new StringBuilder(temp.toString());

            if (newReversed.reverse().toString().contentEquals(temp)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * This should be the simple solution
     */
    public static int palindromeIndexWhile(String s) {
        int left = 0;
        int right = s.length() - 1;

        int indexToRemove = -1;
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                if(isPalindrome(s, left + 1, right)) {
                    indexToRemove = left;
                } else {
                    indexToRemove = right;
                }
                break;
            }
            left++;
            right--;
        }

        return indexToRemove;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    /**
     * Solution using for loop instead of while
     */
    public static int palindromeIndexWithForLoop(String s) {
        int len = s.length();

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                if (isPalindrome(s.substring(i, len - i - 1))) {
                    return len - i - 1;
                } else {
                    return i;
                }
            }
        }

        return -1;
    }

    private static boolean isPalindromeWithForLoop(String s) {
        int len = s.length();

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Another try to 
     */
    public static int isPalindromeFourthWay(String s) {
        //Check maybe edge cases?
        if (s == null || s.isEmpty() || s.isBlank()) {
            return -1;
        }
        if (s.length() == 2 && s.charAt(0) != s.charAt(1)) {
            return 0;
        }
        if (s.length() == 1) {
            return -1;
        }

        //Check if this already a palindrome;
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();
        if (reversed.equals(s)) {
            return -1;
        }

        for (int i = 0; i < s.length(); i++) {
            //"Removing" the char at specific position to check if the result string is a palindrome
            String tempString = s.substring(0, i) + s.substring(i + 1);
            StringBuilder sBuilder = new StringBuilder(tempString);
            if(tempString.contentEquals(sBuilder.reverse())) {
                return i;
            }
        }

        return -1;
    }


}