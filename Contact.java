package Day06.Activity;

public class Contact {
    private int number;
    private String name;
    private String email;
    private int age;
    public Contact() {
    }
    public Contact(int number, String name, String email, int age) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Contact [number = " + number + ", name = " + name + ", email = " + email + ", age = " + age + "]";
    }   

    
}
