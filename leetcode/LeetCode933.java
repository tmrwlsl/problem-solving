class RecentCounter {
    Queue<Integer> queue = new ArrayDeque<>();

    public int ping(int t) {
        queue.offer(t);
        while(queue.peek() < t - 3000){
            queue.poll();
        }
        return queue.size();
    }
}
