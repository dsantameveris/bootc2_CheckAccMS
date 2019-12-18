package com.everis.CheckAccMS.Model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CheckAccs")
public class CheckAccount
{
    @Id
    private String Id;

    @NotBlank
    private String number;

    @NotBlank
    private String owner;

    @NotBlank
    private String currency;

    @NotBlank
    private double balance = 0.00;
}