package za.ac.nwu.accountsystem.translator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.accountsystem.domain.persistence.AccountType;
import za.ac.nwu.accountsystem.domain.dto.AccountTypeDto;
import za.ac.nwu.accountsystem.repo.persistence.AccountTypeRepository;
import za.ac.nwu.accountsystem.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;


@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountTypeTranslatorImpl.class);


    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository){
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes(){

        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try{
            for (AccountType accountType: accountTypeRepository.findAll()){
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to get All Account Types from DB",e);
        }
        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto){
        try{
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        }catch (Exception e){
            throw new RuntimeException("Unable to get All Account Types from DB",e);

        }
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){
        try{
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            LOGGER.info("ACCOUNT TYPE TRANSLATOR getAccountTypeByMnemonic : This is the acountType {}",accountType);
            return new AccountTypeDto(accountType);
        }catch (Exception e){
            throw new RuntimeException("Unable to get Account Type from Mnemonic from DB",e);
        }


    }
    @Override
    public AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic){

        try{
            AccountType accountType = accountTypeRepository.getAccountTypeMnemonicNativeQuery(mnemonic);
            return new AccountTypeDto(accountType);
        }catch (Exception e){
            throw new RuntimeException("Unable to get Account Type form Mnemonic Native Query from DB",e);
        }
    }
//    @Override
//    public AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic){
//
//        return accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);
//    }



}
