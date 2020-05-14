/**
 * Author: Magnus Fredriksson
 */

package kth.projektgrupp17.sql.DB;

import java.util.ArrayList;

/**
 * Represents an entire MySQL database
 */
public class DataBase {
    String name;
    ArrayList<Table> tables = new ArrayList<>();

    /**
     * Creates a new database schema with specified name
     * @param name the schema name
     */
    public DataBase(String name) { this.name = name; }

    /**
     * Adds a table to the database
     * @param t the table to add
     */
    public void addTable(Table t) { this.tables.add(t); }

    /**
     * Generates the SQL statements necessary to recreate the database.
     * @return the String representation of the SQL for this database
     */
    public String toSQLCreation() {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP DATABASE IF EXISTS `"+ this.name + "`;\n");
        sb.append("CREATE SCHEMA `"+ this.name +"` DEFAULT CHARACTER SET latin1;\n");
        sb.append("USE "+ this.name +";\n");
        for(Table t :  this.tables)
            sb.append(t.getCreationStatement());
        //TODO: implement maybe
        return sb.toString();
    }

    /**
     * Generates the SQL statements necessary to populate the database
     * The data for each table must exist as csv in a file named [TABLE_NAME]_ok.dat
     * @return String representation of database data as sql statements.
     */
    public String toSQLPopulation() {
        StringBuilder sb = new StringBuilder();
        for(Table t : this.tables)
            sb.append(t.getPopulationStatement() + "\n");
        return sb.toString();
    }
}
