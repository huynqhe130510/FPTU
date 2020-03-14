
public class Student {
    
    private String id, Name,semester, course;
    
    
    public Student() {
        id = Name = course = semester = "";
    }

    public Student(String id, String Name, String course, String semester) {
        this.id = id;
        this.Name = Name;
        this.course = course;
        this.semester = semester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String sName) {
        this.Name = Name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
}
