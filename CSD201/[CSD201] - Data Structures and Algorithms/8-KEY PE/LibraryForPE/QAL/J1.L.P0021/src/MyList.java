
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MyList {

    ArrayList<Student> st = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public boolean equalStudent(Student s1, Student s2) {
        return (s1.getId().trim().equalsIgnoreCase(s2.getId().trim()) && s1.getName().trim().equalsIgnoreCase(s2.getName())
                && s1.getCourse().trim().equalsIgnoreCase(s2.getCourse().trim()));
    }

    public boolean checkID(String id) {
        boolean check = false;
        if (id.equals("")) {
            check = false;
            System.out.println("Your input is empty");
        } else {
            for (int i = 0; i < id.length(); i++) {
                if (id.charAt(i) == ' ') {
                    check = false;
                    System.out.println("ID without spaces");
                    break;
                } else {
                    check = true;
                }
            }
        }
        return check;
    }

    public boolean checkName(String name) {
        boolean check = true;
        if (name.equals("")) {
            check = false;
            System.out.println("Your input is empty");
        } else {
            int count = 0;
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                if (Character.isDigit(c)) {
                    check = false;
                    System.out.println("Name has only characters");
                    break;
                } else if (c == ' ') {
                    count++;
                }
            }
            if (count == name.length()) {
                check = false;
                System.out.println("Your input has only spaces");
            }
        }
        return check;
    }

    public boolean checkIdName(String id, String name) {
        boolean check = true;
        for (Student s : st) {
            if (s.getId().equalsIgnoreCase(id) && !s.getName().equalsIgnoreCase(name)) {
                check = false;
                System.out.println("There is a student has ID: " + s.getId() + " and Name: " + s.getName());
                break;
            }
        }
        return check;
    }

    public boolean checkSemester(String semester) {
        boolean check = false;
        if (semester.equals("")) {
            check = false;
            System.out.println("Your input is empty");
        } else {
            for (int i = 0; i < semester.length(); i++) {
                if (Character.isDigit(semester.charAt(i))) {
                    check = true;
                } else {
                    check = false;
                    System.out.println("Semester has only number");
                    break;
                }
            }
        }
        return check;
    }

    public boolean checkCourse(String course) {
        boolean check = false;
        if (course.equals("")) {
            check = false;
            System.out.println("Your input is empty");
        } else if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase(".Net") || course.equalsIgnoreCase("C/C++")) {
            check = true;
        } else {
            check = false;
            System.out.println("(There are only three courses: Java, .Net, C/C++");
        }
        return check;
    }

    public void add() {
        Scanner ina = new Scanner(System.in);
        String id, Name, semester, course;
        do {
            do {
                System.out.print("Enter ID: ");
                id = ina.nextLine();
            } while (!checkID(id));
            do {
                System.out.print("Enter Student Name: ");
                Name = ina.nextLine();
            } while (!checkName(Name));
        } while (!checkIdName(id, Name));
        do {
            System.out.print("Enter Semester: ");
            semester = ina.nextLine();
        } while (!checkSemester(semester));
        do {
            System.out.print("Enter Course Name: ");
            course = ina.nextLine();
        } while (!checkCourse(course));
        st.add(new Student(id, Name, course, semester));
    }

    public void create() {
        int count = 0;
        do {
            add();
            count++;
            if (count >= 2) {
                System.out.println("Do you want to continue (Y/N)?");
                String a = in.next();
                if (a.equalsIgnoreCase("n")) {
                    return;
                }
            }
        } while (true);
    }

    public void display(ArrayList<Student> s) {
        System.out.printf("%-20s%-10s%-15s\n", "Name", "Course", "Semester");
        for (int i = 0; i < s.size(); i++) {
            Student st = s.get(i);
            System.out.printf("%-20s%-15s%-10s\n", st.getName(), st.getCourse(), st.getSemester());
        }
    }

    public void Find() {
        Scanner inf = new Scanner(System.in);
        if (st.size() == 0) {
            System.out.println("There is no students in list! You have to create first!");
        } else {
            System.out.print("Enter Student Name: ");
            String name = inf.nextLine();
            ArrayList<Student> s = new ArrayList<>();
            for (int i = 0; i < st.size(); i++) {
                if (st.get(i).getName().contains(name)) {
                    s.add(st.get(i));
                }
            }

            if (s.size() != 0) {
                Collections.sort(s, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.getName().compareToIgnoreCase(o2.getName());
                    }
                });
                display(s);

            } else {
                System.out.println("Can not find any student");
            }

        }

    }

    public void updateStudent(Student s) {
        Scanner inu = new Scanner(System.in);
        String id, Name, semester, course;
        do {
            System.out.print("Enter ID: ");
            id = inu.nextLine();
        } while (!checkID(id));
        do {
            System.out.print("Enter Student Name: ");
            Name = inu.nextLine();
        } while (!checkName(Name));
        do {
            System.out.print("Enter Semester: ");
            semester = inu.nextLine();
        } while (!checkSemester(semester));
        do {
            System.out.print("Enter Course Name: ");
            course = inu.nextLine();
        } while (!checkCourse(course));

        s.setId(id);
        s.setName(Name);
        s.setSemester(semester);
        s.setCourse(course);
    }

    public void deleteStudent(Student s) {
        st.remove(s);

    }

    public Student findByID(String id) {
        Student student = new Student();
        boolean check = false;
        for (Student s : st) {
            if (s.getId().equalsIgnoreCase(id)) {
                student = s;
                check = true;
                break;
            }
        }
        if (check == true) {
            return student;
        } else {
            return null;
        }
    }

    public void UpdateorDelete() {
        if (st.size() == 0) {
            System.out.println("There is no students in list! You have to create first!");
        } else {
            Scanner inud = new Scanner(System.in);
            String id;
            do {
                System.out.print("Enter an ID: ");
                id = inud.nextLine();
            } while (!checkID(id));
            Student s = findByID(id);
            boolean check = false;
            if (s != null) {
                do {
                    System.out.println("Do you want to update(U) or delete(D) student?");
                    String op = inud.nextLine();
                    if (op.equalsIgnoreCase("U")) {
                        updateStudent(s);
                        System.out.println("update sucessfully!");
                        check = true;
                    } else if (op.equalsIgnoreCase("D")) {
                        deleteStudent(s);
                        System.out.println("delete sucessfully!");
                        check = true;
                    } else {
                        System.out.println("Only enter U(update) or D(delete)");
                    }
                } while (!check);
            } else {
                System.out.println("Can not find any student by ID: " + id);
            }
        }
    }

    public void report() {
        ArrayList<Student> str = new ArrayList<>(st);
        if (st.size() == 0) {
            System.out.println("There is no students in list! You have to create first!");
        } else {
            for (int i = 0; i < str.size(); i++) {
                int totalCourse = 1;
                Student si = str.get(i);
                if (i != str.size()) {
                    for (int j = i + 1; j < str.size(); j++) {
                        Student sj = str.get(j);
                        if (equalStudent(si, sj)) {
                            totalCourse++;
                            str.remove(sj);
                        }
                    }
                }
                System.out.println(si.getName() + " | " + si.getCourse() + " | " + totalCourse);
            }
        }
    }

}
