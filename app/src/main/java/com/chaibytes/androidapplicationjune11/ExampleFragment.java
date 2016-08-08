package com.chaibytes.androidapplicationjune11;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExampleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExampleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExampleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ExampleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExampleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExampleFragment newInstance(String param1, String param2) {
        ExampleFragment fragment = new ExampleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(getActivity(), "ExampleFragment.onCreate()", Toast.LENGTH_LONG).show();

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Toast.makeText(getActivity(), "ExampleFragment.onCreateView()", Toast.LENGTH_LONG).show();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    // Change the Uri instead to take simple arguments
    public void onButtonPressed(String textEntered) {
        if (mListener != null) {
            //Toast.makeText(getActivity(), "ExampleFragment.onButtonPressed()", Toast.LENGTH_LONG).show();
            mListener.onFragmentInteraction(textEntered);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Toast.makeText(getActivity(), "ExampleFragment.onAttach()", Toast.LENGTH_LONG).show();

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //Toast.makeText(getActivity(), "ExampleFragment.onDetach()", Toast.LENGTH_LONG).show();
        mListener = null;
    }

    @Override
    public void onStart() {
        super.onStart();

        //Toast.makeText(getActivity(), "ExampleFragment.onStart()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();

        //Toast.makeText(getActivity(), "ExampleFragment.onResume()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPause() {
        super.onPause();

        //Toast.makeText(getActivity(), "ExampleFragment.onPause()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStop() {
        super.onStop();

        //Toast.makeText(getActivity(), "ExampleFragment.onStop()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //Toast.makeText(getActivity(), "ExampleFragment.onDestroy()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroy();

        //Toast.makeText(getActivity(), "ExampleFragment.onDestroy()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onDestroy();
        //Toast.makeText(getActivity(), "ExampleFragment.onActivityCreated()", Toast.LENGTH_LONG).show();

        final EditText nameEditText = (EditText) getView().findViewById(R.id.enterName);

        // Press button and call the onButtonPressed function
        Button pressBtn = (Button) getView().findViewById(R.id.button_fragment);
        pressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    String name = nameEditText.getText().toString();
                    mListener.onFragmentInteraction(name);
                }
            }
        });
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String text);
    }
}
