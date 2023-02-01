package services.persister;

import dominio.notaestudio.NotaEstudio;
import services.Service;

public interface PersisterInter extends Service {
     String persist(NotaEstudio note);
}
