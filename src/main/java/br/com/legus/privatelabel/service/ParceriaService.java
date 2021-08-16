package br.com.legus.privatelabel.service;

import br.com.legus.privatelabel.entity.ParceriaEntity;
import br.com.legus.privatelabel.repository.ParceriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParceriaService {

    @Autowired
    private ParceriaRepository parceriaRepository;

    public ParceriaEntity getParceriaByFilial (Long filial) {

        ParceriaEntity parceriaEntity = parceriaRepository.findByFilial (filial);

        return parceriaEntity;
    }
}
