package services.osmanager.imp;

import services.Service;
import services.osmanager.OSManagerInter;

import java.io.IOException;
import java.util.HashMap;

public class OSManager implements OSManagerInter {

    HashMap<String, Process> listOfAppProcess;

    public void startPluginProcess(String pluginPath, String pluginName) throws IOException {
        Process pluginProcess = Runtime.getRuntime().exec(pluginPath+pluginName);
        if (pluginProcess.isAlive()) listOfAppProcess.put(pluginPath+pluginName,pluginProcess);
    }
}
