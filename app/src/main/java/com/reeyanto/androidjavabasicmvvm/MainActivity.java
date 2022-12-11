package com.reeyanto.androidjavabasicmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.reeyanto.androidjavabasicmvvm.databinding.ActivityMainBinding;
import com.reeyanto.androidjavabasicmvvm.model.User;
import com.reeyanto.androidjavabasicmvvm.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        binding.btnButton.setOnClickListener(view -> {
            User user = new User(binding.etUser.getText().toString());
            userViewModel.setUser(user);
        });

        userViewModel.getUser().observe(this, user -> binding.tvResult.setText(user.getUser()));
    }
}