package com.aurora.ekurban.controller;

import com.aurora.ekurban.dto.HissedarCreateDTO;
import com.aurora.ekurban.dto.HissedarDTO;
import com.aurora.ekurban.service.HissedarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HissedarController {

    @Autowired
    HissedarService hissedarService;

    @GetMapping("/hissedarlar")
    public ResponseEntity<List<HissedarDTO>> getHissedarList() {
        return new ResponseEntity<>(hissedarService.getAllHissedarList(), HttpStatus.OK);
    }

    @GetMapping("/hissedarlar/{id}")
    public ResponseEntity<HissedarDTO> getHissedar(@PathVariable Long id) {
        return new ResponseEntity<>(hissedarService.getHissedarDTO(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HissedarDTO> updateHissedar(@PathVariable Long id, @RequestBody @Valid HissedarCreateDTO hissedarCreateDTO) {
        return new ResponseEntity<>(hissedarService.updateHissedar(id, hissedarCreateDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HissedarCreateDTO> addHissedar(@RequestBody HissedarCreateDTO hissedarCreateDTO) {
        return new ResponseEntity<>(hissedarService.addHissedar(hissedarCreateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteHissedar(@PathVariable Long id) {
        hissedarService.deleteHissedar(id);
    }

    @PostMapping("/kurbanlar/{kurbanId}/hisse")
    public ResponseEntity<HissedarCreateDTO> addHissedar(@PathVariable Long kurbanId, @RequestBody @Valid HissedarCreateDTO hissedarCreateDTO) {
        return new ResponseEntity<>(hissedarService.addHissedar(hissedarCreateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/kurbanlar/{kurbanId}/hissedarlar/{id}")
    public ResponseEntity<Void> deleteHissedar(@PathVariable Long kurbanId, @PathVariable Long hissedarId) {
        hissedarService.deleteHissedar(kurbanId, hissedarId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
