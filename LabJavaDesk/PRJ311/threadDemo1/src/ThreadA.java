
public class ThreadA extends Thread {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " " + i);
            try {
                sleep(500);
            }
            catch(InterruptedException e){
                
            }
        }
    }
}
