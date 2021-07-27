package br.com.legus.privatelabel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoAcessoDispositivoEntity {
    private String deviceId;
    private String fabricante;
    private String latitude;
    private String longitude;
    private String modelo;
    private String plataforma;
    private String root;
    private String tipoDispositivo;
    private String vitual;
}
