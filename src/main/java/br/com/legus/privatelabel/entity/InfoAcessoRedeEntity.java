package br.com.legus.privatelabel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoAcessoRedeEntity {
    private String ip;
    private String tipoConexao;
    private String wifiSSID;
}
