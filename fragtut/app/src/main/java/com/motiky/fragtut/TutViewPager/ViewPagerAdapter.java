package com.motiky.fragtut.TutViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.motiky.fragtut.FragementActivity.AFragment;
import com.motiky.fragtut.FragementActivity.BFragment;
import com.motiky.fragtut.FragementActivity.CFragment;
import com.motiky.fragtut.FragementActivity.DFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new AFragment();
        } else if(position == 1){
            return new BFragment();
        } else if (position == 2) {
            return new CFragment();
        } else{
            return new DFragment();
        }
    }

    @Override
    public int getCount() {
        return 4; // no. of fragments/pages
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Fragment A";
        } else if (position == 1) {
            return "Fragment B";
        } else if (position == 2) {
            return "Fragment C";
        } else {
            return "Fragment D";
        }
    }
}
