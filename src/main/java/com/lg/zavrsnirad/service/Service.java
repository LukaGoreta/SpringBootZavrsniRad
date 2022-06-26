package com.lg.zavrsnirad.service;

import com.lg.zavrsnirad.model.Kategorija;
import com.lg.zavrsnirad.model.Oglas;
import com.lg.zavrsnirad.model.OglasDTO;
import com.lg.zavrsnirad.repository.KategorijaRepository;
import com.lg.zavrsnirad.repository.OglasRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service implements OglasService, KategorijaService{
    private final OglasRepository oglasRepository;
    private final KategorijaRepository kategorijaRepository;
    public Service(OglasRepository oglasRepository, KategorijaRepository kategorijaRepository) {
        this.oglasRepository = oglasRepository;
        this.kategorijaRepository = kategorijaRepository;
    }

    @Override
    public List<OglasDTO> findAll() {
        return oglasRepository.findAll().stream().map(this::mapOglasToDTO).collect(Collectors.toList());
    }
    private OglasDTO mapOglasToDTO(final Oglas oglas){
        return new OglasDTO(oglas.getOglasId(),
                            oglas.getUserToken(),
                            oglas.getNaslov(),
                            oglas.getKategorijaId(),
                            oglas.getOpis(),
                            oglas.getMail(),
                            oglas.getCijena(),
                            oglas.getTelefon(),
                            oglas.getImeProdavaca(),
                            oglas.getLokacija()
                );
    }

    @Override
    public byte[] getPicture(String idOglas) throws IOException {
        return oglasRepository.getPicture(idOglas);
    }

    @Override
    public Optional<OglasDTO> getOglasById(String idOglas) {
        return oglasRepository.getOglasById(idOglas).map(this::mapOglasToDTO);
    }

    @Override
    public void deleteOglasById(String oglasId) {
        oglasRepository.deleteOglasById(oglasId);
    }

    @Override
    public List<Kategorija> findAllKategorije() {
        return kategorijaRepository.findAllKategorije();
    }

    @Override
    public List<OglasDTO> getOglasByKategoryId(String idKategorija) {
        return oglasRepository.getOglasByKategoryId(idKategorija).stream().map(this::mapOglasToDTO).collect(Collectors.toList());
    }

    @Override
    public List<OglasDTO> getOglasByUserToken(String userToken) {
        return oglasRepository.getOglasByUserToken(userToken).stream().map(this::mapOglasToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<OglasDTO> save(OglasDTO oglasDTO) {
        return oglasRepository.save(mapCommandToOglas(oglasDTO)).map(this::mapOglasToDTO);
    }
    private Oglas mapCommandToOglas(final OglasDTO oglasDTO){
        return new Oglas(oglasDTO.getKategorijaId(),oglasDTO.getUserToken(),oglasDTO.getNaslov(),oglasDTO.getOpis(),oglasDTO.getLokacija(),oglasDTO.getCijena(),oglasDTO.getTelefon(),oglasDTO.getMail(),oglasDTO.getImeProdavaca(),oglasDTO.getFotografija());
    }

}
