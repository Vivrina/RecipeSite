package ru.itis.form;

public class UserForm {
    private String name;
    private String password;
    private String email;
    private Integer achievement = 0;


    public UserForm() {
    }

    public UserForm(String name, String password, String email, Integer achievement) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.achievement = achievement;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", achievement=" + achievement +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAchievement() {
        return achievement;
    }

    public void setAchievement(Integer achievement) {
        this.achievement = achievement;
    }
}
