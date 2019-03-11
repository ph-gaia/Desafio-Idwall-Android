package phenrique.idwall.desafioidwall.mvp.signup;

import phenrique.idwall.desafioidwall.data.model.Login;
import phenrique.idwall.desafioidwall.data.model.RequestLogin;
import phenrique.idwall.desafioidwall.data.model.User;
import phenrique.idwall.desafioidwall.data.network.ApiManager;
import phenrique.idwall.desafioidwall.utils.AppPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupModel implements SignupMVP.Model {

    private SignupMVP.Presenter presenter;

    public SignupModel(SignupMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestLogin(String email) {
        try {
            presenter.showProgressBar(true);
            presenter.showButtonLogin(false);

            Call<Login> call = ApiManager.get().requestLogin(new RequestLogin(email));

            call.enqueue(new Callback<Login>() {
                @Override
                public void onFailure(Call<Login> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showProgressBar(false);
                    presenter.showButtonLogin(true);
                    presenter.showSnackbar( t.getMessage() );
                }

                @Override
                public void onResponse(Call<Login> call, Response<Login> response) {
                    User user = response.body().getUser();

                    saveTokenAndEmailUser(user);

                    presenter.showProgressBar(false);
                    presenter.showButtonLogin(true);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            presenter.showProgressBar(false);
            presenter.showButtonLogin(true);
        }
    }

    private void saveTokenAndEmailUser(User user) {
        AppPreference.setSaveUser(presenter.getContext(), user);
        presenter.startIntent();
    }
}
