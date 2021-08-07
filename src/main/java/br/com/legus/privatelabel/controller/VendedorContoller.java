package br.com.legus.privatelabel.controller;

import br.com.legus.privatelabel.entity.VendedorEntity;
import br.com.legus.privatelabel.repository.VendedorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class VendedorContoller {


    @Autowired
    private VendedorRepository vendedorRepository;

    @ResponseBody
    @GetMapping("/api/v1/vendedor")
    public ResponseEntity<VendedorEntity> getVendedor() {

        try {
            return ResponseEntity.ok().body(vendedorRepository.findByUsuario("123456789"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
