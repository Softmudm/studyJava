package com.sz.wx.model;

public class ScorePaper {

    private Integer scoreid;

    private Integer paperid;

    private String papername;

    private String remarks;

    private Integer score;

    private Integer rights;

    private Integer errors;

    public Integer getScoreid() {
        return scoreid;
    }

    public void setScoreid(Integer scoreid) {
        this.scoreid = scoreid;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getRights() {
        return rights;
    }

    public void setRights(Integer rights) {
        this.rights = rights;
    }

    public Integer getErrors() {
        return errors;
    }

    public void setErrors(Integer errors) {
        this.errors = errors;
    }
}
