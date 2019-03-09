package phenrique.idwall.desafioidwall.mvp.feed;

import android.content.Context;

import phenrique.idwall.desafioidwall.data.model.Feed;

public interface FeedMVP {

    interface View {
        void showSnackbar( String mensagem );
        void showProgressBar( int visibilidade );
        void populateRecyclerView(String category, final Feed feed);
        void viewLogin();
    }

    interface Presenter {
        void showSnackbar( String mensagem );
        void showProgressBar( boolean status );
        void requestDogs(String category, String token);
        void setView( FeedMVP.View view );
        void populateRecyclerView(String category, Feed feed);
        Context getContext();
    }

    interface Model {
        void requestDogs(final String category, String token);
    }
}
