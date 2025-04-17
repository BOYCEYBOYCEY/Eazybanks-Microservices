package com.eazybytes.accounts.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "accounts")
public class AccountsInfoContactDto {

    private String message;
    private Map<String,String>contactDetails;
    private List<String> onCallSupport;



}
