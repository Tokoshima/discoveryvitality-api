package za.ac.nwu.accountsystem.repo.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;





import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.nwu.accountsystem.domain.dto.AccountTypeDto;
import za.ac.nwu.accountsystem.domain.persistence.AccountType;
import za.ac.nwu.accountsystem.repo.config.RepositoryTestConfig;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class})
public class AccountTypeRepositoryTest {

    @Autowired
    AccountTypeRepository accountTypeRepository;

    @Before
    public void setUp() throws Exception{

    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void getAccountTypeByMnemonicNativeQueryMiles(){
        AccountType miles = accountTypeRepository.getAccountTypeMnemonicNativeQuery("MILES");
        assertNotNull(miles);
        assertEquals("MILES",miles.getMnemonic());
    }

    @Test

    public void getAccountTypeByMnemonicNativeQuery(){
        AccountType miles = accountTypeRepository.getAccountTypeMnemonicNativeQuery("MILESSS");
        assertNull(miles);
    }

    @Test
    public void getAccountTypeByMnemonicMiles(){
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonic("MILES");
        assertNotNull(miles);
        assertEquals("MILES",miles.getMnemonic());

    }

    @Test
    public void getAccountTypeByMnemonicPlay(){
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonic("PLAY");
        assertNotNull(miles);
        assertEquals("PLAY",miles.getMnemonic());
    }

    @Test
    public void getAccountTypeByMnemonic(){
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonic("R");
        assertNull(miles);

    }

//    TODO Fix DTO
//    @Test
//    public void getAccountTypDtoByMnemonicMiles(){
//        AccountTypeDto miles = accountTypeRepository.getAccountTypeDtoByMnemonic("MILES")
//        assertNotNull(miles);
//        assertEquals("MILES",miles.getMnemonic());
//    }
}
