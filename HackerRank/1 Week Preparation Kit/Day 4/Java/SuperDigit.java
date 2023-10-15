class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        boolean allDigitsSame = true;
        for(int i = n.length() - 1; i > 1; i--) {
            if(n.charAt(0) != n.charAt(i)) {
              allDigitsSame = false;
              break;
            }
        }
        
        char nine = '9';
        if(allDigitsSame && n.charAt(0) == nine) return 9;
        
        Integer superD = isSuperDigit(n) * k;
        
        return isSuperDigit(superD.toString());    
    }

    public static Integer isSuperDigit(String n) {
        try {
            if(n.length() == 1) {
                return Integer.valueOf(n);
            }
            
            List<String> intString = Arrays.asList(n.split(""));
            Integer sum = 0;
            
            for(int i = 0; i < intString.size(); i++){
                sum += Integer.valueOf(intString.get(i));
            }
            
            return isSuperDigit(sum.toString());
            
        } catch(Exception e) {
            return 0;
        }
        
    }
}