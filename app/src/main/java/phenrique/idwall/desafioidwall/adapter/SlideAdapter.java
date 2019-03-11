package phenrique.idwall.desafioidwall.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


import java.util.List;

import phenrique.idwall.desafioidwall.R;

public class SlideAdapter extends PagerAdapter {

    private List<String> mList;

    public SlideAdapter(List<String> list) {
        this.mList = list;
    }

    @Override
    public Object instantiateItem(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_fullscreen_preview, parent, false);

        ImageView imageViewPreview = view.findViewById(R.id.image_preview);

        Picasso.get()
                .load(mList.get(position))
                .placeholder(R.drawable.ic_placeholder)
                .into(imageViewPreview);

        parent.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == ((View) obj);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
