package com.kaproduction.malibilgiler;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaproduction.malibilgiler.Fragments.Fragment1GelirVergisi;
import com.kaproduction.malibilgiler.Fragments.Fragment2KarPayi;
import com.kaproduction.malibilgiler.Fragments.Fragment3Agi;
import com.kaproduction.malibilgiler.Fragments.Fragment4AsgariUcret;
import com.kaproduction.malibilgiler.Fragments.Fragment5KapiciUcret;
import com.kaproduction.malibilgiler.Fragments.Fragment6GecikmeFaizi;

public class CalculateActivity extends AppCompatActivity {

    private static final int TAB_5 = 0;
    private static final int TAB_6 = 1;
    private static final int TAB_7 = 2;
    private static final int TAB_8 = 3;
    private static final int TAB_9 = 4;
    private static final int TAB_10 = 5;

    /* -------------------------------------*/
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    Bundle bundle;
    long mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarCalculate);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.containerCalculateActivity);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabsCalculate);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(mViewPager);

        bundle = getIntent().getExtras();
        if (bundle != null) {
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
            View rootView = inflater.inflate(R.layout.fragment_0calculate, container, false);
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
                case CalculateActivity.TAB_5:
                    fragment = Fragment1GelirVergisi.newInstance("", "");
                    break;
                case CalculateActivity.TAB_6:
                    fragment = Fragment2KarPayi.newInstance("", "");
                    break;
                case CalculateActivity.TAB_7:
                    fragment = Fragment3Agi.newInstance("", "");
                    break;
                case CalculateActivity.TAB_8:
                    fragment = Fragment4AsgariUcret.newInstance("", "");
                    break;
                case CalculateActivity.TAB_9:
                    fragment = Fragment5KapiciUcret.newInstance("", "");
                    break;
                case CalculateActivity.TAB_10:
                    fragment = Fragment6GecikmeFaizi.newInstance("", "");
                    break;
                default:
                    break;
            }


            return fragment;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case CalculateActivity.TAB_5:
                    return "Gelir Vergisi";

                case CalculateActivity.TAB_6:
                    return "Kar Payı";

                case CalculateActivity.TAB_7:
                    return "Asgari Geçim İndirimi ";

                case CalculateActivity.TAB_8:
                    return "Asgari Ücret ";

                case CalculateActivity.TAB_9:
                    return "Kapıcı Ücreti ";

                case CalculateActivity.TAB_10:
                    return "Gecikme Faizi";


                default:
                    break;

            }
            return "";

        }
    }

}
