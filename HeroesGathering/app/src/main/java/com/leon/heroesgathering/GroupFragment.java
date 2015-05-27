package com.leon.heroesgathering;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GroupFragment.OnGroupFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class GroupFragment extends ListFragment {

    private OnGroupFragmentInteractionListener mListener;

    private ArrayList<String> groupList; // list of tags for saved searches
    private ArrayAdapter<String> adapter; // binds tags to ListView
    
    public GroupFragment() {
        groupList= new ArrayList<String>();
        //The group list should come from the server
        groupList.add("Lordaeron");
        groupList.add("Institute of War");
        groupList.add("BJTU-LOL");
        groupList.add("High school");
        groupList.add("We are a team");
        groupList.add("Killing");
        groupList.add("Less is more");
        groupList.add("Come on baby");
        groupList.add("Breaking the news");
        groupList.add("DL");
        groupList.add("Taste my blade");
        groupList.add("Little");
        groupList.add("Double kill");
        groupList.add("Victory ");
        groupList.add("Huskar");
        groupList.add("First blood");
        groupList.add("Ironwood Branch");
        groupList.add("Medusa");
        groupList.add("Slithice");
        groupList.add("Zeus");
        groupList.add("It's lucky time");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, groupList);
        setListAdapter(adapter);
        View v =  inflater.inflate(R.layout.fragment_friend, container, false);
        ((ListView)v.findViewById(android.R.id.list)).setOnItemLongClickListener(itemLongClickListener);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnGroupFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnGroupFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        final String tag = ((TextView) v).getText().toString();
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setTitle(
                getString(R.string.messageTitle, tag));

        builder.setMessage(R.string.message);

        builder.setPositiveButton(R.string.ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                }
        );

        builder.setNegativeButton(R.string.cancel,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                }
        );

        builder.create().show();
    }

    AdapterView.OnItemLongClickListener itemLongClickListener =
        new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                               int position, long id)
            {
                final String tag = ((TextView) view).getText().toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle(R.string.leaveTitle);
                builder.setMessage(R.string.leaveGroup);

                builder.setPositiveButton(R.string.ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id){
                            groupList.remove(groupList.indexOf(tag));
                        }
                    }
                );

                builder.setNegativeButton(R.string.cancel,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    }
                );

                builder.create().show();
                return true;
            }
        };

}
