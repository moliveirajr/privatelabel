package br.com.legus.privatelabel;

import br.com.legus.privatelabel.entity.InfoAcessoEntity;
import br.com.legus.privatelabel.entity.VendedorEntity;
import br.com.legus.privatelabel.repository.VendedorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendedorRepositoryTeste {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Before
    public void setUp() throws Exception {
        InfoAcessoEntity infoAcessoEntity = new InfoAcessoEntity();
        VendedorEntity vendedor = new VendedorEntity();
        vendedor.setUsuario("123456789");
        vendedor.setCanal(536);
        vendedor.setOrigem(145);
        vendedor.setTipoPontoVenda(1);
        vendedor.setNumeroPontoVenda(12101L);
        //save product, verify has ID value after save
//        assertNull(user1.getId());
//        assertNull(user2.getId());//null before save
        this.vendedorRepository.save(vendedor);
        assertNotNull(vendedor.getUsuario());
    }

    @Test
    public void testFetchVededor() {
        /*Test data retrieval*/
        VendedorEntity vendedorEntity = vendedorRepository.findByUsuario("123456789");
        assertNotNull(vendedorEntity);

    }
}
