package com.ynova.library.service;

import java.time.LocalDate;
import java.util.List;

import com.ynova.library.model.Loan;
import com.ynova.library.model.LoanReport;

public interface ILoanService {

    void registerLoan(Loan loan);

    List<Loan> listLoans();

    List<Loan> filterLoansByDnistudent(String studentDni);

    List<LoanReport> reportLoan(LocalDate startDate, LocalDate endDate);

}
