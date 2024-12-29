package com.macaron.ezordermw.service;

import org.springframework.stereotype.Service;

@Service
public class ApiService {

    public String getApiStatusResponse(String ret,String status)
    {
        return String.format("ret=%s\nvar=status,%s",ret,status);
    }


    public String getApiCPhoneResponse(String ret,String cPhone)
    {
        return String.format("ret=%s\nvar=cPhone,%s",ret,cPhone);
    }

    public String getApiAPhoneResponse(String ret,String aPhone)
    {
        return String.format("ret=%s\nvar=aPhone,%s",ret,aPhone);
    }
}
