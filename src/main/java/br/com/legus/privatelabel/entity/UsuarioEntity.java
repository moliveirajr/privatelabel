package br.com.legus.privatelabel.entity;

import br.com.legus.privatelabel.entity.infoAcesso.Info;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {

    private String usuario;
    private Integer canal;
    private Integer origem;
    private Integer tipoPontoVenda;
    private Integer numeroPontoVenda;
    private Info info;

    public UsuarioEntity (String usuario, Integer canal, Integer origem,
                          Integer tipoPontoVenda, Integer numeroPontoVenda) {
        this.usuario = usuario;
        this.canal = canal;
        this.origem = origem;
        this.tipoPontoVenda = tipoPontoVenda;
        this.numeroPontoVenda = numeroPontoVenda;

        this.info = new Info (  );
    }
}
