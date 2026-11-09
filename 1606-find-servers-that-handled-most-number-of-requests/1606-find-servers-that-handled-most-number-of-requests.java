import java.util.*;
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] count = new int[k];
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] server = busy.poll();
                available.add(server[1]);
            }
            if (available.isEmpty()) {
                continue;
            }
            int server = i % k;
            Integer selected = available.ceiling(server);
            if (selected == null) {
                selected = available.first();
            }
            available.remove(selected);
            count[selected]++;
            busy.add(new int[]{time + load[i], selected});
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, count[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }
        return ans;
    }
}
