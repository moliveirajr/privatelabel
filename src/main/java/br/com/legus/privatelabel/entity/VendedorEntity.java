package br.com.legus.privatelabel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "vendedor")
public class VendedorEntity {

    @Id
    private String id;
    private String usuario;
    private Integer canal;
    private Integer tipoPontoVenda;
    private Long numeroPontoVenda;
    private Integer origem;
//    private InfoAcessoEntity infoAcesso;
}
