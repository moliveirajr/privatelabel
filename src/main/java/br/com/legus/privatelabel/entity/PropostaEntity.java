package br.com.legus.privatelabel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropostaEntity {

    private Integer canal;
    private Integer tipoPontoVenda;
    private Long numeroPontoVenda;
    private Integer origem;
    private Long celularProposta;
    private Integer dddCelularProposta;
    private Long codigoAcesso;
    private String cpfcnpj;
    private String codigoAcessoObrigatorio;
    private String capturaFotoObrigatoria;
    private String pacDigitalObrigatorio;
    private String documentosObrigatorios;
    private String emissaoInstantaneaHabilitada;
    private String cadastroSenhaEmbossing;
    private Long numeroProposta;
}
