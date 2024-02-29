package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {

        // 1. 책 정보를 가져오기
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        // 2. 대출 기록 확인 -> 대출중인지 확인
        // 3. 만약 대출중이면 예외발생
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            throw new IllegalArgumentException("이미 대출되어있는데?");
        }

        // 4. 유저 정보 가져오기
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        // 5. 유저정보와 책정보 기반으로 UserLoanHistory 저장
        userLoanHistoryRepository.save(new UserLoanHistory(user.getId(), book.getName(), false));
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {

        // 1. 책 정보를 가져오기
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        // 2. 대출 기록 확인 -> 반납했는지 확인
        // 3. 만약 반납했다면 예외발생
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), true)) {
            throw new IllegalArgumentException("이미 반납했는뎅?");
        }

        // 4. 히스토리 불러와서 반납으로 수정
        UserLoanHistory userLoanHistory = userLoanHistoryRepository.findByBookName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);
        userLoanHistory.returnBook();

        // 5. 히스토리 업데이트
        userLoanHistoryRepository.save(userLoanHistory);
    }
}
