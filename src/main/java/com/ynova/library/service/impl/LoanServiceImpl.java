package com.ynova.library.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ynova.library.execption.DuplicateLoanException;
import com.ynova.library.execption.ErrorMessages;
import com.ynova.library.model.Loan;
import com.ynova.library.model.LoanReport;
import com.ynova.library.service.ILoanService;

public class LoanServiceImpl implements ILoanService {

    private final List<Loan> loans = new ArrayList<>();

    @Override
    public void registerLoan(Loan loan) {
        boolean isDuplicateLoans = loans.stream()
                .anyMatch(existingLoan -> existingLoan.getBook().equals(loan.getBook())
                        && existingLoan.getStudent().equals(loan.getStudent()));

        if (isDuplicateLoans) {
            throw new DuplicateLoanException(ErrorMessages.DUPLICATE_LOAN.formatMessage(loan));
        } else {
            loans.add(loan);
        }
    }

    @Override
    public List<Loan> listLoans() {
        return loans;
    }

    @Override
    public List<Loan> filterLoansByDnistudent(String studentDni) {
        return loans.stream()
                .filter(loan -> loan.getStudent().getDni().equals(studentDni)).toList();
    }

    @Override
    public List<LoanReport> reportLoan(LocalDate startDate, LocalDate endDate) {
        return loans.stream()
                .filter(loan -> (loan.getLoanDate().isEqual(startDate) || loan.getLoanDate().isAfter(startDate))
                        && (loan.getLoanDate().isEqual(endDate) || loan.getLoanDate().isBefore(endDate)))
                .map(loan -> new LoanReport(
                        loan.getBook().getTitle(),
                        loan.getBook().getAuthor(),
                        loan.getBook().getYear(),
                        loan.getLoanDate(),
                        loan.getReturnDate(),
                        loan.getStudent().getName()))
                .toList();
    }

}
