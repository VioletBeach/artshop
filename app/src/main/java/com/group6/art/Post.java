package com.group6.art;
import java.util.HashMap;
import java.util.Map;

public class Post {

    public String postname; //게시글 이름
    public String postnum; //게시글 넘버
    public String recommend; //게시글 추천수
    public String point; //게시글 점수
    public String date; // 날짜

    public Post(String postname, String postnum , String recommend , String point , String date) {
        this.postname = postname;
        this.postnum = postnum;
        this.recommend = recommend;
        this.point = point;
        this.date = date;


    }
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("postname", postname);
        result.put("postnum", postnum);
        result.put("recommend", recommend);
        result.put("point", point);
        result.put("date", date);


        return result;
    }





}