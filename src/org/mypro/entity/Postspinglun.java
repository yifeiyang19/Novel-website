package org.mypro.entity;

public class Postspinglun {
    private Integer id;

    private String posts;

    private Integer postsid;

    private String neirong;

    private String pinglunrenmingzi;

    private Integer pinglunrenid;

    private String pinglunshijian;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts == null ? null : posts.trim();
    }

    public Integer getPostsid() {
        return postsid;
    }

    public void setPostsid(Integer postsid) {
        this.postsid = postsid;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong == null ? null : neirong.trim();
    }

    public String getPinglunrenmingzi() {
        return pinglunrenmingzi;
    }

    public void setPinglunrenmingzi(String pinglunrenmingzi) {
        this.pinglunrenmingzi = pinglunrenmingzi == null ? null : pinglunrenmingzi.trim();
    }

    public Integer getPinglunrenid() {
        return pinglunrenid;
    }

    public void setPinglunrenid(Integer pinglunrenid) {
        this.pinglunrenid = pinglunrenid;
    }

    public String getPinglunshijian() {
        return pinglunshijian;
    }

    public void setPinglunshijian(String pinglunshijian) {
        this.pinglunshijian = pinglunshijian == null ? null : pinglunshijian.trim();
    }
}