
public interface IPerson {

    void Say();
}

class SinhVien implements IPerson {

    public void Say() {
        System.out.println("Toi la mot sinh vien");
    }
}

class GiaoVien implements IPerson {

    public void Say() {
        System.out.println("Toi la mot giao vien");
    }
}

class CongDan implements IPerson {

    public void Say() {
        System.out.println("Toi la mot cong dan");
    }
}

class UsingSay {

    public static void main(String[] args) {
        IPerson ps;
        ps = new SinhVien();
        ps.Say();
        ps = new GiaoVien();
        ps.Say();
        ps = new CongDan();
        ps.Say();
    }

}
