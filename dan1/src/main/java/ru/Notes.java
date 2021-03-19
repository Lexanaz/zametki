package ru;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Notes {
    private int idnotes;
    private String notename;
    private String content;

    @Id
    @Column(name = "idnotes", nullable = false)
    public int getIdnotes() {
        return idnotes;
    }

    public void setIdnotes(int idnotes) {
        this.idnotes = idnotes;
    }

    @Basic
    @Column(name = "notename", nullable = true, length = 45)
    public String getNotename() {
        return notename;
    }

    public void setNotename(String notename) {
        this.notename = notename;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 45)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notes notes = (Notes) o;

        if (idnotes != notes.idnotes) return false;
        if (notename != null ? !notename.equals(notes.notename) : notes.notename != null) return false;
        if (content != null ? !content.equals(notes.content) : notes.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idnotes;
        result = 31 * result + (notename != null ? notename.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
