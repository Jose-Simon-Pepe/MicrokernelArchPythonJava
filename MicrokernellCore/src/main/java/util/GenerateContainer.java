package util;

import container.ServicesContainer;
import services.notegenerator.imp.NoteGenerator;
import services.osmanager.imp.OSManager;
import services.persister.imp.Persister;
import services.remover.imp.Remover;

public class GenerateContainer {

    private String configPath;


    public GenerateContainer(String configPath) {
        this.configPath = configPath;
    }

    public static ServicesContainer generateServicesContainer(String configFilePath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // generating container from dependencies

            DependencyLoader dependencyLoader = new DependencyLoader(configFilePath);
            //Generating services container
            ServicesContainer container = new ServicesContainer((NoteGenerator) dependencyLoader.getDependency("noteGenerator"),
                    (OSManager)  dependencyLoader.getDependency("osmanager"),
                    (Persister) dependencyLoader.getDependency("persister"),
                    (Remover) dependencyLoader.getDependency("remover"));
            return container;

    }
}
