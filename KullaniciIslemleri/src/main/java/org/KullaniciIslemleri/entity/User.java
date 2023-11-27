package org.KullaniciIslemleri.entity;

public class User {
    //pojo entity
    private int id;
    private String name;
    private String surname;
    private String mail;
    private String password;



    public User(int id, String name, String surname, String mail, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public static class userBuilder{
        private int id;
        private String name;
        private String surname;
        private String mail;
        private String password;

        public userBuilder id(int id){
            this.id = id;
            return this;
        }
        public userBuilder name(String name){
            this.name = name;
            return this;
        }
        public userBuilder surname(String surname){
            this.surname = surname;
            return this;
        }
        public userBuilder mail(String mail){
            this.mail = mail;
            return this;
        }
        public userBuilder password(String password){
            this.password = password;
            return this;
        }
        public static userBuilder startBuilder(){
            return  new userBuilder();
        }
        public User build(){
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setSurname(surname);
            user.setMail(mail);
            user.setPassword(password);
            return user;
        }

    }

}
