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

//    @PostMapping("/getlist")
//    public void index( HttpServletResponse response){
//
//        try {
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
////            response.getWriter().println("local");
//           JSONArray jsonArray= ;
//            System.out.println(A);
//            response.getWriter().println(   toiletSerivece.getlist()  );
//
//        }catch (Exception e){ System.out.println(e);}
//
//
//    }

    @PostMapping("/getlist")
    public void index(HttpServletRequest request, HttpServletResponse response, String param){

        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
//            response.getWriter().println("local");
            JSONArray jsonArray =new JSONArray();
//            jsonArray = request.get("param");
//            System.out.println("dddd :" +A);
            response.getWriter().println(   toiletSerivece.getlist()  );

        }catch (Exception e){ System.out.println(e);}


    }

//    @ResponseBody
//    @PostMapping("/test")
//    public List<Map<String, Object>> test(@RequestBody List<Map<String,Object>>param){
//        System.out.println(param);
////        String local_area =test(param.get("region_2depth_name");
//        return param;

//    }
    @ResponseBody
    @PostMapping("/test")
    public List<Map<String, Object>> test(@RequestBody List<Map<String,Object>>param){

        System.out.println("파라미터 : " +param);
//        List<ArrayList> result = new ArrayList<>();
//        JSONArray jsonArray = new JSONArray(param);
//        System.out.println("jsonArray:"+jsonArray);
//        System.out.println("jsonArray.length():"+jsonArray.length());
//        System.out.println("result:"+result);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("address",jsonArray.toString());
//        System.out.println("AAAAAAA"+jsonObject);
//        System.out.println( jsonObject.getString("address."));
//        System.out.println("jsonArray.getString(1):"+jsonArray.getJSONArray(0));


        return param;
    }


//    @ResponseBody
//    @PostMapping(value = {"/test"})
//    public Map<String, Object> test(@RequestParam Map<String, Object> params, HttpServletRequest req, HttpServletResponse res) {
//        System.out.println("빠빰:"+params);
//        Map<String, Object> result = new HashMap<>();
//        result.put("address", "region_2depth_name");
////        result.put("resultMsg", "post 통신이 성공하였습니다.");
//        System.out.println(params);
//        return result;
//    }


}
