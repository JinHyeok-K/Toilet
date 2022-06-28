package tcon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcon.domain.ToiletEntity;
import tcon.domain.ToiletRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ToiletSerivece {

    @Autowired
    private ToiletRepository toiletRepository;

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
