package framework.grid;

import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.utils.SelfRegisteringRemote;
import org.openqa.grid.internal.utils.configuration.GridHubConfiguration;
import org.openqa.grid.internal.utils.configuration.GridNodeConfiguration;
import org.openqa.grid.shared.GridNodeServer;
import org.openqa.selenium.remote.server.SeleniumServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.grid.web.Hub;

public class SeleniumGrid {

    private static final Logger logger = LoggerFactory.getLogger(SeleniumGrid.class);
    private static Hub hub;
    private static GridNodeServer node;
    private static SelfRegisteringRemote remote;

    public SeleniumGrid() {
        hub = new Hub(GridHubConfiguration.loadFromJSON("selenium-grid-hub-config.json"));
        RegistrationRequest registrationRequest = new RegistrationRequest(GridNodeConfiguration.loadFromJSON("selenium-grid-node-config.json"));
        node = new SeleniumServer(registrationRequest.getConfiguration());
        remote = new SelfRegisteringRemote(registrationRequest);
    }

    public void runHub() {
        try {
            hub.start();
        } catch (Exception e) {
            logger.error("Cannot establish Selenium Grid HUB ", e);
        }
    }

    public void stopHub() {
        try {
            hub.stop();
        } catch (Exception e) {
            logger.error("Cannot stop Selenium Grid HUB ", e);
        }
    }

    public void runNode() {
        remote.setRemoteServer(node);
        try {
            remote.startRemoteServer();
            remote.sendRegistrationRequest();
            remote.startRegistrationProcess();
            remote.setTimeout(1800, 5);
        } catch (Exception e) {
            logger.error("Cannot establish Selenium Grid NODE", e);
        }
    }

    public void stopNode() {
        remote.stopRemoteServer();
    }

}
