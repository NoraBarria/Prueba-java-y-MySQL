/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectarmysql;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kunio-ph
 */
class connection {

    static Statement createStatement() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            try {
                ResultSet rs = statement.executeQuery("SELECT * FROM persona");
            } catch (SQLException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (rs.next()) {
                
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fecha = rs.getDate("fecha");
                
                System.out.println(String.format("%d, %s %s, %s", id, nombre, apellido, fecha));
            }
            rs.close();
        }
connection.close();
        return null;
}

    private static void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

