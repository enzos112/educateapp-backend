package com.bazangarcia.config;

public class DatabaseConfigSingleton {
    private static DatabaseConfigSingleton instance;
    private final String connectionUrl;
    private final int maxConnections;
    private final int connectionTimeout;

    private DatabaseConfigSingleton(){
        this.connectionUrl="jdbc:mysql://localhost:3306/EducateappBackend";
        this.maxConnections=20;
        this.connectionTimeout=3000;

        System.out.println("DatabaseConfigSingleton: Instancia creada");
    }

    public static synchronized DatabaseConfigSingleton getInstance(){
        if (instance==null){
            instance=new DatabaseConfigSingleton();
        }
        return instance;
    }

    //Getters
    public String getConnectionUrl(){
        return connectionUrl;
    }

    public int getMaxConnections(){
        return maxConnections;
    }

    public int getConnectionTimeout(){
        return connectionTimeout;
    }

    public void printConfig(){
        System.out.println("=== Configuración de Base de Datos ===");
        System.out.println("URL: " + connectionUrl);
        System.out.println("Max Connections: " + maxConnections);
        System.out.println("Timeout: " + connectionTimeout + "ms");
    }
}
