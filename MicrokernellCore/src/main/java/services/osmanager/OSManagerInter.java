package services.osmanager;

import services.Service;

import java.io.IOException;

public interface OSManagerInter extends Service {

    void startPluginProcess(String pluginPath, String pluginName) throws IOException;
}
