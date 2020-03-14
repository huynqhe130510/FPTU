
public class Person {

    String id;
    String name;
    boolean gender;
    int Age;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "NewClass{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", Age=" + Age + '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public Person() {
    }

    public Person(String id, String name, boolean gender, int Age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.Age = Age;
    }

    protected void Display() {

    }
}
