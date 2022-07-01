package tcon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tcon.domain.ToiletEntity;
import tcon.service.ToiletSerivece;

import java.util.List;

@RestController
public class IndexController {


    @Autowired
    private ToiletSerivece toiletSerivece;

    @GetMapping("/")
    public List<ToiletEntity> index(){


        return  toiletSerivece.getlist();


    }


}
