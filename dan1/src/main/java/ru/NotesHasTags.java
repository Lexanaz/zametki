package ru;

import javax.persistence.*;

@Entity
@Table(name = "notes_has_tags", schema = "zametki", catalog = "")
public class NotesHasTags {
    private String idnht;
    private Notes notesByNotesIdnotes;

    @Id
    @Column(name = "idnht", nullable = false, length = 45)
    public String getIdnht() {
        return idnht;
    }

    public void setIdnht(String idnht) {
        this.idnht = idnht;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotesHasTags that = (NotesHasTags) o;

        if (idnht != null ? !idnht.equals(that.idnht) : that.idnht != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idnht != null ? idnht.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "notes_idnotes", referencedColumnName = "idnotes", nullable = false)
    public Notes getNotesByNotesIdnotes() {
        return notesByNotesIdnotes;
    }

    public void setNotesByNotesIdnotes(Notes notesByNotesIdnotes) {
        this.notesByNotesIdnotes = notesByNotesIdnotes;
    }
}
