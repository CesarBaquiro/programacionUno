package co.edu;

public class Estudiantes {

    // Atributos
    private String id;
    private String name;
    private String lastname;
    private String phone;
    private String mail;
    private int age;

    // Constructor
    public Estudiantes(String id, String name, String lastname, String mail, String phone, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.mail = mail;
        this.phone = phone;
        this.age = age;
    }

    // Getters y Setters

        public String getId() {
        return id;
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

        public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

        public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
