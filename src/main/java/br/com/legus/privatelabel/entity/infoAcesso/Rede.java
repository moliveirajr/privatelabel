package br.com.legus.privatelabel.entity.infoAcesso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Rede {
    private String ip;
    private String tipoConexao;
    private String wifiSSID;

    public Rede() {
        ip = "";
        tipoConexao = "";
        wifiSSID = "";
    }
}
