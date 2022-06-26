package com.lg.zavrsnirad.model;

import java.io.File;

public class OglasDTO {
    private Long oglasId;

    private String userToken;
    private String naslov;
    private Long kategorijaId;
    private String opis;

    private String mail;
    private Long cijena;
    private String telefon;
    private String imeProdavaca;
    private String lokacija;

    private byte[] fotografija;

    public byte[] getFotografija() {
        return fotografija;
    }

    public void setFotografija(byte[] fotografija) {
        this.fotografija = fotografija;
    }

    public OglasDTO(){}

    public OglasDTO(String naslov, Long kategorijaId, String opis, String mail, Long cijena, String telefon, String imeProdavaca, String lokacija) {
        this.naslov = naslov;
        this.kategorijaId = kategorijaId;
        this.opis = opis;
        this.mail = mail;
        this.cijena = cijena;
        this.telefon = telefon;
        this.imeProdavaca = imeProdavaca;
        this.lokacija = lokacija;
    }

    public OglasDTO(Long oglasId,String userToken, String naslov, Long kategorijaId, String opis, String mail, Long cijena, String telefon, String imeProdavaca, String lokacija) {
        this.oglasId = oglasId;
        this.userToken = userToken;
        this.naslov = naslov;
        this.kategorijaId = kategorijaId;
        this.opis = opis;
        this.mail = mail;
        this.cijena = cijena;
        this.telefon = telefon;
        this.imeProdavaca = imeProdavaca;
        this.lokacija = lokacija;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getImeProdavaca() {
        return imeProdavaca;
    }

    public void setImeProdavaca(String imeProdavaca) {
        this.imeProdavaca = imeProdavaca;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }
}
