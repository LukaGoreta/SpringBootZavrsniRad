package com.lg.zavrsnirad.repository;

import com.lg.zavrsnirad.model.Oglas;
import com.lg.zavrsnirad.model.OglasDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface OglasRepository {
    List<Oglas> findAll();
    byte[] getPicture(String idOglas) throws IOException;
    Optional<Oglas> getOglasById(String idOglas);
    List<Oglas> getOglasByKategoryId(String kategorijaId);
    Optional<Oglas> save(Oglas oglas);
    List<Oglas> getOglasByUserToken(String userToken);
    void deleteOglasById(String oglasId);
}
