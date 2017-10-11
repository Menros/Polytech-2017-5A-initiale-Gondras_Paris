package polytech_2017_5a_initiale_gondras_paris.polytech.com.polytech_2017_5a_initiale_gondras_paris.Fragments;

/**
 * Created by franck on 11/10/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import polytech_2017_5a_initiale_gondras_paris.polytech.com.polytech_2017_5a_initiale_gondras_paris.R;

public class QuizzFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.quizz_layout, container, false);
    }
}

