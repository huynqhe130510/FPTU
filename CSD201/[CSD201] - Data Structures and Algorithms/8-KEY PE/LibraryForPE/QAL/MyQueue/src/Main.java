
public class Main {
    public static void main(String[] args) {
        
        MyQueue m = new MyQueue();
        m.enqueue(20);
        m.enqueue(8);
        m.enqueue(12);
        while(!m.isEmpty()){
            System.out.println(m.dequeue());
        }
    }
}
