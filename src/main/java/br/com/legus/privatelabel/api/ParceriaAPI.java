package br.com.legus.privatelabel.api;

import br.com.legus.privatelabel.entity.ParceriaEntity;
import br.com.legus.privatelabel.service.ParceriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ParceriaAPI {

    @Autowired
    private ParceriaService parceriaService;

    @ResponseBody
    @GetMapping("/bradescard/api/v1/parceria-filial/{filial}")
    public ResponseEntity<ParceriaEntity> getParceriaByFilial(@PathVariable Long filial){

        try {
            ParceriaEntity parceriaEntity = parceriaService.getParceriaByFilial (filial);
            return parceriaEntity == null ? ResponseEntity.noContent ( ).build ( ) : ResponseEntity.ok (parceriaEntity);
        } catch (Exception e) {
            return ResponseEntity.badRequest ( ).build ( );
        }
    }
}
