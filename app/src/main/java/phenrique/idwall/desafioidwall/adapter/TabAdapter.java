package phenrique.idwall.desafioidwall.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import phenrique.idwall.desafioidwall.mvp.feed.FeedFragment;


public class TabAdapter extends FragmentPagerAdapter {

    private int mTabCount;

    public TabAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.mTabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        return new FeedFragment();
    }

    @Override
    public int getCount() {
        return mTabCount;
    }
}
