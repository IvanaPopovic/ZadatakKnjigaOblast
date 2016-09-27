package zadaci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by android on 27.9.16..
 */
public class Zadatak1KreiranjeTabela {
    public static void main(String[] args) {
            Connection c = null;
            try {
                //Inicjalizujemo drajver za SQLite
                Class.forName("org.sqlite.JDBC");
                //Upostavljamo konekciju sa bazom
                c = DriverManager.getConnection(Konstante.DATABASE_URL);
                System.out.println("Uspesno konektovano na bazu");








            } catch ( Exception e )
        /*Hvatamo bilo kakav izuzetak koji moze da znaci
           da ne mozemo da uspostavimo konekciju sa bazom
         */
            {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            } finally{
                try {
                /*Zatvaramo konekciju sa bazom u slucaju da se desi neki
                   izuzetak ili ako sve uspe uspesno da se izvrsi
                 */
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

