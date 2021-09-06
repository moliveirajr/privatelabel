package br.com.legus.privatelabel.entity.infoAcesso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class Dispositivo {
    private String deviceId;
    private String fabricante;
    private String latitude;
    private String longitude;
    private String modelo;
    private String plataforma;
    private Boolean root;
    private String tipoDispositivo;
    private Boolean vitual;

    public Dispositivo() {
        this.deviceId = "";
        this.fabricante = "";
        this.latitude = "";
        this.longitude = "";
        this.modelo = "";
        this.plataforma ="";
        this.root= false;
        this.tipoDispositivo="";
        this.vitual=true;
    }
}
