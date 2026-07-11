class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        int[] ans = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        for (int i = 0; i < n; i++) {
            int index = queue.poll();
            ans[index] = deck[i];

            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }

        return ans;
    }
}