package com.example.myapplication.ui.main;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.R;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search.Clinics_frag;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search.Doctors_frag;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search.Hospitals_frag;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search.Previous_frag;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search.Specialty_frag;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search.Upcoming_frag;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class  SectionsPagerAdaptere extends FragmentStatePagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{ R.string.Upcoming,R.string.Previous};
    private final Context mContext;
    private Upcoming_frag up = new Upcoming_frag();
    private Previous_frag pre_frag = new Previous_frag();

    public SectionsPagerAdaptere(Context context, FragmentManager fm) {
        super(fm);
        Log.d("02020202023", "onCreateView: "  );
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fragment ;
        Log.d("02020202024", "onCreateView: "  );
        switch (position){
//            case 0:
//                fragment =  specialty_frag;
//                break;
//            case 0:
//                 fragment =   hospitals_frag;
//                break;

            case 0:
                fragment = up;
                Log.d("02020202027", "onCreateView: "  );
                break;
            case 1:
                Log.d("02020202026", "onCreateView: "  );
                fragment = pre_frag;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);

        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Log.d("02020202025", "onCreateView: "  );
        return mContext.getResources().getString(TAB_TITLES[position]);

    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        Log.d("02020202028", "onCreateView: "  );
        return 2;
    }
}