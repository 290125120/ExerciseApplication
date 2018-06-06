package com.example.zhangwei56.exerciseapplication.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.zhangwei56.exerciseapplication.User;

public class UserViewModel extends ViewModel{
    private String id = "";
    int i = 0;
    LiveData<User> userLiveData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LiveData<User> getUserLiveData() {
        final MutableLiveData<User> data = new MutableLiveData<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                User user = new User();
                if (i == 0) {
                    user.setName("zhangwei");
                }else {
                    user.setName("kongshuting");
                }

                user.setPassword("haha");
                data.postValue(user);
                Log.e("haha", user.getName());
                Log.e("哈哈", Thread.currentThread().toString());

            }
        }).run();
        i++;
        return userLiveData = data;
    }

    public void setUserLiveData(LiveData<User> userLiveData) {
        this.userLiveData = userLiveData;
    }
}
