package phenrique.idwall.desafioidwall.mvp.feed;

import phenrique.idwall.desafioidwall.data.model.Feed;
import phenrique.idwall.desafioidwall.data.network.ApiManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedModel implements FeedMVP.Model {

    private FeedMVP.Presenter presenter;

    public FeedModel(FeedMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestDogs(final String category, String token) {
        try {
            presenter.showProgressBar(true);

            Call<Feed> call = ApiManager.get().requestFeed(category, token);

            call.enqueue(new Callback<Feed>() {
                @Override
                public void onFailure(Call<Feed> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showProgressBar(false);
                    presenter.showSnackbar("Erro!" + t.getMessage() );
                }

                @Override
                public void onResponse(Call<Feed> call, Response<Feed> response) {
                    if (response.isSuccessful()) {
                        presenter.populateRecyclerView(category, response.body());
                    } else {
                        presenter.showSnackbar("Erro!" + response.body());
                    }
                    presenter.showProgressBar(false);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            presenter.showProgressBar(false);
        }
    }
}
