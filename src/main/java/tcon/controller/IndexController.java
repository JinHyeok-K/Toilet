package tcon.controller;


import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tcon.service.ToiletSerivece;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Getter
public class IndexController {


    @Autowired
    private ToiletSerivece toiletSerivece;



    @GetMapping("/getlist")
    public @ResponseBody void index(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @RequestParam Map<String,Object> param){

        try {
            //System.out.println(param);
            String location1 = (String) param.get("location1");
            //System.out.println(location1);
            String location2 = (String) param.get("location2");
            //System.out.println(location2);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            response.getWriter().println(   toiletSerivece.getlist(location1,location2)  );
        }catch (Exception e){ System.out.println(e);}


    }





}
