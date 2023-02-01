package util;

import dependency.Dependency;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DependencyLoader {

    private HashMap<String, Dependency> dependencies = new HashMap<>();
    private final Properties propertiesDoc = new Properties();


    public DependencyLoader(String configFilePath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        try (FileReader reader = new FileReader(configFilePath)) {
            propertiesDoc.load(reader); // se carga el documento configuración
            //iteramos la lista de propiedad
            List<String> propertiesList = new ArrayList<>(propertiesDoc.stringPropertyNames());
            propertiesList.forEach(dependencyName -> {
                try {
                    loadDependency(dependencyName);
                } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
                    throw new RuntimeException(e);
                }});
        } catch (IOException e) {throw new RuntimeException(e);}}
    private void loadDependency(String dependencyToLoad) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> mother = Class.forName(dependencyToLoad);
        dependencies.put(dependencyToLoad, (Dependency) mother.newInstance());
    }

    public Dependency getDependency(String toGet) {
        return  dependencies.get(toGet);
    }
}
