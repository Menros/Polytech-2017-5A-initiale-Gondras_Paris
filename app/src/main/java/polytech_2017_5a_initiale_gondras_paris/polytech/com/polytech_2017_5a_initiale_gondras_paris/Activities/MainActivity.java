package polytech_2017_5a_initiale_gondras_paris.polytech.com.polytech_2017_5a_initiale_gondras_paris.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import polytech_2017_5a_initiale_gondras_paris.polytech.com.polytech_2017_5a_initiale_gondras_paris.Fragments.HomeFragment;
import polytech_2017_5a_initiale_gondras_paris.polytech.com.polytech_2017_5a_initiale_gondras_paris.Fragments.QuizzFragment;
import polytech_2017_5a_initiale_gondras_paris.polytech.com.polytech_2017_5a_initiale_gondras_paris.R;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }
            HomeFragment firstFragment = new HomeFragment();

            firstFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }

    public void openQuizz(View view){

        QuizzFragment newFragment = new QuizzFragment();
        newFragment.setArguments(getIntent().getExtras());

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}