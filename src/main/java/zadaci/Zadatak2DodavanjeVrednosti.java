package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Knjiga;
import model.Oblast;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by android on 27.9.16..
 */
public class Zadatak2DodavanjeVrednosti {
    static Dao<Oblast,Integer> oblastDao;
    static Dao<Knjiga,Integer> knjigaDao;


    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            // create our data-source for the database
            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);
            oblastDao = DaoManager.createDao(connectionSource, Oblast.class);
            knjigaDao = DaoManager.createDao(connectionSource, Knjiga.class);

            TableUtils.clearTable(connectionSource, Oblast.class);
            TableUtils.clearTable(connectionSource, Knjiga.class);

            Knjiga k1=new Knjiga("Java programiranje", 650, new Date());
            knjigaDao.create(k1);

            Knjiga k2=new Knjiga("Android programiranje", 500, new Date());
            knjigaDao.create(k2);



            Oblast o1=new Oblast ("Uvod", 2);
            o1.setKnjiga(k1);
            oblastDao.create(o1);


            Oblast o2=new Oblast ("Naredbe", 10);
            o2.setKnjiga(k1);
            oblastDao.create(o2);

            Oblast o3=new Oblast ("Aritmeticki operatori", 20);
            o3.setKnjiga(k1);
            oblastDao.create(o3);

            Oblast o4=new Oblast ("Android operativni sistem", 2);
            o4.setKnjiga(k2);
            oblastDao.create(o4);

            Oblast o5=new Oblast ("Activity klasa", 30);
            o5.setKnjiga(k2);
            oblastDao.create(o5);


            List<Oblast> oblast=oblastDao.queryForAll();
            for(Oblast o:oblast) {
                System.out.println("Naziv = " + o);
                System.out.println("Pocetna strana = "+o.getPocetnaStrana());
                System.out.println();
            }

            List<Knjiga> knjiga=knjigaDao.queryForAll();
            for(Knjiga k:knjiga) {
                System.out.println("Naslov = " + k);
                System.out.println("Broj strana = "+k.getbrojStrana());
                System.out.println("Datum izdavanja = "+k.getdatumIzdavanja());
                System.out.println();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    }

