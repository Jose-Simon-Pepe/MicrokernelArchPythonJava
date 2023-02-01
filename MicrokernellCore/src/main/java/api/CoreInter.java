package api;

import dominio.notaestudio.NotaEstudio;

import java.io.IOException;

public interface CoreInter {

    void setup(String pluginPath,String pluginName) throws IOException;

    String createNote();

    String saveNote(NotaEstudio note);

    String deleteNote(String path);
}
