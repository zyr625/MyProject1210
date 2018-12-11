package com.example.lenovo.myproject1210;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Cache {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String time;
    private String content;
    private String simple;
    private String simple_pic;
    @Generated(hash = 444997658)
    public Cache(Long id, String name, String time, String content, String simple,
            String simple_pic) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.content = content;
        this.simple = simple;
        this.simple_pic = simple_pic;
    }
    @Generated(hash = 1305017356)
    public Cache() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getSimple() {
        return this.simple;
    }
    public void setSimple(String simple) {
        this.simple = simple;
    }
    public String getSimple_pic() {
        return this.simple_pic;
    }
    public void setSimple_pic(String simple_pic) {
        this.simple_pic = simple_pic;
    }
    
}
