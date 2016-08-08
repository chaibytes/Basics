package com.chaibytes.androidapplicationjune11;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class PostLoginScreenActivity extends Activity implements ExampleFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login_screen);
        //Toast.makeText(this, "PostLoginScreenActivity.onCreate() method", Toast.LENGTH_LONG).show();

        FragmentManager fragmentManager = getFragmentManager();


        Fragment fragment = fragmentManager.findFragmentById(R.id.frame_layout);
        if (fragment == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.frame_layout, new ExampleFragment());
            fragmentTransaction.commit();
        }

        Button intentBtn = (Button) findViewById(R.id.buttonIntentService);
        intentBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 buttonIntentClick(v);
             }
        });

    }

    public void buttonIntentClick(View v) {
        Intent myIntent = new Intent(getApplicationContext(), ServiceActivity.class);
        startActivity(myIntent);
    }


    @Override
    public void onStart() {
        super.onStart();

        //Toast.makeText(this, "PostLoginScreenActivity.onStart() method", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();
//        registerReceiver(receiver, filter);
//        Toast.makeText(this, "PostLoginScreenActivity.onResume() method", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPause() {
//        if (receiver != null) {
//            unregisterReceiver(receiver);
//            receiver = null;
//        }
        super.onPause();
        //Toast.makeText(this, "PostLoginScreenActivity.onPause() method", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStop() {
        super.onStop();

        //Toast.makeText(this, "PostLoginScreenActivity.onStop() method", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //Toast.makeText(this, "PostLoginScreenActivity.onDestroy() method", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFragmentInteraction(String text) {
        //Toast.makeText(this, "PostLoginScreenActivity.onFragmentInteraction()", Toast.LENGTH_LONG).show();

        //Toast.makeText(this, "Hello " + text + " !. Welcome.", Toast.LENGTH_LONG).show();

        testFunction(text);

        FragmentManager fragmentManager = getFragmentManager();
        Fragment myfrag = fragmentManager.findFragmentById(R.id.frame_layout);

        // In the case of multiple fragments
        if ((myfrag != null && myfrag instanceof ExampleFragment) || (myfrag == null)) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, new MyListFragment());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }



    }

    public static class ExampleSimpleFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstance) {
            //Toast.makeText(getActivity(), "ExampleSimpleFragment.onCreateView() method", Toast.LENGTH_LONG).show();

            return inflater.inflate(R.layout.example_fragment, container, false);
        }

    }

    public void testFunction(String text) {
        Toast.makeText(this, "Helllllllllllo " + text, Toast.LENGTH_LONG).show();
    }

}
