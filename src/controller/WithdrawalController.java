package controller;

public class WithdrawalController {
    private final com.company.repositories.interfaces.IWithdrawalRepository iWithdrawalRepository;

    public WithdrawalController(com.company.repositories.interfaces.IWithdrawalRepository iWithdrawalRepository) {
        this.iWithdrawalRepository = iWithdrawalRepository;
    }

    public String showWithdrawals(){
        String result = iWithdrawalRepository.showWithdrawals().toString();
        return result;
    }
