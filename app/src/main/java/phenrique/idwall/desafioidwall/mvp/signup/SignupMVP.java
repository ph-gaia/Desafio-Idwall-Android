package phenrique.idwall.desafioidwall.mvp.signup;

import android.content.Context;

public interface SignupMVP {

    interface View {
        void showSnackbar( String mensagem );
        void showProgressBar( int visibilidade );
        void showButtonLogin( int visibilidade );
        void showTextError( String mensagem );
        void startIntent();
    }

    interface Presenter {
        void showSnackbar( String mensagem );
        void showProgressBar( boolean status );
        void showButtonLogin( boolean visibilidade );
        void singupLogin( String email );
        void setView( SignupMVP.View view );
        Context getContext();
        void startIntent();
    }

    interface Model {
        void requestLogin(String email);
    }
}
