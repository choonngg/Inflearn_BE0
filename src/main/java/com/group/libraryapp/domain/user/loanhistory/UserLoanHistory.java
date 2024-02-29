package com.group.libraryapp.domain.user.loanhistory;

import javax.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private Long userId;
    private String bookName;
    private boolean isReturn = true;


    protected UserLoanHistory() {
    }

    public UserLoanHistory(Long userId, String bookName, boolean isReturn) {
        this.userId = userId;
        this.bookName = bookName;
        this.isReturn = isReturn;
    }

    public void returnBook() {
        this.isReturn = true;
    }
}
