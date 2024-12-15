package com.demospring.controller;

import com.demospring.dto.request.UserRequestDTO;
import com.demospring.dto.response.ResponseData;
//import com.demospring.dto.response.ResponseSuccess;

import com.demospring.dto.response.ResponseError;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
//    Des API
//    @Operation(summary = "summary", description = "description", responses = {
//            @ApiResponse(responseCode = "201", description = "user added successfully",
//            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
//            examples = @ExampleObject(name = "ex name", summary = "ex summary",
//            value = """
//                    {
//                    "status": 201,
//                    "message": "User added successfully",
//                    "data": 1
//                    }
//                    """
//
//            )))
//    })

//    @PostMapping(value = "/", headers = "apiKey=v1.0")
    @PostMapping("/")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO userDTO){
        System.out.println("Request add user" + userDTO.getFirstName());
        return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Can not create user" );

//        return new ResponseData<>(HttpStatus.CREATED.value(), "User add succesfull", 1) ;
    }

    @PutMapping("/{userId}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseData<?> updateUser( @Min(1) @PathVariable int userId,@Valid @RequestBody UserRequestDTO userDTO) {
        System.out.println("Request update userId" +userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User add succesfull") ;
    }

    @PatchMapping("/{userId}")
    public ResponseData<?> changeStatus(@Min(1) @PathVariable int userId,@RequestParam boolean status ){
        System.out.println("Request change" +userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User changed succesfull") ;
    }

    @DeleteMapping("/{userId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseData<?> deleteUser(@Min(1) @PathVariable int userId){
        System.out.println("Request delete"+userId);
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User changed succesfull") ;

    }

    @GetMapping("/{userId}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseData<UserRequestDTO> getUser(@PathVariable int userId) {

        System.out.println("Request get user detail by userId" + userId);
        return new ResponseData<>(HttpStatus.OK.value(), "user",
                new UserRequestDTO("tay","java", "phone","email")) ;

    }

    @GetMapping("/list")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseData<List<UserRequestDTO>> getAllUser(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) String email) {
        System.out.println("Request get user list");
        return new ResponseData<>(HttpStatus.OK.value(), "user",
        List.of(new UserRequestDTO("tay","java", "phone","email")));


    }

}
