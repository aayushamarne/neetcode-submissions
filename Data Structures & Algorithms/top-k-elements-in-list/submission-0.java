class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {

            pq.add(new int[]{entry.getValue(), entry.getKey()});

            if (pq.size() > k)
                pq.poll();
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++)
            res.add(0);

        
        for (int i = k - 1; i >= 0; i--)
            res.set(i, pq.poll()[1]);

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
