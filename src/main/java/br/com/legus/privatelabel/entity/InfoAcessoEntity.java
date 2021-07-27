package br.com.legus.privatelabel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoAcessoEntity {
    private InfoAcessoDispositivoEntity infoAcessoDispositivo;
    private InfoAcessoNavegadorEntity infoAcessoNavegador;
    private InfoAcessoRedeEntity infoAcessoRede;
}
