package com.example.projectphase1;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterMyTasks extends RecyclerView.Adapter<AdapterMyTasks.MyViewHolder2> {


    Context mcontext;
    List<ClassMyTask> myTasksClassList;
    Dialog dialog;

    public AdapterMyTasks(Context mcontext, List<ClassMyTask> jobsClassList) {
        this.mcontext = mcontext;
        this.myTasksClassList = jobsClassList;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mcontext).inflate(R.layout.item_my_task,parent,false);
        final MyViewHolder2 myViewHolder=new MyViewHolder2(view);

        dialog=new Dialog(mcontext);
        dialog.setContentView(R.layout.dialog_mytask);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;


        myViewHolder.linearLayout_Job_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView task_dialogue_ID=(TextView) dialog.findViewById(R.id.dialogue_myTask_taskid);
                TextView task_dialogue_Jobname=(TextView) dialog.findViewById(R.id.mytask_dialogue_name);
                TextView task_dialogue_job_id=(TextView) dialog.findViewById(R.id.dialogue_myTask_jobid);
                ImageView task_dialogue_image=(ImageView)dialog.findViewById(R.id.mytask_dialogue_image);
                TextView task_dialogue_location=(TextView) dialog.findViewById(R.id.dialogue_myTask_Location);
                TextView task_dialogue_bill=(TextView) dialog.findViewById(R.id.dialogue_myTask_bill);
                TextView task_dialogue_date=(TextView) dialog.findViewById(R.id.dialogue_myTask_date);
                TextView task_dialogue_UID=(TextView) dialog.findViewById(R.id.dialogue_myTask_Userid);

                task_dialogue_bill.setText(""+myTasksClassList.get(myViewHolder.getAdapterPosition()).getTaskBill());
                task_dialogue_date.setText(""+myTasksClassList.get(myViewHolder.getAdapterPosition()).getTaskDate());
                task_dialogue_ID.setText(""+myTasksClassList.get(myViewHolder.getAdapterPosition()).getTaskId());
                task_dialogue_job_id.setText(""+myTasksClassList.get(myViewHolder.getAdapterPosition()).getTask_job_id());
                task_dialogue_Jobname.setText(""+myTasksClassList.get(myViewHolder.getAdapterPosition()).getTask_Job_Name());
                task_dialogue_location.setText(""+myTasksClassList.get(myViewHolder.getAdapterPosition()).getTaskLocation());
                task_dialogue_UID.setText(""+myTasksClassList.get(myViewHolder.getAdapterPosition()).getUserId());
                task_dialogue_image.setImageResource(myTasksClassList.get(myViewHolder.getAdapterPosition()).getTaskImage());


                dialog.show();


                Button dialogueButton=(Button) dialog.findViewById(R.id.dialog_mytask_btn);
                dialogueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.hide();
                    }
                });

            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMyTasks.MyViewHolder2 holder, int position) {
        holder.task_name.setText(myTasksClassList.get(position).getTask_Job_Name());
        holder.task_image.setImageResource(myTasksClassList.get(position).getTaskImage());

        int status = myTasksClassList.get(position).getUserId();

        if(status==1)
        {
            holder.task_status.setText("On Going");
            holder.task_status.setTextColor(Color.rgb(0,200,0));
        }

        else
        {
            holder.task_status.setText("Completed");
            holder.task_status.setTextColor(Color.rgb(0,0,200));
        }

    }

    @Override
    public int getItemCount() {
        return myTasksClassList.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder
    {
        private LinearLayout linearLayout_Job_item;
        private TextView task_name;
        private ImageView task_image;
        private TextView task_status;
        public MyViewHolder2( View itemView) {
            super(itemView);

            linearLayout_Job_item=(LinearLayout)itemView.findViewById(R.id.mytask_item_id);
            task_name= (TextView)itemView.findViewById(R.id.task_item_name);
            task_image= (ImageView) itemView.findViewById(R.id.task_item_image);
            task_status= (TextView)itemView.findViewById(R.id.status);
        }
    }
}
