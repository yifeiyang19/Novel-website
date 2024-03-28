package org.mypro.entity;

public class Novelpinglun {
    private Integer id;

    private String novel;

    private Integer novelid;

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