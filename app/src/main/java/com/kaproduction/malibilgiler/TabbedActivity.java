package com.kaproduction.malibilgiler;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.kaproduction.malibilgiler.Fragments.Tab1;
import com.kaproduction.malibilgiler.Fragments.Tab2;
import com.kaproduction.malibilgiler.Fragments.Tab3;
import com.kaproduction.malibilgiler.Fragments.Tab4;
import com.kaproduction.malibilgiler.R;

public class TabbedActivity extends AppCompatActivity  {

    private static final int TAB_1 = 0;
    private static final int TAB_2 = 1;
    private static final int TAB_3 = 2;
    private static final int TAB_4 = 3;
   /* -------------------------------------*/
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(mViewPager);

        bundle = getIntent().getExtras();
        if(bundle!=null){
            int TAB_ID = bundle.getInt("TAB_ID");
            TabLayout.Tab tab = tabLayout.getTabAt(TAB_ID);
            tab.select();
        }
 }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       //getMenuInflater().inflate(R.menu.menu_tabbed, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }




    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;

            switch (position) {
                case TabbedActivity.TAB_1:
                    fragment = Tab1.newInstance("", "");
                    break;
                case TabbedActivity.TAB_2:
                    fragment = Tab2.newInstance("", "");
                    break;
                case TabbedActivity.TAB_3:
                    fragment = Tab3.newInstance("", "");
                    break;
                case TabbedActivity.TAB_4:
                    fragment = Tab4.newInstance("", "");
                    break;
                default:
                    break;
            }


            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case TabbedActivity.TAB_1:
                    return "Vergi";

                case TabbedActivity.TAB_2:
                    return "Sosyal Güvenlik";

                case TabbedActivity.TAB_3:
                    return "Temel Makro ";

                case TabbedActivity.TAB_4:
                    return "Hepsi ";

                default:
                    break;

            }
            return "";

        }
    }

}
