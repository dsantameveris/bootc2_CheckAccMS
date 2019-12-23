package com.everis.CheckAccMS.DTO;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CheckAccountDTO
{
    @NotBlank
    private String number;

    @NotBlank
    private String currency;

    public CheckAccountDTO(String number, String currency)
    {
        this.number = number;
        this.currency = currency;
    }

    public CheckAccountDTO()
    {
        
    }
}