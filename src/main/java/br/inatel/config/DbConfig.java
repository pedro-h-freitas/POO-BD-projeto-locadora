package br.inatel.config;

/**
 * Class for save the information for connect with DB
 */
public class DbConfig {
    private final String database = "locadora_bd"; // database name
    private final String user = "root"; // database user
    private final String password = "root"; // database password
    private final String url = "jdbc:mysql://localhost:3306/" + database + // database url
            "?useTimezone=true" +
            "&serverTimezone=UTC" +
            "&useSSL=false" +
            "&allowPublicKeyRetrieval=true";

    /**
     * Getter for database user
     * @return database user
     */
    public String getUser() {
        return user;
    }

    /**
     * Getter for database password
     * @return database password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter for database url
     * @return database url
     */
    public String getUrl() {
        return url;
    }

}