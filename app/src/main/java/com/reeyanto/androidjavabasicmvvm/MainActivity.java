package com.reeyanto.androidjavabasicmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
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

        binding.btnButton.setOnClickListener(view -> {
            User user = new User(binding.etUser.getText().toString());
            binding.tvResult.setText(user.getUser());
        });

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUser().observe(this, user -> userViewModel.setUser(user));
    }
}