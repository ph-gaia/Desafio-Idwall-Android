package phenrique.idwall.desafioidwall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

import java.util.List;

import phenrique.idwall.desafioidwall.R;


public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {

    public static final String IMAGE_DOG = "imageDog";
    private List<String> mList;

    private Context context;

    public FeedAdapter(List<String> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_dogs, parent, false);
        context = parent.getContext();
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
        Picasso.get()
            .load(mList.get(position))
            .placeholder(R.drawable.ic_placeholder)
            .into(holder.imageDog);

        holder.progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class FeedViewHolder extends RecyclerView.ViewHolder {
        CardView cardDog;
        ImageView imageDog;
        ProgressBar progressBar;

        FeedViewHolder(View itemView) {
            super(itemView);

            cardDog = itemView.findViewById(R.id.cardDog);
            imageDog = itemView.findViewById(R.id.imgDog);
            progressBar = itemView.findViewById(R.id.progressBar);

            ViewCompat.setTransitionName(imageDog, IMAGE_DOG);
        }
    }

}
