package br.com.legus.privatelabel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity {

    private String cpf;
    private String ddi;
    private String ddd;
    private String celular;
    private String senhaAleatoria;
    private Integer canal;
    private Integer tipoPontoVenda;
    private Long numeroPontoVenda;
    private Integer origem;
}
