
class A {

    static int x;
    int y;

    {
        System.out.println("Ben trong Block code1 A");
    }

    public A() {
        System.out.println("Ben trong CS cua A");
    }

    {
        System.out.println("Ben trong Block code2 A");
    }

    static {
        System.out.println("Ben trong Static BC 1 cua A");
    }

    static {
        System.out.println("Ben trong Static BC 2 cua A");
    }
}

public class DemoStatic {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("------------");
        A b = new A();
    }
}
//        a.x = 10;
//        A.x = 30;
//        System.out.println(a.x+" "+b.x+" "+A.x);
//        a.x = 10;
//        System.out.println(a.x+" "+b.x+" "+A.x);
//        b.x = 20;
//        System.out.println(a.x+" "+b.x+" "+A.x);
//        A c = new A();
//        System.out.println(c.x);

