package api;

//import dominio.notaestudio.NotaEstudio;

import java.io.IOException;

public class Api {

    private CoreInter toExpose;

    public void setup(String pluginPath, String pluginName) throws IOException {
        if (pluginPath != null && pluginName != null) {
            toExpose.setup(pluginPath, pluginName);
        }
    }

    public void createNote() {
        toExpose.createNote();
    }

/*

    public void saveNote(NotaEstudio note) {
        toExpose.saveNote(note);
    }



 */

    public void deleteNote(String path) {
        toExpose.deleteNote(path);
    }



    public Api(CoreInter toExpose) {
        this.toExpose = toExpose;
    }
}
