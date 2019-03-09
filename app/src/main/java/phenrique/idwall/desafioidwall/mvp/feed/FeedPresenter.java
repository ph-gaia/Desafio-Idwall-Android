package phenrique.idwall.desafioidwall.mvp.feed;

import android.content.Context;
import android.view.View;

import phenrique.idwall.desafioidwall.data.model.Feed;
import phenrique.idwall.desafioidwall.utils.AppPreference;

public class FeedPresenter implements FeedMVP.Presenter {

    private FeedMVP.Model model;
    private FeedMVP.View view;

    public FeedPresenter() {
        model = new FeedModel( this);
    }

    @Override
    public void requestDogs(String category, String token) {
        if(AppPreference.getLoggedStatus(getContext())) {
            model.requestDogs(category, token);
        } else {
            showSnackbar("Por favor, efetue o login novamente!");
            view.viewLogin();
        }
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
    public void setView(FeedMVP.View view) {
        this.view = view;
    }

    @Override
    public void populateRecyclerView(String category, Feed feed) {
        view.populateRecyclerView(category, feed);
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }
}
