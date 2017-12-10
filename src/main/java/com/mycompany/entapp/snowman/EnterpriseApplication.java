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

    public static void main(String[] args) throws Exception {
        System.out.println("Running as a Fat Jar");

        final Server server = new Server();

        final ServerConnector serverConnector = new ServerConnector(server);
        serverConnector.setPort(8090);

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
                        e.printStackTrace();
                    }
                }
            }
        }));

        server.join();

    }
}
