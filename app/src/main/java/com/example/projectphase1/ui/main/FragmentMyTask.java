package com.example.projectphase1.ui.main;

import android.app.ActionBar;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectphase1.AdapterMyTasks;
import com.example.projectphase1.ClassMyTask;
import com.example.projectphase1.HomePageTabScreen;
import com.example.projectphase1.R;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FragmentMyTask extends Fragment {
    View view;
    private RecyclerView myRecyclerView;
    private List<ClassMyTask> myList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=  inflater.inflate(R.layout.fragment_fragment_my_task,container,false);
        myRecyclerView = view.findViewById(R.id.recycleView_myTask);
        AdapterMyTasks recyclerViewAdopter = new AdapterMyTasks(getContext(),myList);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdopter);
        return  view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myList = new ArrayList<ClassMyTask>();
        for (int i = 0; i < 9; i++) {

            if(i%2==0)
                myList.add(new ClassMyTask(i + 1, 1, "Electrician", 2, 1220, getDate(), "Lahore", R.drawable.icon_worker));
            else
                myList.add(new ClassMyTask(i + 1, 2, "CarPainter", 1, 900, getDate(), "Karachi", R.drawable.icon_worker));

        }

    }

    public String getDate()
    {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);
        return formattedDate;
    }
}
