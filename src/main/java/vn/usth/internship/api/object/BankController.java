package vn.usth.internship.api.object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/bank")
public class BankController {
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private BankContentRepository bankContentRepository;
    @Autowired
    private BankInfoRepository bankInfoRepository;

    @GetMapping(value = "/")
    public List<BankInfo> findAllBank(){
        List<Bank> bankList = bankRepository.findAll();
        List<BankInfo> bankInfoList = new ArrayList<>();
        for(Bank bank : bankList){
            bankInfoList.add(bank.getInfo());
        }
        return bankInfoList;
    }
    @PreAuthorize("hasRole")
    @GetMapping(value = "/id/{id}")
    public Bank getBankbyID(@PathVariable String id){
        return bankRepository.findById(id).get();
    }



    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value="/add")
    public String insertBank(@RequestBody Bank bank){
        bankRepository.save(bank);
        return "New bank added";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value="/remove")
    public String removeBank(@RequestBody Bank bank){
        Bank tempBank = bankRepository.findById(bank.getId()).get();
        bankRepository.delete(tempBank);
        return "Bank deleted";
    }
    @GetMapping(value="/{id}")
    public BankContent findBankbyId(@PathVariable String id){
        Bank bank = bankRepository.findById(id).get();
        return bank.getContent();
    }


}
