class RecentCounter {
    Queue<Integer> qu;

    public RecentCounter() {
        qu = new LinkedList<>();

        
    }
    
    public int ping(int t) {
        qu.add(t);
        while(!qu.isEmpty() && qu.peek() < t-3000)
        qu.poll();
        return qu.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */