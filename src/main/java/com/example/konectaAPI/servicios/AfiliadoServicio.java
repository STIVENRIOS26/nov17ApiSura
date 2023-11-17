package com.example.konectaAPI.servicios;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.repositorios.AfiliadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AfiliadoServicio {

    @Autowired
    private AfiliadoRepositorio afiliadoRepositorio;

    //RegistrarAfiliado
    public Afiliado registrarAfiliado(Afiliado afiliado) throws Exception{
        try{

           return this.afiliadoRepositorio.save(afiliado);

        }catch(Exception error){
            throw new Exception("error al registrarse");
        }
    }

    //ConsultarAfiliado
    public Afiliado consultarAfiliado(Integer idAfiliado) throws Exception {
        try{
            Optional<Afiliado>afiliadoBuscado=this.afiliadoRepositorio.findById(idAfiliado);
            if(afiliadoBuscado.isPresent()){ //Lo encontre en BD
                return afiliadoBuscado.get();
            }else{ //No lo encontra
                throw new Exception("Afiliado no encontrado");
            }
        }catch(Exception error){
            throw new Exception("error en la consulta del afiliado");
        }
    }

    //ConsultarAfiliados

    //ModificarDatosAfiliado

    //BorrarAfiliado

}
