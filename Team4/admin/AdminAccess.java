package Team4.admin;

public interface AdminAccess {
    String filterUserByPhoneNumber();
    String filterUserByAddress();
    String filterUserBySalary();
    int updateInterestRate();
    int updateLoadOption();
    String updateCreditCardPolicy();
}
