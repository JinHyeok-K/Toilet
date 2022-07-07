package tcon.service;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcon.domain.ToiletEntity;
import tcon.domain.ToiletRepository;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


@Service

public class ToiletSerivece {

    @Autowired
    private ToiletRepository toiletRepository;

    public String local ;
//    public void local_area(){
//
//        local = area;
//        return local;
//    }



    public JSONArray getlist(String param1, String param2 ){
        List<ToiletEntity>  list =   toiletRepository.findallt_address_2nd(param1,param2);


        JSONArray jsonArray = new JSONArray();


        for( ToiletEntity toilet : list ){

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("t_name" , toilet.getT_name()); // 화장실 명
            jsonObject.put("t_address_1st" , toilet.getT_address_1st()); // 도로명 주소
            jsonObject.put("t_address_2nd" , toilet.getT_address_2nd() ); // 지번 주소
            jsonObject.put("t_open_time",toilet.getT_open_time()); // 개방 시간
            jsonObject.put("t_combine",toilet.getT_combine()); // 공용 여부
            jsonObject.put("t_man_big",toilet.getT_man_big()); // 남성용 대변기 수
            jsonObject.put("t_man_small",toilet.getT_man_small());// 남성용 소변기 수
            jsonObject.put("t_man_big_sick",toilet.getT_man_big_sick()); // 남성 장애인용 대변기 수
            jsonObject.put("t_man_small_sick",toilet.getT_man_big_sick());// 남성 장애인용 소변기 수
            jsonObject.put("t_man_big_baby",toilet.getT_man_big_baby()); // 남자 어린이용 대변기 수
            jsonObject.put("t_man_small_baby",toilet.getT_man_small_baby());//남자 어린이용 소변기 수
            jsonObject.put("t_woman_big",toilet.getT_woman_big()); // 여성용 대변기 수
            jsonObject.put("t_woman_big_sick",toilet.getT_man_big_sick());// 여성 장애인용 대변기 수
            jsonObject.put("t_woman_big_baby",toilet.getT_man_big_baby());// 여자 어린이용 대변기 수
            jsonArray.put(jsonObject);

        }

        return jsonArray;
    }

    @Autowired
    private HttpServletRequest request;




}
