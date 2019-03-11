package phenrique.idwall.desafioidwall.mvp.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import phenrique.idwall.desafioidwall.R;
import phenrique.idwall.desafioidwall.mvp.feed.FeedActivity;


public class SignupActivity extends AppCompatActivity implements SignupMVP.View {

    private static SignupMVP.Presenter presenter;
    private CoordinatorLayout coordinatorLayout;
    TextInputLayout textInputEmail;
    EditText editLoginEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new SignupPresenter();
        presenter.setView( this );
        bindView();
    }

    private void bindView() {
        coordinatorLayout = findViewById(R.id.layoutLogin);
        textInputEmail = findViewById(R.id.text_login_email);
        editLoginEmail = findViewById(R.id.edit_login_email);
    }

    @Override
    public void showSnackbar(String mensagem) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void showTextError( String mensagem ) {
        textInputEmail.setError(mensagem);
    }

    @Override
    public void startIntent() {
        startActivity(new Intent(this, FeedActivity.class));
        finish();
    }

    @Override
    public void showProgressBar(int visibilidade) {
        findViewById(R.id.progressBar).setVisibility( visibilidade );
    }

    @Override
    public void showButtonLogin(int visibilidade) {
        findViewById(R.id.btnLogin).setVisibility( visibilidade );
    }

    public void requestLogin(View view) {
        presenter.singupLogin(editLoginEmail.getText().toString().trim());
    }
}
