package vn.hieuruoi.mvpdemo.screen.login;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.hieuruoi.mvpdemo.MainActivity;
import vn.hieuruoi.mvpdemo.R;
import vn.hieuruoi.mvpdemo.data.repository.UserRepository;
import vn.hieuruoi.mvpdemo.data.source.local.UserLocalDataSource;
import vn.hieuruoi.mvpdemo.data.source.local.sqlite.UserDb;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener, LoginContract.View {
    private EditText mTextUsername;
    private EditText mTextPassword;
    private Button mButtonLogin;
    private LoginContract.Presenter mPresenter;
    private UserDb mUserDb;


    public static LoginFragment getNewInstace() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initView(view);
        mButtonLogin.setOnClickListener(this);
        mUserDb = new UserDb(getActivity());
        UserRepository mUserRepository = new UserRepository(new UserLocalDataSource(mUserDb));
        mPresenter = new LoginPresenter(mUserRepository, this);

        return view;
    }

    private void initView(View view) {
        mTextUsername = view.findViewById(R.id.et_login_username);
        mTextPassword = view.findViewById(R.id.et_login_username);
        mButtonLogin = view.findViewById(R.id.bt_signin_login);
    }

    @Override
    public void onClick(View view) {
        String username = mTextUsername.getText().toString();
        String password = mTextPassword.getText().toString();
        mPresenter.checkCorrection(username, password);
        clearText();
    }

    @Override
    public void showDetail() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity(), getString(R.string.showError), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearText() {
        mTextPassword.setText("");
        mTextUsername.setText("");
    }
}
