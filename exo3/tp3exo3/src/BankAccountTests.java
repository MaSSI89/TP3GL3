import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.junit.jupiter.api.DisplayName;

public class BankAccountTests {
    private  BankAccount account;
    private int accNumber = 13;


    @Before
    public  void testnewAccount(){
        account = new BankAccount(accNumber);
        System.out.println("New Bank account Created");

    }

    @After
    public void destroyTestAccount(){
        account = null;
        accNumber += 1;
        System.out.println("Deleted Test Account");
    }

    @Before
    @DisplayName("New account id is unique")
    public void testgetAccountNum() {
        System.out.println(" Test get account NUM");
        assertEquals("Account Number is :"+ accNumber, accNumber, account.getAccountNum());
    }

    @Test
    public void testGetBalance() {
        assertEquals("Balance Initial doit etre 0", 0, account.getBalance());
        account.deposit(400);
        assertEquals("Balance doit etre 400", 400, account.getBalance());
        account.withdraw(200);
        assertEquals("Balance doit etre 200", 200, account.getBalance());
    }
   
    @Test
    public void testDeposit(){
        assertTrue("Deposer somme positive avec succes", account.deposit(500));
        assertFalse("Deposer 0 erreur", account.deposit(0));
        assertFalse("On ne peut pas deposer une somme megative", account.deposit(-200));
    }
    
    @Test
    public void testWithdraw(){
        assertFalse("Can not withdraw 0", account.withdraw(0));
        account.deposit(5000);
        assertTrue("Should withdraw succesfully", account.withdraw(3000));
        assertFalse("SHould not withdraw amount > balance", account.withdraw(20000));
    }

    @Test 
    public void testgetLastTransaction() {
        assertEquals("THere is no last transaction yet", 0 ,account.getLastTransAmount());
        account.deposit(4000);
        assertEquals("Last transaction +4000", 4000, account.getLastTransAmount());
        account.withdraw(4000);
        assertEquals("Last transaction -4000", -4000, account.getLastTransAmount());
        System.out.println("WITHDRAW 4000");
    }
}
