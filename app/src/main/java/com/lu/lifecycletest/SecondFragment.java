package com.lu.lifecycletest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SecondFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG_SF","TAG_onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("TAG_SF","TAG_onCreateView");
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("TAG_SF","TAG_onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG_SF","TAG_onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MainActivity.status == 1){
            MainActivity.status = 0;
            reLoadFragment(SecondFragment.this);
        }
        Log.d("TAG_SF","TAG_onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG_SF","TAG_onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG_SF","TAG_onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG_SF","TAG_onDestroy");
    }

    public void reLoadFragment(Fragment fragment) {
        Fragment currentFragment = fragment;
        FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
        fragTransaction.detach(currentFragment);
        fragTransaction.attach(currentFragment);
        fragTransaction.commit();
    }
}