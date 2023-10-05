class Result {
    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() - 1;
        int halfSize = matrix.size() / 2;
        int sum = 0;
        for(int i = 0; i < halfSize; i++) {
            for(int j = 0; j < halfSize; j++) {
                sum += Collections.max(
                        Arrays.asList(
                            matrix.get(i).get(j), 
                            matrix.get(i).get(n - j), 
                            matrix.get(n - i).get(j), 
                            matrix.get(n - i).get(n - j)
                        )
                    );
            }       
        }
        
        return sum; 
    }
}