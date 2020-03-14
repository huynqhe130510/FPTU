
public class Teacher {

    String name;
    double salary;

    public Teacher() {
    }

    public Teacher(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void getName() {
        char[] name2 = this.name.toCharArray();
        for (int i = name2.length - 1; i >= 0; i--) {
            System.out.print(""+this.name.charAt(i));
        }
    }
    

    double getSalary() {
        double a = 0;
//        return salary = salary * 90 /100 ;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(0) == 'v' || name.charAt(0) == 'V') {
                a = salary * 5 / 100;
                a = salary - a;
            } 
            else {
                a = salary * 15 / 100;
                a = salary - a;
            }
        }
        return a;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + "-" + salary;
    }
}
//  getName(): return reverse all character in name
//  return 2,3,4,5,... ky tu dau tien hoac cuoi cung abc1234--> abc1( dung ham substring)
//  return all character at even position abc123--> ac2
//  getSalary(): return 90% of salary
//  if name start with "v" or "V" then tax of salary = 5% else tax = 15% in othewise
    // toString(): name - salary 
