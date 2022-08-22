package com.MahSinApi.model.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "POST")
@SequenceGenerator(name = "COST_SEQUENCE",sequenceName = "COST_SEQUENCE",allocationSize = 1)
public class Post {
    @Id@GeneratedValue(strategy = GenerationType.AUTO,generator ="COST_SEQUENCE")
   // @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "TITLE",columnDefinition = "text")
    private String title;
    //@Column(name="ABSTRACT",columnDefinition = "clob")
    @Column(name="ABSTRACT",columnDefinition = "text")
    private String abstractParagraph;
    //@Column(name="PARAGRAPHS",columnDefinition = "clob")
    @Column(name="PARAGRAPHS",columnDefinition = "text")
    private String paragraph;
    @OneToMany(cascade = CascadeType.ALL)@JoinColumn(name = "POST_FK")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ParagraphPic> paragraphPics;
    @Column(name = "STATE",columnDefinition = "text")
    private String state;
    @Column(name="WRITER",columnDefinition = "text")
    private String writer;
    @OneToMany(cascade = CascadeType.ALL)@JoinColumn(name = "POST_FK")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<KeyWords> keyWords;
    @OneToMany(cascade = CascadeType.ALL)@JoinColumn(name = "POST_FK")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Reference> references;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;
    @Version
    private long recordControl;
    @Column(name = "POST_DATE",columnDefinition = "timestamptz",nullable = false)
    private Date date;

    public long getId() {
        return id;
    }

    public Post setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }


    public String getState() {
        return state;
    }

    public Post setState(String state) {
        this.state = state;
        return this;
    }


    public String getWriter() {
        return writer;
    }

    public Post setWriter(String writer) {
        this.writer = writer;
        return this;
    }

    public List<KeyWords> getKeyWords() {
        return keyWords;
    }

    public Post setKeyWords(List<KeyWords> keyWords) {
        this.keyWords = keyWords;
        return this;
    }

    public List<Reference> getReferences() {
        return references;
    }

    public Post setReferences(List<Reference> references) {
        this.references = references;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Post setUser(User user) {
        this.user = user;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public Post setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Post setDate(Date date) {
        this.date = date;
        return this;
    }

    public List<ParagraphPic> getParagraphPics() {
        return paragraphPics;
    }

    public Post setParagraphPics(List<ParagraphPic> paragraphPics) {
        this.paragraphPics = paragraphPics;
        return this;
    }

    public String getAbstractParagraph() {
        return abstractParagraph;
    }

    public Post setAbstractParagraph(String absractParagraph) {
        this.abstractParagraph = absractParagraph;
        return this;
    }

    public String getParagraph() {
        return paragraph;
    }

    public Post setParagraph(String paragraph) {
        this.paragraph = paragraph;
        return this;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", abstractParagraph='" + abstractParagraph + '\'' +
                ", paragraph='" + paragraph + '\'' +
                ", state='" + state + '\'' +
                ", writer='" + writer + '\'' +
                ", keyWords=" + keyWords +
                ", references=" + references +
                ", user=" + user +
                ", recordControl=" + recordControl +
                ", date=" + date +
                '}';
    }
}
