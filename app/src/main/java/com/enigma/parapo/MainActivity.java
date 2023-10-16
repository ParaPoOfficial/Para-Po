package com.enigma.parapo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation bnv_Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv_Main = findViewById(R.id.bnv_Main);
        bnv_Main.add(new MeowBottomNavigation.Model(1,R.drawable.jeep));
        bnv_Main.add(new MeowBottomNavigation.Model(2,R.drawable.drop_pin));
        bnv_Main.add(new MeowBottomNavigation.Model(3,R.drawable.ic_baseline_person_24));
        bnv_Main.add(new MeowBottomNavigation.Model(4,R.drawable.store));

        bnv_Main.show(1,true);
        replace(new JeepFragment());
        bnv_Main.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        replace(new JeepFragment());
                        break;

                    case 2:
                        replace(new LocatorFragment());
                        break;

                    case 3:
                        replace(new ProfileFragment());

                        break;

                    case 4:
                        replace(new MarketFragment());
                        break;

                }
                return null;
            }
        });




    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
    }
}