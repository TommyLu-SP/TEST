package com.lu.lifecycletest;

import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainFragment extends Fragment {
    private Activity activity;
    private TextView tvNext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        Log.d("TAG_MF","TAG_onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("TAG_MF","TAG_onCreateView");
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("TAG_MF","TAG_onViewCreated");
        tvNext = view.findViewById(R.id.tvNext);
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.secondFragment);
            }
        });

        String a = "1.1.4";
        String[] b = a.split("\\.");
        Log.d("TAG_B0",b[0]);
        Log.d("TAG_B1",b[1]);
        Log.d("TAG_B2",b[2]);
        Log.d("TAG_TESTF1","TESTF1");
        Log.d("TAG_TESTF2","TESTF2");
        Log.d("TAG_TESTH1","TESTH1");
        Log.d("TAG_TESTF3","TESTF3");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG_MF","TAG_onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MainActivity.status == 1){
            MainActivity.status = 0;
            reLoadFragment(MainFragment.this);
        }
        Log.d("TAG_MF","TAG_onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG_MF","TAG_onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG_MF","TAG_onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG_MF","TAG_onDestroy");
    }

    public void reLoadFragment(Fragment fragment) {
        Fragment currentFragment = fragment;
        FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
        fragTransaction.detach(currentFragment);
        fragTransaction.attach(currentFragment);
        fragTransaction.commit();
    }

}