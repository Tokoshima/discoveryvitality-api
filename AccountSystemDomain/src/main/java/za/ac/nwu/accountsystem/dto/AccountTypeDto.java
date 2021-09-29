package za.ac.nwu.accountsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.accountsystem.persistence.AccountTransaction;
import za.ac.nwu.accountsystem.persistence.AccountType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class AccountTypeDto {



    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    private Set<AccountTransaction> accountTransactions;


    public AccountTypeDto( String mnemonic, String accountTypeName, LocalDate creationDate) {

        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public AccountTypeDto(AccountType accountType) {
        this.setMnemonic(accountType.getMnemonic());
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setCreationDate(accountType.getCreationDate());
    }

    public AccountTypeDto() {
    }

    @ApiModelProperty(position = 1,
            value = "AccountType Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Name",
            name = "Name",
            notes = "The name of the AccountType",
            dataType = "java.lang.String",
            example = "Miles",
            allowEmptyValue = false,
            required = true)
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @ApiModelProperty(position = 3,
            value = "AccountType Creation Date",
            name = "CreationDate",
            notes = "This is the date on which the AccountType was created",
            dataType = "java.lang.String",
            example = "2020-01-01",
            allowEmptyValue = true,
            required = false)
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Set<AccountTransaction> getAccountTransactions(){
        return accountTransactions;
    }


    public void setAccountTransactions(Set<AccountTransaction> accountTransactions){
        this.accountTransactions = accountTransactions;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @JsonIgnore
    public AccountType getAccountType(){
        return new AccountType(getMnemonic(),getAccountTypeName(), getCreationDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(mnemonic, that.getMnemonic()) && Objects.equals(accountTypeName, that.getAccountTypeName()) && Objects.equals(creationDate, that.getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash( mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
