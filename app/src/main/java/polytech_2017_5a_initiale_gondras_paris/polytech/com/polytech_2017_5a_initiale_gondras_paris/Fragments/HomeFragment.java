package polytech_2017_5a_initiale_gondras_paris.polytech.com.polytech_2017_5a_initiale_gondras_paris.Fragments;

/**
 * Created by franck on 11/10/17.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import polytech_2017_5a_initiale_gondras_paris.polytech.com.polytech_2017_5a_initiale_gondras_paris.R;
import polytech_2017_5a_initiale_gondras_paris.polytech.com.polytech_2017_5a_initiale_gondras_paris.Services.IntentServiceQuestions;

public class HomeFragment extends Fragment {

    private HomeInterface myInterface;

    public interface HomeInterface{
        void on1vIAClick();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_layout, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            myInterface = (HomeInterface) context;
        } catch(ClassCastException e){
            Log.d("test", "Context must implement HomeInterface");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button button = (Button) getActivity().findViewById(R.id.button1vIA);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(myInterface != null){
                    myInterface.on1vIAClick();
                    getQuestion();
                }
            }
        });
    }

    private void getQuestion(){
        Intent msgIntent = new Intent(this.getContext(), IntentServiceQuestions.class);
        msgIntent.putExtra(IntentServiceQuestions.PARAM_IN_MSG, IntentServiceQuestions.ACTION_VALUE_GET_QUESTION);
        this.getContext().startService(msgIntent);
    }

    public class ResponseReceiver extends BroadcastReceiver {
        public static final String ACTION_RESP =
                "com.mamlambo.intent.action.MESSAGE_PROCESSED";

        @Override
        public void onReceive(Context context, Intent intent) {
            TextView result = (TextView) getActivity().findViewById(R.id.question);
            String text = intent.getStringExtra(IntentServiceQuestions.PARAM_OUT_MSG);
            result.setText(text);
        }
    }
}

