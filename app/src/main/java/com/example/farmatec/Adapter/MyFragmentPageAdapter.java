package com.example.farmatec.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.farmatec.FragmentEstetica;
import com.example.farmatec.FragmentMedicamentos;
import com.example.farmatec.FragmentSuplementos;

public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    public String[] mTabTitles;

    public MyFragmentPageAdapter(FragmentManager fm, String[] mTabTitles) {
        super(fm);
        this.mTabTitles = mTabTitles;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new FragmentSuplementos();
            case 1:
                return new FragmentMedicamentos();
            case 2:
                return new FragmentEstetica();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.mTabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTabTitles[position];
    }

}
