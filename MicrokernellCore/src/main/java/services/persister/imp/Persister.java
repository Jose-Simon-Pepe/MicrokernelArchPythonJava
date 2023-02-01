package services.persister.imp;

import dominio.notaestudio.NotaEstudio;
import services.Service;
import services.persister.PersisterInter;

public class Persister implements PersisterInter {
    public String persist(NotaEstudio note) {
        return "Note persisted";
    }
}
