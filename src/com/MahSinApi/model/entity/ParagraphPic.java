package com.MahSinApi.model.entity;

import javax.persistence.*;
import java.io.File;
import java.util.List;

@Entity(name = "PARAGRAPH_PIC")
public class ParagraphPic {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Version
    private long recordControl;


    public long getId() {
        return id;
    }

    public ParagraphPic setId(long id) {
        this.id = id;
        return this;
    }



    public long getRecordControl() {
        return recordControl;
    }

    public ParagraphPic setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    @Override
    public String toString() {
        return "ParagraphPic{" +
                "id=" + id +
                ", recordControl=" + recordControl +
                '}';
    }
}
