package com.lg.zavrsnirad.service;

import com.lg.zavrsnirad.model.OglasDTO;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface OglasService {
    List<OglasDTO> findAll();
    Optional<OglasDTO> getOglasById(String idOglas);
    byte[] getPicture(String idOglas) throws IOException;
    List<OglasDTO> getOglasByKategoryId(String idKategorija);
    Optional<OglasDTO> save(OglasDTO command);
    List<OglasDTO> getOglasByUserToken(String userToken);
    void deleteOglasById(String oglasId);
}
