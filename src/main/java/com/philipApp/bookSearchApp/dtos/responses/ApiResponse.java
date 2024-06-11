package com.philipApp.bookSearchApp.dtos.responses;

//import com.philipApp.bookSearchApp.model.Book;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private T data;

}
