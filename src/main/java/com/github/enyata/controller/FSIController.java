package com.github.enyata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.enyata.bvnvalidations.impl.BVNValidationImpl;
import com.github.enyata.bvnvalidations.impl.BVNValidationRestServiceimpl;
import com.github.enyata.exceptions.EncryptionException;
import com.github.enyata.vo.GetSingleBVNResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FSIController {

    @Autowired
    BVNValidationRestServiceimpl bvnValidationRestServiceimpl;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello...";
    }

    @RequestMapping(value = "header", method = RequestMethod.GET)
    public GetSingleBVNResponse getSingleBVNResponse(){
        try {
            return bvnValidationRestServiceimpl.getSingleBVN("12345678901", "825c2d554381772a3d6b4106b76ef2b6","11111", "ANSwer@89","855BBEDD2C9BB87329D10C6FCF9FE379","229C1E111A45984F08512E7DD0B4E8AB");
        } catch (EncryptionException e) {
            e.printStackTrace();
            return null;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
