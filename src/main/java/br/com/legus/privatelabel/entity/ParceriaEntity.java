package br.com.legus.privatelabel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dadosParceria")
public class ParceriaEntity {

    private String _id;
    private Long canal;
    private Long origem;
    private Long tipoPontoVenda;
    private Long numeroPontoVenda;
}
