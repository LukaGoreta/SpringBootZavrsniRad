package com.lg.zavrsnirad.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lg.zavrsnirad.model.OglasDTO;
import com.lg.zavrsnirad.service.OglasService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("oglas")
@CrossOrigin(origins = "http://localhost:4200")
public class OglasController {

    public final OglasService oglasService;

    public OglasController(OglasService oglasService){this.oglasService = oglasService;}

    @GetMapping
    public List<OglasDTO> getAll(){
        return oglasService.findAll();
    }

    @RequestMapping(value = "/slika/{idOglas}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable @RequestBody final String idOglas) throws IOException {

        byte[] image = oglasService.getPicture(idOglas);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image);
    }

    @GetMapping("/{idOglas}")
    public Optional<OglasDTO> getOglasById(@PathVariable final String idOglas){
        return oglasService.getOglasById(idOglas);
    }


    @GetMapping("/kategorija/{idKategorija}")
    public List<OglasDTO> getOglasByKategoryId(@PathVariable @RequestBody final String idKategorija){
        return oglasService.getOglasByKategoryId(idKategorija);
    }

    @GetMapping("/user/{userToken}")
    public List<OglasDTO> getOglasByUserToken(@PathVariable @RequestBody final String userToken){
        return oglasService.getOglasByUserToken(userToken);
    }

    @DeleteMapping("/obrisi/{oglasId}")
    public void delete(@PathVariable String oglasId){
        oglasService.deleteOglasById(oglasId);//.map(
//         ResponseEntity.status(HttpStatus.OK).body(oglasId));
    }



//    @PostMapping
//    public ResponseEntity<OglasDTO> save(@ModelAttribute  final OglasDTO command){
//        return oglasService.save(command)
//                .map(
//                        vaccineDTO -> ResponseEntity
//                                .status(HttpStatus.CREATED)
//                                .body(vaccineDTO)
//                )
//                .orElseGet(
//                        () -> ResponseEntity
//                                .status(HttpStatus.CONFLICT)
//                                .build()
//                );
//    }

  @PostMapping
    public ResponseEntity<OglasDTO> save(@RequestParam("model") String model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        System.out.println(model);
        System.out.println(file.getBytes().length);

        ObjectMapper mapper = new ObjectMapper();

        OglasDTO oglasDTO = mapper.readValue(model,OglasDTO.class);

        System.out.println(oglasDTO.getNaslov()+" "+oglasDTO.getOpis()+" "+ oglasDTO.getLokacija());


        try {
            oglasDTO.setFotografija(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        oglasService.save(oglasDTO);


        System.out.println("Dosli smo do kraja metode");
        return null;
    }
}
