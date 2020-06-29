package com.group6.art;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DummyAdapter extends RecyclerView.Adapter<DummyAdapter.DummyViewHolder> {

    ArrayList<DummyItem> dummyList;
    Context dummyContext;

    public DummyAdapter(ArrayList<DummyItem> dummyList, Context dummyContext) {
        this.dummyList = dummyList;
        this.dummyContext = dummyContext;
    }

    @NonNull
    @Override
    public DummyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dummy, parent, false);
        return new DummyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DummyViewHolder holder, int position) {
        DummyItem dummyItem = dummyList.get(position);

        holder.imgDummyHeader.setImageResource(dummyItem.getIntDummyImage());
        holder.tvDummyTitle.setText(dummyItem.getStrDummyTitle());
        holder.tvDummySubtitle.setText(dummyItem.getStrDummySubtitle());
        holder.tvDummyscore.setText(dummyItem.getStrDummyScore());
        holder.tvDummyWriter.setImageResource(dummyItem.getIntDummyWriter());

        if(position==0) {
            holder.tvDummyscore.setBackgroundResource(R.drawable.medal_stroke);
        }
        if(position==1) {
            holder.tvDummyscore.setBackgroundResource(R.drawable.medal_stroke2);
        }
        if(position==2) {
            holder.tvDummyscore.setBackgroundResource(R.drawable.medal_stroke3);
        }

    }

    @Override
    public int getItemCount() {
        return dummyList.size();
    }

    class DummyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgDummyHeader,tvDummyWriter;
        TextView tvDummyTitle, tvDummySubtitle;
        Button tvDummyscore;


        public DummyViewHolder(@NonNull View itemView) {

            super(itemView);

            imgDummyHeader = itemView.findViewById(R.id.img_dummy);
            tvDummyTitle = itemView.findViewById(R.id.tv_dummy_title);
            tvDummySubtitle = itemView.findViewById(R.id.tv_dummy_subtitle);
            tvDummyscore = itemView.findViewById(R.id.tv_dummy_score);
            tvDummyWriter = itemView.findViewById(R.id.tv_dummy_writer);



/*
                StorageReference ref = FirebaseStorage.getInstance().getReference("images/20200603_1820.png"); //파이어베이스에서 이미지 값 가져오기
                // Download directly from StorageReference using Glide
                // (See MyAppGlideModule for Loader registration)

                Glide.with(itemView) // 프래그먼트 지정
                        .load(ref) // 이미지 주소 가져오기 ref값
                        .into(imgDummyHeader); // 해당 이미지뷰에 load값 출력




*/
            //

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION)
                    {


                        }

                        //
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        Bitmap bitmap = ((BitmapDrawable)imgDummyHeader.getDrawable()).getBitmap();
                        float scale = (float) (512/(float)bitmap.getWidth());
                        int image_w = (int) (bitmap.getWidth() * scale);
                        int image_h = (int) (bitmap.getHeight() * scale);
                        Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                        resize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                        byte[] byteArray = stream.toByteArray();
                        //

                        ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
                        Bitmap bitmap1 = ((BitmapDrawable)tvDummyWriter.getDrawable()).getBitmap();
                        float scale1 = (float) (512/(float)bitmap1.getWidth());
                        int image_w1 = (int) (bitmap1.getWidth() * scale1);
                        int image_h1 = (int) (bitmap1.getHeight() * scale1);
                        Bitmap resize1 = Bitmap.createScaledBitmap(bitmap1, image_w1, image_h1, true);
                        resize1.compress(Bitmap.CompressFormat.PNG, 100, stream1);
                        byte[] byteArray1 = stream1.toByteArray();
                        //
                        Intent intent=new Intent(dummyContext,WorkLook.class);

                        intent.putExtra("title", tvDummyTitle.getText().toString());
                        intent.putExtra("writer", tvDummySubtitle.getText().toString());
                        intent.putExtra("score", tvDummyscore.getText().toString());
                        intent.putExtra("image", byteArray);
                        intent.putExtra("writerimage", byteArray1);
                        //
                        dummyContext.startActivity(intent);
                        // click event
                    }
            });
            //

        }
    }


}