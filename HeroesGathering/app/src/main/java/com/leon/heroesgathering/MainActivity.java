package com.leon.heroesgathering;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity
    implements MeFragment.OnMeFragmentInteractionListener,
    SearchFragment.OnSearchFragmentInteractionListener,
    GroupFragment.OnGroupFragmentInteractionListener,
    FriendFragment.OnFriendFragmentInteractionListener{

    private Button buttonGroups;
    private Button buttonSearch;
    private Button buttonFriends;
    private Button buttonMe;

    private Button loanButton;
    private Button myAccountButton;
    private Button recordButton;
    private Button stateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGroups = (Button)findViewById(R.id.buttonGroups);
        buttonSearch = (Button)findViewById(R.id.buttonSearch);
        buttonFriends = (Button)findViewById(R.id.buttonFriends);
        buttonMe = (Button)findViewById(R.id.buttonMe);

        loanButton = (Button)findViewById(R.id.LoanButton);
        myAccountButton = (Button)findViewById(R.id.MyAccountButton);
        recordButton = (Button)findViewById(R.id.RecordButton);
        stateButton = (Button)findViewById(R.id.StateButton);
/*
        getFragmentManager()
                .beginTransaction()
                .add(R.id.fragment, new MeFragment())
                .commit();
*/
        buttonGroups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, new GroupFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, new SearchFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        buttonFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, new FriendFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        buttonMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, new Loginfragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
/*
        loanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment2, new LoanFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        myAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment2, new MyAccountFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment2, new RecordFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        stateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment2, new StateFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){

        if(getFragmentManager().getBackStackEntryCount() > 0)
            getFragmentManager().popBackStack();
        else
            super.onBackPressed();
    }

        public void onFragmentInteraction(Uri uri){
    }
}
