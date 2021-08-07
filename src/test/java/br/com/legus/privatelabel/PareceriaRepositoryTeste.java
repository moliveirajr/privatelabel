package br.com.legus.privatelabel;

import br.com.legus.privatelabel.entity.ParceriaEntity;
import br.com.legus.privatelabel.repository.ParceriaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PareceriaRepositoryTeste {

    @Autowired
    private ParceriaRepository parceriaRepository;

    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        ParceriaEntity parceriaEntity = parceriaRepository.findByCanal(536L);
        assertNotNull(parceriaEntity);
        assertEquals(java.util.Optional.of(145L), java.util.Optional.of(parceriaEntity.getOrigem()));
//        /*Get all products, list should only have two*/
//        Iterable<user> users = userMongoRepository.findAll();
//        int count = 0;
//        for(User p : users){
//            count++;
//        }
//        assertEquals(count, 2);
    }
}
