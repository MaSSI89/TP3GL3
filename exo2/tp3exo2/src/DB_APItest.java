import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.*;


public class DB_APItest {
    private static DB_API db;
    private boolean connResult;

    @BeforeClass
    public static void  createDB_API(){
        db = new DB_API();
        System.out.println("Creating database Connection:");
    }

///////////////-----  ORACLE ----/////////////////
    @Test(timeout = 2500)
    public void testDBConnectOracleAlgeria (){
        connResult = db.DBconnect("Oracle", "Algeria");
        assertTrue(connResult);
    }
    @Test(timeout = 1200)
    public void testDBConnectOracleUSA (){
        connResult = db.DBconnect("Oracle", "USA");
        assertTrue(connResult);
    }

    @Test(timeout = 3500)
    public void testDBCOnnectionOracleFrance() {
        connResult = db.DBconnect("Oracle", "France");
        assertFalse(connResult);
    }

    @Test(expected = Exception.class)
    public void testDbCOnnectionNullDB(){
        db.DBconnect(null, "Algeria");
        System.out.println("NO DB provided");
    }
    
    @Test(expected = Exception.class)
    public void testDbCOnnectionNullCOuNTRY(){
        db.DBconnect("Oracle", null);
        System.out.println("NO COuntry provided");
    }

    @Test
    public void testDbConnectionOracleInvalidCOuntry() {
        connResult = db.DBconnect("Oracle", "Morocccccccco");
        assertFalse("COuntry should be Algeria, France , USA",connResult);
    }

    @Test
    public void testINvalidDBName(){
        connResult = db.DBconnect("PostgreSQL", "Algeria");
        assertFalse("DB should be either Oracle or MySQL or SQLServer", connResult);
    }
//////////////////----- MySQL ------/////////////////
    @Test
    public void testDBConnectMySQLAlgeria() {
        connResult = db.DBconnect("MySQL", "Algeria");
        assertFalse(connResult);
    }
    
    @Test( timeout = 1200)
    public void testDbCOnnectionMySQLUSA (){
        connResult = db.DBconnect("MySQL","USA");
        assertFalse(connResult);
    }

    @Test (timeout = 5100 )
    public void testCOnnMySQLFrance (){
        connResult = db.DBconnect("MySQL", "France");
        assertTrue(connResult);
    }

   
    
}
