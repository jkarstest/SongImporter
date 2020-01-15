package com.jkarstedt.tool.song;

import javax.persistence.*;

@Entity
@Table(name = "TRANSFER_SONGS")
public class Song {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
   private  String title;
   private String inception;
   private String tonality;
   private String category;
   private String remark;
   private String beat;
   private String problem;
   private String epoch;
   private String songWriter;
   private String componist;
   private String tags;


    public Song() {
    }

    public Song(String title, String inception, String tonality, String category, String remark, String beat, String problem, String epoch, String songWriter, String componist, String tags) {


        this.title = title;
        this.inception = inception;
        this.tonality = tonality;
        this.category = category;
        this.remark = remark;
        this.beat = beat;
        this.problem = problem;
        this.epoch = epoch;
        this.songWriter = songWriter;
        this.componist = componist;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", inception='" + inception + '\'' +
                ", tonality='" + tonality + '\'' +
                ", category='" + category + '\'' +
                ", remark='" + remark + '\'' +
                ", beat='" + beat + '\'' +
                ", problem='" + problem + '\'' +
                ", epoch='" + epoch + '\'' +
                ", songWriter='" + songWriter + '\'' +
                ", componist='" + componist + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInception() {
        return inception;
    }

    public void setInception(String inception) {
        this.inception = inception;
    }

    public String getTonality() {
        return tonality;
    }

    public void setTonality(String tonality) {
        this.tonality = tonality;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBeat() {
        return beat;
    }

    public void setBeat(String beat) {
        this.beat = beat;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public String getComponist() {
        return componist;
    }

    public void setComponist(String componist) {
        this.componist = componist;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
