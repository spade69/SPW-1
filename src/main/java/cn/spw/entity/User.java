package cn.spw.entity;

/**
 * Created by jiax on 2016/9/17.
 */
public class User {
    private String userUuid;
    private String username;
    private String password;
    private String email;

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    private String validateCode;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String user_uuid) {
        this.userUuid = user_uuid;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userUuid=" + userUuid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", validateCode='" + validateCode + '\'' +
                '}';
    }
}
