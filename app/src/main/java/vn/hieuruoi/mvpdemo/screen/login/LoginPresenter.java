package vn.hieuruoi.mvpdemo.screen.login;

import vn.hieuruoi.mvpdemo.data.repository.UserRepository;

public class LoginPresenter implements LoginContract.Presenter {
    public LoginPresenter(UserRepository mUserRepository, LoginFragment loginFragment) {
    }

    @Override
    public void checkCorrection(String username, String password) {

    }
}
