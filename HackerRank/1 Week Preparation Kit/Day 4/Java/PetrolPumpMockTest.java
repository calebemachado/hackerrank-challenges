public static int truckTour(List<List<Integer>> petrolpumps) {
    Map<Integer, Integer> maxDistance = new HashMap<>();
    for(int i = 0; i < petrolpumps.size(); i++) {
        int j = i + 1;
        int limit = petrolpumps.size()
        if(j >= petrolpumps.size()) {
            j = 0;
            limit = petrolpumps.size() - 1;
        }

        int amount = petrolpumps.get(i).get(0);
        int distance = petrolpumps.get(i).get(1);
        int difference = amount - distance;

        while(j < limit) {
            amount = petrolpumps.get(j).get(0);
            distance = petrolpumps.get(j).get(1);
            difference += amount - distance;
            if(difference <= 0) break;
            j++;
        }

        maxDistance.set(i, difference);
    }
    
    return Collections.max(maxDistance.entrySet(), Map.Entry.comparingByValue()).getKey();
}