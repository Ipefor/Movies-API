package com.mislata.pruebaLombok.domain.usecase.book;

import com.mislata.pruebaLombok.domain.model.Book;
import com.mislata.pruebaLombok.domain.model.ListWithCount;

public interface BookGetAllUseCase {

    public ListWithCount<Book> execute(int page, int pageSize);
}
