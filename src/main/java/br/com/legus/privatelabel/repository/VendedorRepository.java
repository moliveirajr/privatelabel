package br.com.legus.privatelabel.repository;

import br.com.legus.privatelabel.entity.VendedorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendedorRepository extends MongoRepository<VendedorEntity,String> {

    VendedorEntity findByUsuario(String usuario);
}
