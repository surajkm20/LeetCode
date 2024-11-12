class MedianFinder {

    PriorityQueue<Integer> firstHalf;
    PriorityQueue<Integer> secondHalf;

    public MedianFinder() {
        firstHalf = new PriorityQueue<>((a,b) -> b-a);
        secondHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(firstHalf.peek() == null || (firstHalf.peek() > num) ){
            firstHalf.add(num);
        }else{
            secondHalf.add(num);
        }

        // make there size like first size +1  >= secondSize;
        while(firstHalf.size() != secondHalf.size()+1 && (firstHalf.size() != secondHalf.size())){
            if(firstHalf.size() > secondHalf.size()+1){
                secondHalf.add(firstHalf.poll());
            }else if(secondHalf.size()+1 > firstHalf.size()){
                firstHalf.add(secondHalf.poll());
            }
        }
    }
    
    public double findMedian() {
        if(firstHalf.size() == secondHalf.size()){
            return ((double)secondHalf.peek() + (double)firstHalf.peek())/2;
        }else{
            return (double)firstHalf.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */