public static String gridChallenge(List<String> grid) {
        //Each item of list represents a row;
        //For each item, the index should represent the position related to columns;

        //1 - Split each item (rows) into characteres and sort them;
        List<String> sortedGrid = new ArrayList<>();
        for (String row : grid) {
            List<String> letters = Arrays.asList(row.split(""));
            Collections.sort(letters);
            StringBuilder sBuilder = new StringBuilder("");
            letters.forEach(l -> {
                sBuilder.append(l);
            });
            sortedGrid.add(sBuilder.toString());
        }

        //2 - Write a function to determine if the columns are in the ascending order;
        for(int i = 0; i < sortedGrid.size() - 1; i++){
            for(int j = 0; j < sortedGrid.get(i).length(); j++) {
                if(sortedGrid.get(i).charAt(j) > sortedGrid.get(i + 1).charAt(j)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }