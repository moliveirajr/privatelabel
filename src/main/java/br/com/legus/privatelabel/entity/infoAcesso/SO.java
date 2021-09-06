package br.com.legus.privatelabel.entity.infoAcesso;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SO {
    private String idioma;
    private String resolucao;
    private String so;
    private String versao;

    public SO() {
        this.idioma = "";
        this.resolucao = "";
        this.so = "";
        this.versao = "";
    }
}
