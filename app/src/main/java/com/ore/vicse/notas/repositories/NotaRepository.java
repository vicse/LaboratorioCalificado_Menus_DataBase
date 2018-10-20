package com.ore.vicse.notas.repositories;

import com.ore.vicse.notas.models.Nota;
import com.orm.SugarRecord;

import java.util.List;

public class NotaRepository {

    public static List<Nota> list(){
        List<Nota> notas= SugarRecord.listAll(Nota.class);
        return notas;
    }

    public static Nota read(Long id){
        Nota nota= SugarRecord.findById(Nota.class, id);
        return nota;
    }

    public static void create(String tittle, String contenido){
        Nota nota = new Nota(tittle,contenido);
        SugarRecord.save(nota);
    }

    public static void update(String tittle, String contenido, Long id){
        Nota nota = SugarRecord.findById(Nota.class, id);
        nota.setTittle(tittle);
        nota.setContenido(contenido);
        SugarRecord.save(nota);
    }

    public static void delete(Long id){
        Nota nota = SugarRecord.findById(Nota.class, id);
        SugarRecord.delete(nota);

    }

}
