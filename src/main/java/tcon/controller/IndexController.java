package tcon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tcon.domain.ToiletEntity;
import tcon.service.ToiletSerivece;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class IndexController {


    @Autowired
    private ToiletSerivece toiletSerivece;

    @GetMapping("/getlist")
    public void index( HttpServletResponse response){

        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println(   toiletSerivece.getlist()  );

        }catch (Exception e){ System.out.println(e);}


    }


}
