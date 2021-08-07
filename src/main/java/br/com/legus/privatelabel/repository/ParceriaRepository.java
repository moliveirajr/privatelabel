package br.com.legus.privatelabel.repository;

import br.com.legus.privatelabel.entity.ParceriaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParceriaRepository extends MongoRepository<ParceriaEntity,String> {

    ParceriaEntity findByCanal(long canal);
}
