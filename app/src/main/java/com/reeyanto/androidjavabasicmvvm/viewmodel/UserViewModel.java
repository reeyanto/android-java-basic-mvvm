package com.reeyanto.androidjavabasicmvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.reeyanto.androidjavabasicmvvm.model.User;

public class UserViewModel extends ViewModel {

    private MutableLiveData<User> userMutableLiveData;

    public LiveData<User> getUser() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    public void setUser(User user) {
        userMutableLiveData.setValue(user);
    }
}
