package com.lg.zavrsnirad.repository;

import com.lg.zavrsnirad.model.Kategorija;
import com.lg.zavrsnirad.model.Oglas;
import com.lg.zavrsnirad.model.OglasDTO;
import com.lg.zavrsnirad.service.KategorijaService;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.StreamUtils;

import javax.xml.transform.Result;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Primary
@Repository
public class MysqlOglasRepositroy  implements OglasRepository, KategorijaRepository {

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert jdbcInsert;

    public MysqlOglasRepositroy(JdbcTemplate jdbc){
        this.jdbc = jdbc;
        this.jdbcInsert = new SimpleJdbcInsert(jdbc).withTableName("oglas").usingGeneratedKeyColumns("id");
    }


    @Override
    public byte[] getPicture(String oglasId) throws IOException {

        byte[] picture = null;

        try {
            picture = jdbc.queryForObject("SELECT fotografije FROM oglas WHERE oglas_id = " + oglasId, ((rs, rowNum) -> rs.getBytes(1)));
        }catch (Exception e){
            e.printStackTrace();
        }


        if(picture != null){
            return picture;
        }else{

        var imgFile = new ClassPathResource("NemaSlike.png");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return bytes;}

    }

    @Override
    public List<Oglas> findAll() {
        return jdbc.query("select * from oglas", this::mapRowToOglas);
    }

    private Oglas mapRowToOglas(ResultSet rs, int rowNum)throws SQLException{
        Oglas oglas = new Oglas();
        oglas.setOglasId(Long.valueOf(rs.getString("oglas_id")));
        oglas.setUserToken(rs.getString("user_token"));
        oglas.setCijena(Long.valueOf(rs.getString("cijena")));
        oglas.setFotografije(rs.getBytes("fotografije"));
        oglas.setImeProdavaca(rs.getString("ime_prodavaca"));
        oglas.setKategorijaId(Long.valueOf(rs.getString("kategorija_id")));
        oglas.setLokacija(rs.getString("lokacija"));
        oglas.setMail(rs.getString("mail"));
        oglas.setNaslov(rs.getString("naslov"));
        oglas.setOpis(rs.getString("opis"));
        oglas.setTelefon(rs.getString("telefon"));

        return oglas;
    }

    @Override
    public Optional<Oglas> getOglasById(String idOglas) {
        return Optional.of(jdbc.queryForObject("SELECT * FROM oglas WHERE oglas_id = ?", this::mapRowToOglas, idOglas));
    }

    @Override
    public void deleteOglasById(String oglasId) {
         jdbc.update("delete from oglas where oglas_id = ?",oglasId);
    }


    @Override
    public List<Oglas> getOglasByKategoryId(String kategorijaId) {
        return jdbc.query("SELECT * FROM OGLAS WHERE kategorija_id = ?", this::mapRowToOglas, kategorijaId);

    }

    @Override
    public List<Oglas> getOglasByUserToken(String userToken) {
        return jdbc.query("SELECT * FROM OGLAS WHERE user_token = ?", this::mapRowToOglas, userToken);
    }

    @Override
    public List<Kategorija> findAllKategorije() {
        return jdbc.query("select * from kategorija", this::mapRowToKategorija);
    }

    private Kategorija mapRowToKategorija(ResultSet rs, int rowNum)throws SQLException{
        Kategorija kategorija = new Kategorija();
        kategorija.setIdKategorije(Long.valueOf(rs.getString("id_kategorije")));
        kategorija.setNazivKategorije(rs.getString("naziv_kategorije"));
        return kategorija;
    }

    @Override
    public Optional<Oglas> save(Oglas oglas) {
        Map<String, Object> values = new HashMap<>();

        values.put("user_token",oglas.getUserToken());
        values.put("naslov",oglas.getNaslov());
        values.put("opis",oglas.getOpis());
        values.put("fotografije",oglas.getFotografije());
        values.put("cijena",oglas.getCijena());
        values.put("ime_prodavaca",oglas.getCijena());
        values.put("kategorija_id",oglas.getKategorijaId());
        values.put("lokacija",oglas.getLokacija());
        values.put("mail",oglas.getMail());
        values.put("telefon",oglas.getTelefon());

        jdbcInsert.executeAndReturnKey(values).longValue();
        return Optional.of(oglas);
    }




}
