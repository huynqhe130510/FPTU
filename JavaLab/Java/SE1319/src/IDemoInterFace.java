
public interface IDemoInterFace {

    public static final int a = 10;
    int b = 10;

    abstract public void m1();

    void m2();

    static void m3() {
        System.out.println("Ben trong m3");
    }

    default void m4() {
        System.out.println("Ben trong m4");
    }
}

interface IA extends IDemoInterFace {

}

class AA extends Object implements IDemoInterFace {

    @Override
    public void m1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void m2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
