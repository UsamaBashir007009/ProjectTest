package com.example.projectphase1.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectphase1.AdapterTasks;
import com.example.projectphase1.ClassTasks;
import com.example.projectphase1.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentTask extends Fragment {
    View view;
    private RecyclerView myRecyclerView;
    private List<ClassTasks> myList;
    public FragmentTask() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=  inflater.inflate(R.layout.fragment_fragment_task,container,false);
        myRecyclerView = view.findViewById(R.id.recycleView_task);
        AdapterTasks recyclerViewAdopter = new AdapterTasks(getContext(),myList);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdopter);
        return  view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myList=new ArrayList<ClassTasks>();
        for (int i=0;i<9;i++)
            myList.add(new ClassTasks(i+1,"ELECTRICIAN"+i,R.drawable.icon_worker));
    }
}
