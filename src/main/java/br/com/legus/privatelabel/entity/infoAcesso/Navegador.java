package br.com.legus.privatelabel.entity.infoAcesso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Navegador {
    private String fingerprint;
    private String nome;
    private String versao;

    public Navegador() {
        fingerprint = "";
        nome = "";
        versao = "";
    }
}
