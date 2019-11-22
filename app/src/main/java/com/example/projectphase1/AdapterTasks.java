package com.example.projectphase1;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterTasks extends RecyclerView.Adapter<AdapterTasks.MyViewHolder> {


    Context mcontext;
    List<ClassTasks> jobsClassList;
    EditText text;
    EditText editText;
    Dialog dialog;

    public AdapterTasks(Context mcontext, List<ClassTasks> jobsClassList) {
        this.mcontext = mcontext;
        this.jobsClassList = jobsClassList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mcontext).inflate(R.layout.item_worker_task,parent,false);
        final MyViewHolder myViewHolder=new MyViewHolder(view);

        dialog=new Dialog(mcontext);
        dialog.setContentView(R.layout.dialog_task);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;



        myViewHolder.linearLayout_Job_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             //   TextView rID=(TextView) dialog.findViewById(R.id.rIDd);
                final TextView rName=(TextView) dialog.findViewById(R.id.dialog_task_name);
                ImageView rImage=(ImageView)dialog.findViewById(R.id.job_request_image);
             //   rID.setText(""+jobsClassList.get(myViewHolder.getAdapterPosition()).getJobId());
                rName.setText(""+jobsClassList.get(myViewHolder.getAdapterPosition()).getJobName());
                rImage.setImageResource(jobsClassList.get(myViewHolder.getAdapterPosition()).getJobPhoto());
                dialog.show();
                text=dialog.findViewById(R.id.dialogue_task_detail);
                editText=dialog.findViewById(R.id.dialogue_Task_location);
                final Button dialogueButton=(Button) dialog.findViewById(R.id.dialog_task_btn);
                dialogueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(TextUtils.isEmpty(editText.getText()) ||TextUtils.isEmpty(text.getText()))
                        {
                            Toast.makeText(mcontext,"Enter the proper required details",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(mcontext, "the request for task " + rName.getText() + " has sent", Toast.LENGTH_SHORT).show();
                            dialog.hide();

                            editText.setText("");
                            text.setText("");
                        }
                    }
                });
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.job_name.setText(jobsClassList.get(position).getJobName());
        holder.job_image.setImageResource(jobsClassList.get(position).getJobPhoto());

    }

    @Override
    public int getItemCount() {
        return jobsClassList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private LinearLayout linearLayout_Job_item;
        private TextView job_name;
        private ImageView job_image;
        public MyViewHolder( View itemView) {
            super(itemView);

            linearLayout_Job_item=(LinearLayout)itemView.findViewById(R.id.job_item_id);
            job_name= (TextView)itemView.findViewById(R.id.job_namee_id);
            job_image= (ImageView) itemView.findViewById(R.id.job_item_imagee);

        }
    }
}
