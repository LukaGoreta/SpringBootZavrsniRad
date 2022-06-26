package com.lg.zavrsnirad.controller;

import com.lg.zavrsnirad.model.Kategorija;
import com.lg.zavrsnirad.model.OglasDTO;
import com.lg.zavrsnirad.service.KategorijaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("kategorija")
@CrossOrigin(origins = "http://localhost:4200")
public class KategorijaController {

    public final KategorijaService kategorijaService;

    public KategorijaController(KategorijaService kategorijaService) {
        this.kategorijaService = kategorijaService;
    }

    @GetMapping
    public List<Kategorija> getAll(){
        return kategorijaService.findAllKategorije();
    }

}
