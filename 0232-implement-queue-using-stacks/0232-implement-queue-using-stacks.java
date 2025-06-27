class MyQueue {

    private final Stack<Integer> read;
    private final Stack<Integer> write;

    public MyQueue() {
        this.read = new Stack<>();
        this.write = new Stack<>();
    }
    
    public void push(int x) {
        read.push(x);
    }
    
    public int pop() {
        peek();
        return write.pop();
    }
    
    public int peek() {
        
        if (write.isEmpty()) {
            while (!read.isEmpty()) {
                write.push(read.pop());
            }
        }

        return write.peek();
    }
    
    public boolean empty() {
        return read.isEmpty() && write.isEmpty();
    }
}