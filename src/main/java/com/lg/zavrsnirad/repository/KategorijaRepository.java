package com.lg.zavrsnirad.repository;

import com.lg.zavrsnirad.model.Kategorija;

import java.util.List;

public interface KategorijaRepository {

    List<Kategorija> findAllKategorije();

}
