package ru;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
    private int idusers;
    private String fio;
    private String number;

    @Id
    @Column(name = "idusers", nullable = false)
    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    @Basic
    @Column(name = "fio", nullable = true, length = 45)
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "number", nullable = true, length = 45)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (idusers != users.idusers) return false;
        if (fio != null ? !fio.equals(users.fio) : users.fio != null) return false;
        if (number != null ? !number.equals(users.number) : users.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idusers;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
