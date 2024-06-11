package com.philipApp.bookSearchApp.controllers;

import com.philipApp.bookSearchApp.dtos.requests.LoginRequest;
import com.philipApp.bookSearchApp.dtos.requests.RegisterUserRequest;
import com.philipApp.bookSearchApp.dtos.requests.SearchBookRequest;
import com.philipApp.bookSearchApp.dtos.responses.ApiResponse;
import com.philipApp.bookSearchApp.dtos.responses.BookSearchResp;
import com.philipApp.bookSearchApp.dtos.responses.LoginResponse;
import com.philipApp.bookSearchApp.dtos.responses.RegisterResponse;
import com.philipApp.bookSearchApp.exceptions.BookSearchAppException;
import com.philipApp.bookSearchApp.exceptions.InvalidDetailsException;
import com.philipApp.bookSearchApp.exceptions.UserExistException;
import com.philipApp.bookSearchApp.model.BookSearchResponse;
import com.philipApp.bookSearchApp.model.GutendexBook;
import com.philipApp.bookSearchApp.model.User;
import com.philipApp.bookSearchApp.services.AppUserService;
import com.philipApp.bookSearchApp.services.GutendexBookSearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final AppUserService userService;
    private final GutendexBookSearchService bookSearchService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody
                                                         RegisterUserRequest request) throws UserExistException, InvalidDetailsException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.registerUser(request));
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        try {
            userService.login(loginRequest);
            return "Login successful";
        } catch (BookSearchAppException bookSearchAppException) {
            return bookSearchAppException.getMessage();
        }
    }

    @PostMapping("/store")
    public ResponseEntity<?> searchForBook(@RequestBody SearchBookRequest searchBookRequest) {
        BookSearchResp response = new BookSearchResp();
        try {
            userService.addBookToReadingList(searchBookRequest);
            response.setMessage("Book added successfully");
            return new ResponseEntity<>(new ApiResponse<>(response), HttpStatus.CREATED);
        } catch (BookSearchAppException bookSearchAppException) {
            response.setMessage(bookSearchAppException.getMessage());
            return new ResponseEntity<>(new ApiResponse<>(response), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam String email) {
//        LoginResponse response = new LoginResponse();
        userService.logout(email);
//        response.setMessage("Logout Successful");
        return new ResponseEntity<>(new ApiResponse<>(), HttpStatus.GONE);
    }

    @GetMapping("/search")
    public ResponseEntity<GutendexBook> findBook(@RequestParam String email) {
        System.out.println("it is finished");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookSearchService.findBook(email));



//        try{
//            bookSearchService.findBook(email);
//            response.setMessage("found successful");
//            return ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body(bookSearchService.findBook(email));
//        }catch ( BookSearchAppException ex){
//            response.setMessage(ex.getMessage());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bookSearchService.findBook(email));
//        }
//    }

    }
}
