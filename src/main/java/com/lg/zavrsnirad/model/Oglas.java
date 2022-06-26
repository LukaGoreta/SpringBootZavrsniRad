package com.lg.zavrsnirad.model;

import javax.persistence.*;
import java.io.File;

@Entity
public class Oglas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oglasId;
    private Long kategorijaId;
    private String userToken;
    private String naslov;
    private String opis;
    private String lokacija;
    private Long cijena;
    private String telefon;
    private String mail;
    private String imeProdavaca;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] fotografije;


    public Oglas( String naslov, String opis, byte[] fotografije) {
        this.naslov = naslov;
        this.opis = opis;
        this.fotografije = fotografije;
    }

    public Oglas(Long kategorijaId,String userToken, String naslov, String opis, String lokacija, Long cijena, String telefon, String mail, String imeProdavaca, byte[] fotografije) {
        this.kategorijaId = kategorijaId;
        this.userToken = userToken;
        this.naslov = naslov;
        this.opis = opis;
        this.lokacija = lokacija;
        this.cijena = cijena;
        this.telefon = telefon;
        this.mail = mail;
        this.imeProdavaca = imeProdavaca;
        this.fotografije = fotografije;
    }

    public Oglas() {

    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public Long getOglasId() {
        return oglasId;
    }

    public void setOglasId(Long oglasId) {
        this.oglasId = oglasId;
    }

    public Long getKategorijaId() {
        return kategorijaId;
    }

    public void setKategorijaId(Long kategorijaId) {
        this.kategorijaId = kategorijaId;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public Long getCijena() {
        return cijena;
    }

    public void setCijena(Long cijena) {
        this.cijena = cijena;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getImeProdavaca() {
        return imeProdavaca;
    }

    public void setImeProdavaca(String imeProdavaca) {
        this.imeProdavaca = imeProdavaca;
    }

    public byte[] getFotografije() {
        return fotografije;
    }

    public void setFotografije(byte[] fotografije) {
        this.fotografije = fotografije;
    }
}
