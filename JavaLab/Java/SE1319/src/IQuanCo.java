
public interface IQuanCo {

    void DiChuyen();
}

class QuanTuong implements IQuanCo {

    public void DiChuyen() {
        System.out.println("Di thang, ngang cheo 1 o");
    }
}

class QuanMa implements IQuanCo {

    public void DiChuyen() {
        System.out.println("Di thang di ngang va khong han che so o");
    }
}

class QuanTot implements IQuanCo {

    public void DiChuyen() {
        System.out.println("Di thang an cheo ....");
    }
}

class UsingQuanCo {

    public static void main(String[] args) {
        IQuanCo qc;
        qc = new QuanTuong();
        qc.DiChuyen();
        qc = new QuanMa();
        qc.DiChuyen();

        qc = new IQuanCo() {
            @Override
            public void DiChuyen() {
                System.out.println("Day la anymous class");
            }
        };
        qc.DiChuyen();

        QuanMa qm = new QuanMa();
        qm.DiChuyen();
        (new QuanMa()).DiChuyen();
        (new IQuanCo() {
            public void DiChuyen() {
                System.out.println("Day la nynous class + object");
            }
        }).DiChuyen();
        IQuanCo q1 = () -> {System.out.println("Ben trong lambda expression");};
        q1.DiChuyen();
    }
}
