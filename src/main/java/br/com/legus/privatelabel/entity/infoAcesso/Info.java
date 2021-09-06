package br.com.legus.privatelabel.entity.infoAcesso;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Info {
    private Dispositivo dispositivo;
    private Navegador navegador;
    private Rede rede;
    private SO so;

    public Info() {
        this.dispositivo = new Dispositivo (  );
        this.navegador = new Navegador (  );
        this.rede = new Rede (  );
        this.so = new SO (  );
    }
}
