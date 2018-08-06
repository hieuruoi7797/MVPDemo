package vn.hieuruoi.mvpdemo.screen.register;

import vn.hieuruoi.mvpdemo.data.model.User;
import vn.hieuruoi.mvpdemo.data.repository.UserRepository;

public class RegisterPresenter implements RegisterContract.Presenter {
    private UserRepository mUserRepository;
    private RegisterContract.View mView;
    public RegisterPresenter(UserRepository userRepository, RegisterContract.View view) {
        mUserRepository = userRepository;
        mView = view;
    }
    @Override
    public void checkUser(String username, String password) {
        boolean check = mUserRepository.checkUserExists(username);
        if(check){
            mView.showUserNameExists();
        }else{
            mView.showSignInSuccessful();
            mView.clearText();
        }
    }

    @Override
    public void addUser(User user) {
        mUserRepository.addUser(user);
    }
}
