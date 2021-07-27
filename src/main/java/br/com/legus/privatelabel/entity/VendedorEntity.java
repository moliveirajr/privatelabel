package br.com.legus.privatelabel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorEntity {
    private String usuario;
    private String senha;
    private Integer canal;
    private Integer tipoPontoVenda;
    private Long numeroPontoVenda;
    private Integer origem;
    private InfoAcessoEntity infoAcesso;
}
