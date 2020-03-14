
public class Main {

    public static void main(String[] args) {
        Thread a = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        sleep(300);
                    } catch (Exception e) {
                    }
                    System.out.println(getName() + ": " + i);
                }
            }
        };
        a.setName("Hoa");
        a.start();

        Thread b = new Thread() {
            public void run() {
                System.out.println(a.getName() + " is still alive? " + a.isAlive());
                try {
                    a.join();
                } catch (Exception e) {
                }
                System.out.println(a.getName() + " is still alive? " + a.isAlive());
                for (int i = 0; i < 10; i++) {
                    try {
                        sleep(300);
                    } catch (Exception e) {
                    }
                    System.out.println(getName() + ": " + i);
                }
            }
        };
        b.setName("La");
        b.start();

    }
}
