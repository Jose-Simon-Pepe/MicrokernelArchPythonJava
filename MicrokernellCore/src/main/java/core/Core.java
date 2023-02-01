package core;

import api.CoreInter;
import container.ServicesContainer;
import dominio.notaestudio.NotaEstudio;

import services.notegenerator.NoteGeneratorInter;
import services.osmanager.OSManagerInter;

import services.persister.PersisterInter;
import services.remover.RemoverInter;

import java.io.IOException;


public class Core implements CoreInter {

    private final ServicesContainer container;
    // modules
    private NoteGeneratorInter noteGenerator;
    private PersisterInter persister;
    private RemoverInter remover;
    private OSManagerInter osManager;
    // lógica de negocio
    public String createNote() {
        return noteGenerator.newEmptyNote();
    }

    public String saveNote(NotaEstudio note){
        return persister.persist(note);
    }

    public String deleteNote(String path){
        return remover.remove(path);
    }


    public void setup(String pluginPath,String pluginName) throws IOException {
        if (pluginPath != null && pluginName != null) {
            osManager.startPluginProcess(pluginPath,pluginName);
        }
    }

    public Core(ServicesContainer container) {
        this.container=container;
        this.noteGenerator=container.noteGenerator;
        this.persister=container.persister;
        this.remover=container.remover;
        this.osManager=container.osmanager;
    }

}
