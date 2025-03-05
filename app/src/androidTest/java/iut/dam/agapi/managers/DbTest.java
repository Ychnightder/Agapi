package iut.dam.agapi.managers;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import android.content.Context;

import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DbTest {
    private Context context;
    private AppDatabase db =  AppDatabase.getInstance(context);

}
