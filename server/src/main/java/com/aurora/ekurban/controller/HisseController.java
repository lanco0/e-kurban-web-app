package com.aurora.ekurban.controller;

import com.aurora.ekurban.dto.HisseCreateDTO;
import com.aurora.ekurban.service.HisseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hisse")
public class HisseController {

    @Autowired
    HisseService hisseService;

    @PostMapping
    public ResponseEntity<HisseCreateDTO> addHisse(@RequestBody HisseCreateDTO hisseCreateDTO) {
        return new ResponseEntity<>(hisseService.addHisse(hisseCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HisseCreateDTO> updateHisse(@PathVariable Long hisseId, @RequestBody HisseCreateDTO hisseCreateDTO) {
        return new ResponseEntity<>(hisseService.updateHisse(hisseId, hisseCreateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHisse(@PathVariable Long hisseId) {
        hisseService.deleteHissedarOnHisse(hisseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
