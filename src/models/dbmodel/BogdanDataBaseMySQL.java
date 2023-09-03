package models.dbmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class BogdanDataBaseMySQL<T>{
    protected String url;
    protected String dataBaseName;
    protected String password;
    protected String login;

    protected final String SELECT = "SELECT";
    protected final String UPDATE = "UPDATE";
    protected final String CREATE = "CREATE";
    protected final String INSERT = "INSERT";
    protected final String ALERT = "ALERT";
    protected final String FROM = "FROM";
    protected final String INTO = "INSERT INTO `";
    protected final String VALUES = "`) VALUES ('";
    protected final String SEPARATOR_AFTER_COLUMN = "`, `";
    protected final String BEFORE_COLUMN = "` (`";
    protected final String END = "');";
    protected final String NOT_NULL = "NOT NULL";
    protected final String AUTO_INCREMENT = "AUTO_INCREMENT";
    protected final String PRIMARY_KEY = "PRIMARY KEY";
    protected final String UNIQUE_INDEX = "UNIQUE INDEX";
    protected final String TABLE = "TABLE `";
    protected final String COLUMN ="COLUMN `";
    protected final String SPACE = " ";
    protected final String SCHEMA = "SCHEMA `" ;
    protected final String FOREIGN_KEY = "FOREIGN KEY";
    protected final String REFERENCES = "REFERENCES";

    public BogdanDataBaseMySQL(String url, String dataBaseName, String password, String login) {
        this.url = url;
        this.dataBaseName = dataBaseName;
        this.password = password;
        this.login = login;

    }

    public Connection getConnectionWithMySQL () throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + url +":3306"+ "/" + dataBaseName,
                login,password );
        System.out.println("Соединение с базой данных установленно!");
        return connection;
    }

    public abstract List<T>  showDate(String sqlQuery) throws SQLException;



}
