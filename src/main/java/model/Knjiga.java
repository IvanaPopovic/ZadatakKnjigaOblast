package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by android on 27.9.16..
 */
@DatabaseTable(tableName = "knjiga")
public class Knjiga {

    public static final String POLJE_NASLOV="naslov";
    public static final String POLJE_BROJ_STRANA="broj_strana";
    public static final String POLJE_DATUM_IZDAVANJA="datum_izdavanja";

        private Date datumIzdanja;
        private boolean prisutna;

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_NASLOV,canBeNull = false)
    private String naslov;
    @DatabaseField(columnName = POLJE_BROJ_STRANA,canBeNull = false)
    private int brojStrana;
    @DatabaseField(columnName = POLJE_DATUM_IZDAVANJA,canBeNull = false)
    private Date datumIzdavanja;

    @ForeignCollectionField(foreignFieldName = "knjiga",eager=false,maxEagerLevel = 1)
    private ForeignCollection<Oblast> oblasti;

    public Knjiga() {
        //konstruktor bez parametara obavezan za ORMLite
    }

    public Knjiga(String naslov, int brojStrana, Date datumIzdavanja) {
        this.naslov = naslov;
        this.brojStrana = brojStrana;
        this.datumIzdavanja=datumIzdavanja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getbrojStrana() {
        return brojStrana;
    }

    public void setbrojStrana(int brojStrana) {
        this.brojStrana = brojStrana;
    }

    public Date getdatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setdatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public ForeignCollection<Oblast> getOblasti() {
        return oblasti;
    }

    public void setOblasti(ForeignCollection<Oblast> oblasti) {
        this.oblasti = oblasti;
    }

    @Override
    public String toString() {
        return "Knijga{" +
                "id=" + id +
                ", naslov=" + naslov +
                ", brojStrana=" + brojStrana +
                ", datumIzdanja='" + datumIzdanja + '\'' +
                '}';
    }

}
