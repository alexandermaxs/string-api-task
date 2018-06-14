package com.epam.task2.entity;

public class HitEntity implements Comparable<HitEntity>{
    private String content;
    private int count = 0;

    public HitEntity(String content){
    this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(HitEntity other) {
        return Integer.compare(this.count, other.count);
    }
}
