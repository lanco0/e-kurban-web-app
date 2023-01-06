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
@RequestMapping("/api/v1/hissedarlar")
public class HissedarController {

    @Autowired
    HissedarService hissedarService;

    @GetMapping
    public ResponseEntity<List<HissedarDTO>> getHissedarList() {
        return new ResponseEntity<>(hissedarService.getAllHissedarList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HissedarDTO> getHissedar(@PathVariable Long id) {
        return new ResponseEntity<>(hissedarService.getHissedarDTO(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HissedarDTO> addHissedar(@RequestBody @Valid HissedarCreateDTO hissedarCreateDTO) throws IllegalArgumentException {
        try {
            Long hissedarId = hissedarService.addHissedar(hissedarCreateDTO);
            return new ResponseEntity<>(hissedarService.getHissedarDTO(hissedarId), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<HissedarDTO> updateHissedar(@PathVariable Long id, @RequestBody @Valid HissedarCreateDTO hissedarCreateDTO) {
        try {
            Long hissedarId = hissedarService.updateHissedar(id, hissedarCreateDTO);
            return new ResponseEntity<>(hissedarService.getHissedarDTO(hissedarId), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHissedar(@PathVariable Long id) {
        hissedarService.deleteHissedar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
