package com.aurora.ekurban.controller;

import com.aurora.ekurban.dto.HisseCreateDTO;
import com.aurora.ekurban.dto.HisseDTO;
import com.aurora.ekurban.dto.KurbanDTO;
import com.aurora.ekurban.service.HisseService;
import com.aurora.ekurban.service.KurbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hisseler")
public class HisseController {

    @Autowired
    HisseService hisseService;
    @Autowired
    KurbanService kurbanService;

    @PostMapping
    public ResponseEntity<KurbanDTO> addHisse(@RequestBody HisseCreateDTO hisseCreateDTO) {
        hisseService.addHisse(hisseCreateDTO);
        return new ResponseEntity<>(kurbanService.getKurbanDTO(hisseCreateDTO.getKurbanId()), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HisseDTO> updateHisse(@PathVariable Long hisseId, @RequestBody HisseCreateDTO hisseCreateDTO) {
        return new ResponseEntity<>(hisseService.updateHisse(hisseId, hisseCreateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHisse(@PathVariable Long hisseId) {
        hisseService.deleteHissedarOnHisse(hisseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
