package vn.hieuruoi.mvpdemo;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vn.hieuruoi.mvpdemo.screen.login.LoginFragment;
import vn.hieuruoi.mvpdemo.screen.register.RegisterFragment;

public class MainActivity extends AppCompatActivity {
    LoginFragment loginFragment;
    RegisterFragment registerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();
        addFragments();
    }

    private void addFragments() {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl_container, loginFragment);
        transaction.commit();
    }
}
