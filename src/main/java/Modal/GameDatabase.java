package Modal;

import java.sql.*;
import GameEvent.*;
import WorldBuilder.*;
import GameObject.*;
import java.util.*;

/**
 *
 */
public class GameDatabase {

    /**
     *
     */
    static private Connection dataConn;

    /**
     *
     */
    static private String maTG;

    /**
     * @param dbURL
     * @param username
     * @param password
     */
    static public void connectDatabase(String dbURL, String username, String password) {
        // TODO implement here
    }

    /**
     * @return
     */
    static public ArrayList<String> getDSTheGioi() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    static public TheGioi getTheGioi() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    static public NhanVat getNguoiChoi() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    static public ArrayList<NhanVat> getDSNV() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    static public Connection getDataConn() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    static public String getMaTG() {
        // TODO implement here
        return "";
    }

    /**
     * @param maTG
     */
    static public void setMaTG(String maTG) {
        // TODO implement here
    }

}
