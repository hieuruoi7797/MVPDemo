

package vn.hieuruoi.mvpdemo.screen.register;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import vn.hieuruoi.mvpdemo.R;
import vn.hieuruoi.mvpdemo.data.source.local.sqlite.UserDb;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    private EditText mEditTextUserName;
    private EditText mEditTextPassword;
    private Button mButtonRegister;
    private UserDb mDBUser;

    public static RegisterFragment getNewInstance() {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

}
