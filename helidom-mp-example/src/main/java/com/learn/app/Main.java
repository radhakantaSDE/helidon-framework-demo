package com.learn.app;

import io.helidon.microprofile.server.Server;
import java.io.IOException;
import java.util.logging.LogManager;

public class Main {

    private Main() { }

    public static void main(final String[] args) throws IOException {
        setupLogging();
        Server server = startServer();
        System.out.println("http://localhost:" + server.port() + "/greet");
    }

    /**
     * Start the server.
     * @return the created {@link Server} instance
     */
    static Server startServer() {
        // Server will automatically pick up configuration from
        // microprofile-config.properties
        // and Application classes annotated as @ApplicationScoped
        return Server.create().start();
    }

    private static void setupLogging() throws IOException {
        LogManager.getLogManager().readConfiguration(
                Main.class.getResourceAsStream("/logging.properties"));
    }
}
