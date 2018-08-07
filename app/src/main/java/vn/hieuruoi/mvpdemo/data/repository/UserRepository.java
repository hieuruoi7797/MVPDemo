package vn.hieuruoi.mvpdemo.data.repository;

import java.util.List;

import vn.hieuruoi.mvpdemo.data.model.User;
import vn.hieuruoi.mvpdemo.data.source.UserDataSource;
import vn.hieuruoi.mvpdemo.data.source.local.UserLocalDataSource;

public class UserRepository implements UserDataSource.LocalDataSource, UserDataSource.RemoteDataSource {
    private UserLocalDataSource mUserLocalDataSource;

    public UserRepository(UserLocalDataSource userLocalDataSource) {
        mUserLocalDataSource = userLocalDataSource;
    }

    @Override
    public void addUser(User user) {
        mUserLocalDataSource.addUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return mUserLocalDataSource.getAllUser();
    }

    @Override
    public boolean checkUserPassword(String username, String password) {
        return mUserLocalDataSource.checkUserPassword(username, password);
    }

    @Override
    public boolean checkUserExists(String username) {
        return mUserLocalDataSource.checkUserExists(username);
    }
}
