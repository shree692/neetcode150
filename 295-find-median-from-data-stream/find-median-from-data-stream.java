class MedianFinder {
    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;
    public MedianFinder() {
    large=new PriorityQueue<>();
    small = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        if(large.size()>small.size()) small.offer(large.poll());
    }
    
    public double findMedian() {
        if(small.size()>large.size()) return small.peek();
        return (small.peek()+large.peek())/2.0;
    }
}
