package com.amouri_coding.book_network.book;

import com.amouri_coding.book_network.file.FileUtils;
import com.amouri_coding.book_network.history.BookTransactionHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookMapper {

    public Book toBook(BookRequest request) {
        return Book.builder()
                .id(request.id())
                .title(request.title())
                .authorName(request.authorName())
                .isbn(request.isbn())
                .synopsis(request.synopsis())
                .archived(false)
                .shareable(request.shareable())
                .build()
                ;
    }

    public BookResponse toBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .isbn(book.getIsbn())
                .synopsis(book.getSynopsis())
                .rate(book.getRating())
                .shareable(book.isShareable())
                .archived(book.isArchived())
                .owner(book.getOwner().fullName())
                .bookCover(FileUtils.readFileFromLocation(book.getBookCover()))
                .build()
                ;
    }

    public BorrowedBookResponse toBorrowedBookResponse(BookTransactionHistory history) {
        return BorrowedBookResponse.builder()
                .id(history.getBook().getId())
                .title(history.getBook().getTitle())
                .authorName(history.getBook().getAuthorName())
                .isbn(history.getBook().getIsbn())
                .rate(history.getBook().getRating())
                .returned(history.isReturned())
                .returnApproved(history.isReturnApproved())
                .build()
                ;
    }
}
