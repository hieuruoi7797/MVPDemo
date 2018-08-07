package vn.hieuruoi.mvpdemo.data.source.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.hieuruoi.mvpdemo.data.model.User;
import vn.hieuruoi.mvpdemo.data.source.local.sqlite.UserDb;
import vn.hieuruoi.mvpdemo.data.source.UserDataSource;

public class UserLocalDataSource implements UserDataSource.LocalDataSource {
    private UserDb mUserDb;
    private static final String TABLE_NAME = "user";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    public UserLocalDataSource(UserDb dbUser) {
        mUserDb = dbUser;
    }

    @Override
    public void addUser(User user) {
        SQLiteDatabase db = mUserDb.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPassword());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = mUserDb.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        do {
            User user = new User();
            user.setUsername(cursor.getString(1));
            user.setPassword(cursor.getString(2));
        } while (cursor.moveToNext());
        cursor.close();
        db.close();
        return userList;
    }

    @Override
    public boolean checkUserPassword(String username, String password) {
        boolean STATE = false;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = mUserDb.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        do {
            String name = cursor.getString(1);
            String pass = cursor.getString(2);
            if (name.equals(username) && pass.equals(password)) {
                STATE = true;
            }
        } while (cursor.moveToNext());
        cursor.close();
        db.close();
        return STATE;
    }

    @Override
    public boolean checkUserExists(String username) {
        boolean STATE = false;
        String selecQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = mUserDb.getWritableDatabase();
        Cursor cursor = db.rawQuery(selecQuery, null);
        cursor.moveToFirst();
        do {
            String name = cursor.getString(1);
            if (name.equals(username)) {
                STATE = true;
            }
        } while (cursor.moveToNext());
        cursor.close();
        db.close();
        return STATE;
    }
}
