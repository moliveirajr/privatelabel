package br.com.legus.privatelabel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "parceria")
public class ParceriaEntity {

    @Id
    private String id;
    private Long canal;
    private Long origem;
    private Long tipoPontoVenda;
    private Long numeroPontoVenda;
    private Long empresa;
    private Long filial;
}
