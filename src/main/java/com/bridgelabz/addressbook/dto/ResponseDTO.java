package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseDTO {
    private String message;
    private Object data;

//    public ResponseDTO(String message, Object data){
//        this.message = message;
//        this.data = data;
//    }
}
