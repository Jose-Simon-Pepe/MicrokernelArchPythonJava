package container;

import services.persister.imp.Persister;
import services.notegenerator.imp.NoteGenerator;
import services.osmanager.imp.OSManager;
import services.remover.imp.Remover;

public class ServicesContainer {

    public NoteGenerator noteGenerator;
    public OSManager osmanager;
    public Persister persister;

    public Remover remover;

    public ServicesContainer(NoteGenerator noteGenerator, OSManager osmanager, Persister persister, Remover remover) {
        this.noteGenerator = noteGenerator;
        this.osmanager = osmanager;
        this.persister = persister;
        this.remover = remover;
    }
}
