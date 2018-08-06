package vn.hieuruoi.mvpdemo.screen.register;

import vn.hieuruoi.mvpdemo.data.model.User;

public interface RegisterContract {
    interface View{
        void showErrorWhenNotEntry();
        void showSignInSuccessful();
        void showUserNameExists();
        void clearText();
    }
    interface Presenter{
        void checkUser(String username,String password);
        void addUser(User user);
    }
}
