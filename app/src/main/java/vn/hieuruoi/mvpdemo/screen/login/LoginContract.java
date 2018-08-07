package vn.hieuruoi.mvpdemo.screen.login;

public interface LoginContract {
    interface View {
        void showDetail();

        void showError();

        void clearText();
    }

    interface Presenter {
        void checkCorrection(String username, String password);
    }
}
