//package za.ac.nwu.accountsystem.logic.flow.impl;
//
//import za.ac.nwu.accountsystem.domain.persistence.AccountType;
//
//public class FetchAccountTypeFlowTest {
//
//
//    private FetchAccountTypeFlowImpl testClass;
//
//    public void setUp() throws  Exception {
//        testClass = new FetchAccountTypeFlowImpl(null, accountTypeRepository);
//    }
//
//    public void tearDown() throws Exception{
//
//    }
//
//    public void getAllAccountTypes(String mnemonic){
//
//        assertThat(getAllAccountTypes("",), containsInAnyOrder("c", "b", "a"));
//
//    }
//
//    @Test
//    public void getAccountTypeByMnemonicPlay(){
//        AccountType miles = accountTypeRepository.getAccountTypeByMnemonic("PLAY");
//        assertNotNull(miles);
//        assertEquals("PLAY",miles.getMnemonic());
//    }
//
//    @Test
//    public void getAccountTypeByMnemonic(){
//        AccountType miles = accountTypeRepository.getAccountTypeByMnemonic("R");
//        assertNull(miles);
//
//    }
//}
