package br.com.legus.privatelabel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoAcessoNavegadorEntity {
    private String fingerprint;
    private String nome;
    private String versao;
}
