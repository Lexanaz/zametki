package ru;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tags {
    private int idtags;
    private String tag;

    @Id
    @Column(name = "idtags", nullable = false)
    public int getIdtags() {
        return idtags;
    }

    public void setIdtags(int idtags) {
        this.idtags = idtags;
    }

    @Basic
    @Column(name = "tag", nullable = true, length = 45)
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tags tags = (Tags) o;

        if (idtags != tags.idtags) return false;
        if (tag != null ? !tag.equals(tags.tag) : tags.tag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtags;
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }
}
