/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class EnterpriseApplication {

    private static final int DEFAULT_PORT = 8090;

    public static void main(String[] args) throws Exception {
        System.out.println("Running as a Fat Jar");

        final Server server = new Server();

        final ServerConnector serverConnector = new ServerConnector(server);

        serverConnector.setPort(resolvePort());

        server.setConnectors(new Connector[]{serverConnector});

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setDescriptor(EnterpriseApplication.class.getClassLoader().getResource("webapp/WEB-INF/web.xml").toString());
        webAppContext.setResourceBase(EnterpriseApplication.class.getClassLoader().getResource("webapp").toString());
        webAppContext.setContextPath("/");
        webAppContext.setParentLoaderPriority(true);

        server.setHandler(webAppContext);
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                if (server.isStarted()) {
                    server.setStopAtShutdown(true);

                    try {
                        server.stop();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }));

        server.join();

    }

    private static int resolvePort() {
        try {
            return Integer.parseInt(System.getProperty("port"));
        } catch (NumberFormatException ex) {
            return DEFAULT_PORT;
        }
    }
}
