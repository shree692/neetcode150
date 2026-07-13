class LFUCache {

    class Node{
        int key,value,freq;
        Node prev,next;
        Node(int key,int value){
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }
    class DLL{
        Node head,tail;
        int size;
        DLL(){
            head = new Node(0,0);
            tail = new Node(0,0);

            head.next = tail;
            tail.prev = head;
            size = 0;
        }
    
    void add(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }
    void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
    Node removeLast(){
        if(size == 0){
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }
    }
    int capacity,minFreq;
    HashMap<Integer,Node> nodeMap;
    HashMap<Integer,DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
    }
    private void updateFrequency(Node node){
        int freq = node.freq;
        DLL list = freqMap.get(freq);
        list.remove(node);
        if(freq == minFreq && list.size == 0){
            minFreq++;
     
        }
        node.freq++;
        freqMap.putIfAbsent(node.freq, new DLL());
        freqMap.get(node.freq).add(node);
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }
        if(nodeMap.size()==capacity){
            DLL list = freqMap.get(minFreq);
            Node removed = list.removeLast();
            nodeMap.remove(removed.key);

        }
        Node newNode = new Node(key,value);
        minFreq = 1;
        freqMap.putIfAbsent(1,new DLL());
        freqMap.get(1).add(newNode);
        nodeMap.put(key,newNode);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */