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



    public JSONArray getlist( ){
        List<ToiletEntity>  list =   toiletRepository.findallt_address_2nd("안산시 상록구");


        JSONArray jsonArray = new JSONArray();


        for( ToiletEntity toilet : list ){

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("t_name" , toilet.getT_name());
            jsonObject.put("t_address_1st" , toilet.getT_address_1st());
            jsonObject.put("t_address_2nd" , toilet.getT_address_2nd() );

            jsonArray.put(jsonObject);

        }

        return jsonArray;
    }

    @Autowired
    private HttpServletRequest request;

//    public
//        Map<String, List<Map<String,String>>>
//        toilet_list(Map<String,String> Location){
//
//        List< Map<String,String>> Toiletlist = new ArrayList<>();
//
//        double qa = Double.parseDouble(   Location.get("qa")    );
//        double pa = Double.parseDouble(   Location.get("pa")    );
//        double ha = Double.parseDouble(   Location.get("ha")    );
//        double oa = Double.parseDouble(   Location.get("oa")    );
//
//
//        List<ToiletEntity> toiletEntityList = toiletRepository.findAll();
//
//        for( ToiletEntity entity : toiletEntityList){
//
//            if (
////                    Double.parseDouble(  entity.getRlat() ) > qa
////                    && Double.parseDouble(  entity.getRlat() ) < pa
////                    && Double.parseDouble(  entity.getRlon() )   > ha
////                    && Double.parseDouble(  entity.getRlon() )   < oa
//
//            ){
//                Map<String,String> map = new HashMap<>();
//                map.put("t_num",entity.getTnum()+"");
//                map.put("t_type",entity.getT_type());
//                map.put("t_name",entity.getT_name());
//                map.put("t_combine",entity.getT_combine());
//
//
//            }
//
//        }
//
//    }


}
