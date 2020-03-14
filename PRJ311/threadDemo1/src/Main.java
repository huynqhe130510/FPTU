
public class Main {
    public static void main(String[] args) {
        ThreadA a; ThreadB b;
        a = new ThreadA();
        b = new ThreadB();
        a.setName("Hoa");
        b.setName("La");
        a.start();
        b.start();
        System.err.println();
    }    
}
