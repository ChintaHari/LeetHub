class Solution {
    public long repairCars(int[] ranks, int cars) {
        int maxRank = IntStream.of(ranks).max().getAsInt();
        long lo = 0, hi = 1L * maxRank * cars * cars;
        while (lo < hi) {
            long time = lo + (hi - lo) / 2;
            if (canFinish(ranks, cars, time)) {
                hi = time;
            }else {
                lo = time + 1;
            }
        }
        return lo;
    }
    private boolean canFinish(int[] ranks, int cars, long time) {
        long finish = 0;
        for (int r : ranks) {
            finish += (int)Math.floor(Math.sqrt(time / r));
            if (finish >= cars) {
                return true;
            }
        }
        return false;
    }

}