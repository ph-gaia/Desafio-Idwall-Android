package phenrique.idwall.desafioidwall.mvp.feed;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import phenrique.idwall.desafioidwall.R;
import phenrique.idwall.desafioidwall.adapter.FeedAdapter;


public class FeedFragment extends Fragment {

    RecyclerView recyclerView;

    public FeedFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setHasFixedSize(true);
        return view;
    }

    public void setAdapter(List<String> list) {
        FeedAdapter feedAdapter = new FeedAdapter(list);
        recyclerView.setAdapter(feedAdapter);
    }
}
