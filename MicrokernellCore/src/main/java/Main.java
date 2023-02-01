import api.Api;
import container.ServicesContainer;
import core.Core;
import util.GenerateContainer;

public class Main {

    public static void main(String[] args) {
        try {
            //generating services
            ServicesContainer servicesContainer = GenerateContainer.
                    generateServicesContainer("/home/jose/soft-projects/MicrokernellPluginCore/MicrokernellCore/config/dependencies");
            //loading up plugins
            Core root = new Core(servicesContainer);
            Api api = new Api(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
