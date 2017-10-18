package polytech_2017_5a_initiale_gondras_paris.polytech.com.polytech_2017_5a_initiale_gondras_paris.Services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import polytech_2017_5a_initiale_gondras_paris.polytech.com.polytech_2017_5a_initiale_gondras_paris.Fragments.HomeFragment;

/**
 * Created by franck on 18/10/17.
 */

public class IntentServiceQuestions extends IntentService{

    public static final String PARAM_IN_MSG = "action";
    public static final String PARAM_OUT_MSG = "action";
    public static final String ACTION_VALUE_GET_QUESTION = "getQuestion";

    public IntentServiceQuestions(){
        super("IntentServiceQuestions");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        if(intent.getStringExtra(PARAM_IN_MSG).equals(ACTION_VALUE_GET_QUESTION)){
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(HomeFragment.ResponseReceiver.ACTION_RESP);
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            broadcastIntent.putExtra(PARAM_OUT_MSG, getQuestion());
            sendBroadcast(broadcastIntent);
        }
    }

    public String getQuestion(){
        return "This is a test question";
    }
}
