package com.lg.zavrsnirad.model;

import javax.persistence.*;

@Entity
public class Kategorija{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idKategorije;
    private String nazivKategorije;

    public Long getIdKategorije() {
        return idKategorije;
    }

    public void setIdKategorije(Long idKategorije) {
        this.idKategorije = idKategorije;
    }

    public String getNazivKategorije() {
        return nazivKategorije;
    }

    public void setNazivKategorije(String nazivKategorije) {
        this.nazivKategorije = nazivKategorije;
    }
}
