package phenrique.idwall.desafioidwall.mvp.feed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import phenrique.idwall.desafioidwall.R;
import phenrique.idwall.desafioidwall.adapter.TabAdapter;
import phenrique.idwall.desafioidwall.data.model.Feed;
import phenrique.idwall.desafioidwall.mvp.signup.SignupActivity;
import phenrique.idwall.desafioidwall.utils.AppPreference;

import static phenrique.idwall.desafioidwall.utils.Constants.*;


public class FeedActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, FeedMVP.View {

    FeedMVP.Presenter presenter;
    FeedFragment feedFragment;
    private CoordinatorLayout coordinatorLayout;
    TabLayout tabLayout;
    ViewPager mViewPager;
    private String token;
    private ArrayList category;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        presenter = new FeedPresenter();
        presenter.setView( this );

        bindView();
        setupViewPager();

        token = AppPreference.getTokenAuth(this);
        presenter.requestDogs(category.get(0).toString(), token);
    }

    private void bindView() {
        mViewPager = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabs);
        coordinatorLayout = findViewById(R.id.layoutFeed);
        category = new ArrayList();
        category.add(INT_HUSKY, HUSKY);
        category.add(INT_LABRADOR, LABRADOR);
        category.add(INT_HOUND, HOUND);
        category.add(INT_PUG, PUG);
    }

    private void setupViewPager() {
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.husky)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.labrador)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.hound)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.pug)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        mViewPager.setAdapter(tabAdapter);
        mViewPager.setOffscreenPageLimit(tabLayout.getTabCount());
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
        presenter.requestDogs(category.get(tab.getPosition()).toString(), token);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }

    @Override
    public void showSnackbar(String mensagem) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void showProgressBar(int visibilidade) {
        findViewById(R.id.progressBar).setVisibility( visibilidade );
    }

    @Override
    public void populateRecyclerView(String category, final Feed list) {
        feedFragment = (FeedFragment) mViewPager.getAdapter().instantiateItem(mViewPager, mViewPager.getCurrentItem());
        feedFragment.setAdapter(list, this.category.get(mViewPager.getCurrentItem()).toString());
    }

    @Override
    public void viewLogin() {
        startActivity(new Intent(this, SignupActivity.class));
        finish();
    }

}
