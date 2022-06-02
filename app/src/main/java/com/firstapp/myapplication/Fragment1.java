package com.firstapp.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {

    private EditText editText;
    private Button button;
    private Button buttonAdd;
    private FragmentBListener listener;
    private ArrayAdapter<String> adapter ;

    public List<String> qoutes = new ArrayList<>();;


    ListView listView;

    public interface FragmentBListener {
        void onInputBSent(CharSequence input);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        super.onCreateView(inflater,container,savedInstanceState);

        View v =  (ViewGroup)inflater.inflate(R.layout.fragment1,container,false);

        editText = v.findViewById(R.id.edit_text);
        button = v.findViewById(R.id.button_ok);
        buttonAdd = v.findViewById(R.id.button_add);



        listView = v.findViewById(R.id.listViewElement);

        ArrayList<String> userArrayList = new ArrayList<>();


        userArrayList.add(("London"));
        userArrayList.add("Kiev");
        userArrayList.add("Warszawa");



        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, userArrayList);

        listView.setAdapter(adapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable input = (Editable)editText.getText();
                String newString = input.toString();
                listener.onInputBSent(newString);


            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                userArrayList.add((text));
                qoutes.add(text);
                listView.setAdapter(adapter);
                editText.setText("");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                String str = listView.getItemAtPosition(position).toString();
                listener.onInputBSent(str);
            }
        });

        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentBListener){
            listener = (FragmentBListener) context;
        } else {
            throw new RuntimeException(context.toString() + "imp interf");
        }
    }
    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }


}
