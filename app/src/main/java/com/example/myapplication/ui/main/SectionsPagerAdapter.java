package com.example.myapplication.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.R;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search.Clinics_frag;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search.Doctors_frag;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search.Hospitals_frag;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search.Specialty_frag;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{ R.string.Clinics,R.string.Doctors};
    private final Context mContext;
    private Hospitals_frag hospitals_frag = new Hospitals_frag();
    private Specialty_frag specialty_frag = new Specialty_frag();
    private Clinics_frag clinics_frag = new Clinics_frag();
    private Doctors_frag doctors_frag = new Doctors_frag();

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fragment ;
        switch (position){
//            case 0:
//                fragment =  specialty_frag;
//                break;
//            case 0:
//                 fragment =   hospitals_frag;
//                break;

            case 0:
                fragment = clinics_frag;
                break;
            case 1:
                fragment = doctors_frag;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);

        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}