
import java.util.Scanner;

public class FUStudent {

    String Id;
    String Fullname;

    public FUStudent() {
    }

    public FUStudent(String Id, String Fullname) {
        this.Id = Id;
        this.Fullname = Fullname;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    String getEmail() {
        String []s;
        s = Fullname.split("\\s+");
        String a = s[s.length-1];    
        for (int i = 0; i < s.length-1; i++) {
            a = a + s[i].charAt(0);
        }
        a = a + Id + "@fpt.edu.vn";
        return a;
    }
    

    @Override
    public String toString() {
        return Fullname + "<-->" + Id;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        String id = sc.nextLine();
        System.out.print("Enter fullname: ");
        String fullname = sc.nextLine();
        System.out.println("");
        FUStudent f = new FUStudent(id, fullname);
        System.out.println(f.getFullname() + "-" + f.getId());
        System.out.println("");
        System.out.println(f.getEmail());
    }

}
