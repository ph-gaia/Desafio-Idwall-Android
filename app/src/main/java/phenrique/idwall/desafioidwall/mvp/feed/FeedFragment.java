package phenrique.idwall.desafioidwall.mvp.feed;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import phenrique.idwall.desafioidwall.R;
import phenrique.idwall.desafioidwall.adapter.FeedAdapter;
import phenrique.idwall.desafioidwall.data.model.Feed;


public class FeedFragment extends Fragment {

    RecyclerView recyclerView;
    private Feed feed;
    private String category;

    public FeedFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setHasFixedSize(true);

        recyclerView.addOnItemTouchListener(new FeedAdapter.RecyclerTouchListener(getContext(), recyclerView, new FeedAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("feed", feed);
                bundle.putString("category", category);
                bundle.putInt("count", feed.getList().size());
                bundle.putInt("position", position);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                SlideshowDialogFragment newFragment = SlideshowDialogFragment.newInstance();
                newFragment.setArguments(bundle);
                newFragment.show(ft, "slideshow");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return view;
    }

    public void setAdapter(Feed feed, String category) {
        this.feed = feed;
        this.category = category;

        FeedAdapter feedAdapter = new FeedAdapter(feed.getList());
        recyclerView.setAdapter(feedAdapter);
    }
}
