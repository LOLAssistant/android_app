package com.leon.heroesgathering;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.DialogPreference;
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
 * {@link FriendFragment.OnFriendFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FriendFragment extends ListFragment {

    private OnFriendFragmentInteractionListener mListener;
    private ArrayList<String> friendList; // list of tags for saved searches
    private ArrayAdapter<String> adapter; // binds tags to ListView

    public FriendFragment() {
        friendList= new ArrayList<String>();
        //The friend list should come from the server
        friendList.add("Sand king");
        friendList.add("Death knight");
        friendList.add("Lich");
        friendList.add("Eul's Scepter of Divinity");
        friendList.add("Hellfire");
        friendList.add("Axe");
        friendList.add("Blade master");
        friendList.add("Juggernaut");
        friendList.add("Nevermore");
        friendList.add("Necromancer");
        friendList.add("Stygian Desolator");
        friendList.add("Captain");
        friendList.add("Mekansm");
        friendList.add("Pit Lord");
        friendList.add("Huskar");
        friendList.add("Paladin");
        friendList.add("Ironwood Branch");
        friendList.add("Medusa");
        friendList.add("Slithice");
        friendList.add("Zeus");
        friendList.add("Ogre Magi");
        friendList.add("Tresdin");
        friendList.add("Black king bar");
        friendList.add("Spectre");
        friendList.add("Frostmourne");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, friendList);
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
            mListener = (OnFriendFragmentInteractionListener) activity;
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
    public interface OnFriendFragmentInteractionListener {
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
        new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                               int position, long id)
            {
                final String tag = ((TextView) view).getText().toString();

                AlertDialog.Builder builder =
                            new AlertDialog.Builder(getActivity());

                builder.setTitle(
                            getString(R.string.deleteTitle, tag));

                builder.setMessage(R.string.deleteFriend);

                builder.setPositiveButton(R.string.ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id){
                            friendList.remove(friendList.indexOf(tag));
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
