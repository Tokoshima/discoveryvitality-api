package za.ac.nwu.accountsystem.translator.impl;

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
            throw new RuntimeException("Error 404");
        }
        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto){
        AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
        return new AccountTypeDto(accountType);

    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){

        AccountType accountType = accountTypeRepository.getAccountTypeMnemonicNativeQuery(mnemonic);
        return new AccountTypeDto(accountType);
    }
    @Override
    public AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic){

        AccountType accountType = accountTypeRepository.getAccountTypeMnemonicNativeQuery(mnemonic);
        return new AccountTypeDto(accountType);
    }
//    @Override
//    public AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic){
//
//        return accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);
//    }

}
