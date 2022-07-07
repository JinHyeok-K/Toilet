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
////    }
//    @RequestMapping(value="/getlist", method=RequestMethod.POST)
//    public String getlist(@RequestBody MemberVO memberVO) throws Exception {
//
//        return "memberModify";
//    }



    @GetMapping("/getlist")
    public @ResponseBody void index(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @RequestParam Map<String,Object> param){
        System.out.println("123123123");
        try {
            System.out.println(param);
            String location1 = (String) param.get("location1");
            System.out.println(location1);
            String location2 = (String) param.get("location2");
            System.out.println(location2);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            System.out.println("asdasdasd: " + toiletSerivece.getlist(location1,location2) );
            response.getWriter().println(   toiletSerivece.getlist(location1,location2)  );
        }catch (Exception e){ System.out.println(e);}


    }

//    @ResponseBody
//    @PostMapping("/test")
//    public List<Map<String, Object>> test(@RequestBody List<Map<String,Object>>param){
//        System.out.println(param);
////        String local_area =test(param.get("region_2depth_name");
//        return param;
//
//    }
//    @ResponseBody
//    @PostMapping("/test")
//    public List<Map<String, Object>> test(@RequestBody List<Map<String,Object>>param){
//        List<ArrayList> result = new ArrayList<>();
//        System.out.println("파라미터 : " +param);
//        result.add((ArrayList) param);
//
////        System.out.println("파라미터? : " +result.get());
//
////        JSONArray jsonArray = new JSONArray(param);
////        System.out.println("jsonArray:"+jsonArray);
////        System.out.println("jsonArray.length():"+jsonArray.length());
////        System.out.println("result:"+result);
////        JSONObject jsonObject = new JSONObject();
////        jsonObject.put("address",jsonArray.toString());
////        System.out.println("AAAAAAA"+jsonObject);
////        System.out.println( jsonObject.getString("address."));
////        System.out.println("jsonArray.getString(1):"+jsonArray.getJSONArray(0));
//
//


//        return param;

//    }
    @GetMapping("/test")
    public String test(@RequestParam(required=false) String location ){
        System.out.println("location :"+location);

        return null;
    }





}
