package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.SignoVital;
import com.example.konectaAPI.repositorios.SignoVitalRepositorio;
import com.example.konectaAPI.utilidades.Enum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SignoVitalServicio {

    @Autowired
    private SignoVitalRepositorio signoVitalRepositorio;

    //REGISTRAR
    public SignoVital registrarSignoVital(SignoVital signoVital) throws Exception {
        try {
            return this.signoVitalRepositorio.save(signoVital);
        } catch (Exception error) {
            throw new Exception(Enum.ERROR_REGISTRO.getMensaje());
        }
    }

    //CONSULTAR
    public SignoVital consultarSignoVital(Integer idSignoVital) throws Exception {
        try {
            Optional<SignoVital> signoBuscado = this.signoVitalRepositorio.findById(idSignoVital);
            if (signoBuscado.isPresent()) {
                return signoBuscado.get();
            } else {
                throw new Exception(Enum.SIGNO_INEXISTENTE.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(Enum.ERROR_EN_CONSULTA.getMensaje());
        }
    }
}