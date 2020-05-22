package com.example.bangproject_0522;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext = this;

    public abstract void setupEvents();
    public abstract void setValues();
}
