package vn.hieuruoi.mvpdemo.data.model;

public class User {
    private int mId;
    private String mUsername;
    private String mPassword;
    private String mEmail;

    public User() {
    }

    public User(int id, String userName, String password, String email) {
        mId = id;
        mUsername = userName;
        mPassword = password;
        mEmail = email;
    }

    public void setId(int id) {
        mId = id;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public int getId() {
        return mId;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getPassword() {
        return mPassword;
    }

    public String getEmail() {
        return mEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "mUsername='" + mUsername + '\'' +
                ", mPassword='" + mPassword + '\'' +
                '}';
    }
}
