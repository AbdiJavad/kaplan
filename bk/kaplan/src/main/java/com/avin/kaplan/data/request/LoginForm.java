package com.avin.kaplan.data.request;

public class LoginForm {
    //    @NotBlank
//    @Size(min=3, max = 60)
    private String username;

    //    @NotBlank
//    @Size(min = 6, max = 40)
    private String password;
    private String result;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}