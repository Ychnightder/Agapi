package iut.dam.agapi.managers;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.junit.jupiter.api.Assertions.*;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import iut.dam.agapi.managersV2.AppDatabase;

@RunWith(AndroidJUnit4.class)
public class DbTest {
    private Context context;
    private AppDatabase db =  AppDatabase.getInstance(context);

}
