package org.example;

public class Client {

    public static Object getLogin;
    private String login;
    private String email;
    private String password;


    public Client(String login, String email, String password ) {
        this.login = login;
        this.email = email;
        this.password = password;
    }


    public static String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

