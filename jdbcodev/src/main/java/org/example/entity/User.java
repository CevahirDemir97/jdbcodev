package org.example.entity;

public class User extends BaseEntity {
    private  int id;
    private String email;

    private String name;

    private String surname;

    private String password;

    public User() {
    }

    @Override
    public int getId() {
        return id;
    }

    public User(String email, String name, String surname, String password) {

        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                '}'+super.toString();
    }
    public static class UserBuilder{
        private String email;

        private String name;

        private String surname;

        private String password;

        public UserBuilder(String email,String name,String surname,String password){
            this.email = email;
            this.name = name;
            this.surname = surname;
            this.password = password;
        }
        public User build(){
            return  new User(this.email,this.name,this.surname,this.password);
        }



    }
}
