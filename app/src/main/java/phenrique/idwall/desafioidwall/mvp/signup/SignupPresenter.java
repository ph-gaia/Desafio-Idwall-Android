package phenrique.idwall.desafioidwall.mvp.signup;

import android.content.Context;
import android.util.Patterns;
import android.view.View;

import phenrique.idwall.desafioidwall.R;

public class SignupPresenter implements SignupMVP.Presenter {

    private SignupMVP.Model model;
    private SignupMVP.View view;

    public SignupPresenter() {
        model = new SignupModel( this );
    }

    @Override
    public void showSnackbar(String mensagem) {
        view.showSnackbar(mensagem);
    }

    @Override
    public void showProgressBar(boolean status) {
        int visibilidade = status ? View.VISIBLE : View.GONE;
        view.showProgressBar( visibilidade );
    }

    @Override
    public void showButtonLogin(boolean status) {
        int visibilidade = status ? View.VISIBLE : View.GONE;
        view.showButtonLogin( visibilidade );
    }

    @Override
    public void setView(SignupMVP.View view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void singupLogin(String email) {
        if (!email.isEmpty())
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches())
                model.requestLogin(email);
            else
                view.showTextError(getContext().getString(R.string.email_invalid));
        else
            view.showTextError(getContext().getString(R.string.field_empty));

    }

    @Override
    public void startIntent() {
        view.startIntent();
    }
}
