package org.mypro.entity;

public class Collect {
    private Integer id;

    private String novel;

    private Integer novelid;

    private String user;

    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNovel() {
        return novel;
    }

    public void setNovel(String novel) {
        this.novel = novel == null ? null : novel.trim();
    }

    public Integer getNovelid() {
        return novelid;
    }

    public void setNovelid(Integer novelid) {
        this.novelid = novelid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}