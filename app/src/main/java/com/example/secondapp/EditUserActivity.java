package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class EditUserActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {

        Fragment fragment = new EditUserFragment();
        return fragment;
    }
}