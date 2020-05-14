/**
 * Author: Magnus Fredriksson
 */

package kth.projektgrupp17.sql;

import kth.projektgrupp17.sql.DB.DataBase;
import kth.projektgrupp17.sql.DB.IoTProject;

/**
 * The main entrypoint of the application
 * Generates the SQL statements necessary to create the IOT-database
 * including constraints and prints them to stdout.
 */
public class main {
    public static void main(String[] args) {
        DataBase db = new DataBase("iot_project_db");
        IoTProject.tables().forEach(db::addTable);
        System.out.println(db.toSQLCreation());
    }
}
