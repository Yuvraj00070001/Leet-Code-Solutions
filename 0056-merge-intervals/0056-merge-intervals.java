class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort by starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // Overlapping
            if (currentStart <= end) {
                end = Math.max(end, currentEnd);
            }

            // Not overlapping
            else {
                result.add(new int[]{start, end});

                start = currentStart;
                end = currentEnd;
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}