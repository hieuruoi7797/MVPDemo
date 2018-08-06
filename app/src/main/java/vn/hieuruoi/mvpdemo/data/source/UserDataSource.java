package vn.hieuruoi.mvpdemo.data.source;

import java.util.List;

import vn.hieuruoi.mvpdemo.data.model.User;

public interface UserDataSource {
    interface LocalDataSource {
        void addUser(User user);

        List<User> getAllUser();

        boolean checkUserPassword(String username, String password);

        boolean checkUserExists(String username);
    }

    interface RemoteDataSource {

    }
}
