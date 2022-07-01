package tcon.service;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.*;
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

    public List<ToiletEntity> getlist(){
        List<ToiletEntity>  list =   toiletRepository.findallt_address_2nd("세종");

        for( ToiletEntity toilet : list ){

                Float[] floats = findGeoPoint(  "경기도 안산시 상록구 광덕1로 375" );

        }

        return null;
    }

    public  Float[] findGeoPoint(String location) {

        if (location == null) return null;


        Geocoder geocoder = new Geocoder();
        // setAddress : 변환하려는 주소 (경기도 성남시 분당구 등)
        // setLanguate : 인코딩 설정

        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(location).setLanguage("ko")
                .getGeocoderRequest();

        GeocodeResponse geocoderResponse;

        try {
             geocoder = new Geocoder();
             geocoderResponse = geocoder.geocode(geocoderRequest);

            System.out.println(  "asdasd : " +  geocoderResponse  );

            if (geocoderResponse.getStatus() == GeocoderStatus.OK & !geocoderResponse.getResults().isEmpty()) {
                GeocoderResult geocoderResult=geocoderResponse.getResults().iterator().next();
                LatLng latitudeLongitude = geocoderResult.getGeometry().getLocation();

                System.out.println(  "asdasd : " +  latitudeLongitude  );

                Float[] coords = new Float[2];
                coords[0] = latitudeLongitude.getLat().floatValue();
                coords[1] = latitudeLongitude.getLng().floatValue();

            return coords;

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
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
