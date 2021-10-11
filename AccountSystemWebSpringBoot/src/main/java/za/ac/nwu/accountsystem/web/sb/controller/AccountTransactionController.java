package za.ac.nwu.accountsystem.web.sb.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.accountsystem.domain.dto.AccountTransactionDto;
import za.ac.nwu.accountsystem.domain.service.GeneralResponse;
import za.ac.nwu.accountsystem.logic.flow.AddTransactionFlow;
import za.ac.nwu.accountsystem.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.accountsystem.logic.flow.FetchAccountTransactionFlow;

import java.util.List;


@RestController
@RequestMapping("Account-Transaction")
public class AccountTransactionController {


    private CreateAccountTransactionFlow createAccountTransactionFlow;
    private FetchAccountTransactionFlow fetchAccountTransactionFlow;
    private AddTransactionFlow addTransactionFlow;


    public AccountTransactionController(CreateAccountTransactionFlow createAccountTransactionFlow, FetchAccountTransactionFlow fetchAccountTransactionFlow, AddTransactionFlow addTransactionFlow) {
        this.createAccountTransactionFlow = createAccountTransactionFlow;
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
        this.addTransactionFlow = addTransactionFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountTransaction", notes = "Creates a new AccountTransaction in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The AccountTransaction was created succesfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
        @ApiParam(value = "Request body to create a new AccountTransaction", required = true)
        @RequestBody AccountTransactionDto AccountTransaction){

        AccountTransactionDto AccountTransactionResponse = createAccountTransactionFlow.create(AccountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true,AccountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    @PutMapping("/add/{mnemonic}/{amount}")
//    @ApiOperation(value = "Add miles to specified mnemonic by account", notes = "Adds specified miles to the associated mnemonic in account table ")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Transaction was created succesfully", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//    public ResponseEntity<GeneralResponse<AccountTransactionDto>> addMiles(
//            @ApiParam(value = "Request body to create a new AccountTransaction", required = true)
//            @PathVariable("mnemonic") final String mnemonic,
//            @PathVariable("amount") final Long amount)
//    {
//
//        AccountTransactionDto AccountTransactionResponse = addTransactionFlow.addMiles(mnemonic,amount);
//        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true,AccountTransactionResponse);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }


//    @RequestMapping(path = "/mno/objectKey/{id}/{name}", method = RequestMethod.GET)
//    public Book getBook(@PathVariable int id, @PathVariable String name) {
//        // code here
//    }
//    @PutMapping("/employees/{id}")
//    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(employee -> {
//                    employee.setName(newEmployee.getName());
//                    employee.setRole(newEmployee.getRole());
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
//                });
//    }


    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll(){

        List<AccountTransactionDto> AccountTransactions = fetchAccountTransactionFlow.getAllAccountTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, AccountTransactions);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{transactionId}")
    @ApiOperation(value = "Fetches the specified AccountTransaction", notes = "Fetches the AccountTransaction corresponding to the given transactionId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountTransaction Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransaction(
            @ApiParam(value = "The transactionId that uniquely identifies the AccountTransaction",
            example = "5002",
            name = "transactionId",
            required = true)
            @PathVariable("transactionId") final Long transactionId){

        AccountTransactionDto AccountTransaction = fetchAccountTransactionFlow.getAccountTransactionById(transactionId);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransaction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
