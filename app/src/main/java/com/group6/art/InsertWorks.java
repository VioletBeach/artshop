package com.group6.art;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InsertWorks extends AppCompatActivity {
    long postcount;
    String poname;

    DatabaseReference mDBReference, postref  = null;
    HashMap<String, Object> childUpdates = null;
    Map<String, Object> userValue = null;
    Post post = null;
    List<Post> datas = new ArrayList<>();

    ImageView insertImage,backImage,logo;
    Button insertWorksCancel,insertWorksFinish;
    EditText insertWorksEdit;
    //
    private final String IMG_FILE_PATH = "imgfilepath";
    private final String IMG_TITLE = "imgtitle";
    private final String IMG_ORIENTATION = "imgorientation";
    private final int REQ_CODE_SELECT_IMAGE = 1001;
    private String mImgPath = null;
    private String mImgTitle = null;
    private String mImgOrient = null;
    //


    private static final String TAG = "MainActivity";

    private Button btChoose;
    private Button btUpload;
    private ImageView ivPreview;

    private Uri filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_works);
        insertImage=(ImageView)findViewById(R.id.insert_works_image);
        backImage=(ImageView)findViewById(R.id.back_image);
        logo=(ImageView)findViewById(R.id.logo);
        insertWorksFinish=(Button) findViewById(R.id.insert_works_finish);
        insertWorksCancel=(Button)findViewById(R.id.insert_works_cancel);
        insertWorksEdit=(EditText)findViewById(R.id.insert_works_edit);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ivPreview = (ImageView) findViewById(R.id.insert_works_image);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        insertImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //갤러리 접근해서 서버에 이미지 올리는 코드
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "이미지를 선택하세요."), 0);
            }
        });


        insertWorksCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        insertWorksFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (insertWorksEdit.getText().toString().equals("")) {
                    Toast.makeText(InsertWorks.this, "작품명을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(InsertWorks.this, insertWorksEdit.getText().toString() + " 등록완료", Toast.LENGTH_SHORT).show();
                    uploadFile();
                    finish();
                }
            }
        });


    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        //request코드가 0이고 OK를 선택했고 data에 뭔가가 들어 있다면
        if (requestCode == 0 && resultCode == RESULT_OK) {
            filePath = data.getData();
            Log.d(TAG, "uri:" + String.valueOf(filePath));
            try {
                //Uri 파일을 Bitmap으로 만들어서 ImageView에 집어 넣는다.
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                ivPreview.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void uploadFile() {
        //업로드할 파일이 있으면 수행
        if (filePath != null) {

            //storage
            FirebaseStorage storage = FirebaseStorage.getInstance();

            //Unique한 파일명을 만들기
            poname = insertWorksEdit.getText().toString().trim();

            String filename = poname + ".png";
            //storage 주소와 폴더 파일명을 지정해 준다.
            StorageReference storageRef = storage.getReferenceFromUrl("gs://server-1d2e3.appspot.com").child("images/" + filename);
            //올라가거라...
            storageRef.putFile(filePath)
                    //성공시
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(getApplicationContext(), "업로드 완료!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    //실패시
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "업로드 실패!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    //진행중
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            @SuppressWarnings("VisibleForTests") //이걸 넣어 줘야 아랫줄에 에러가 사라진다.
                                    double progress = (100 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                            //dialog에 진행률을 퍼센트로 출력해 준다
                        }
                    });

            mDBReference = FirebaseDatabase.getInstance().getReference();


            postref = FirebaseDatabase.getInstance().getReference().child("posts");


            Query recentPostsQuery = postref.orderByChild("postnum");


            recentPostsQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    long numChildren = dataSnapshot.getChildrenCount();
                    String value = dataSnapshot.getValue().toString();
                    Log.d("Database", "Value is: " + value);
                    postcount = numChildren;
                    System.out.println(" == " + numChildren);
                    Log.d("Database", "Value is: " + numChildren);

                    DatabaseReference hopperRef = postref.child(poname);
                    Map<String, Object> hopperUpdates = new HashMap<>();
                    hopperUpdates.put("postnum", Long.toString(postcount));
                    hopperRef.updateChildren(hopperUpdates);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {}
            });

            childUpdates = new HashMap<>();
            if(true){
                post = new Post(poname, Long.toString(postcount), "0","0","20171447");
                userValue = post.toMap();
            }

            childUpdates.put("/posts/" + poname, userValue);

            mDBReference.updateChildren(childUpdates);



        } else {
            Toast.makeText(getApplicationContext(), "파일을 먼저 선택하세요.", Toast.LENGTH_SHORT).show();
        }
    }


}
