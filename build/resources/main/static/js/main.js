
var my_lat;
var my_lng;
//var my_address = [];
var my_main_address;
navigator.geolocation.getCurrentPosition(function(position) {
                        my_lat = position.coords.latitude, // 위도
                        my_lng = position.coords.longitude; // 경도
                         console.log( my_lat , my_lng );
                          alert("1-2 :"+my_lat);
                          alert("2-2 :"+my_lng);


//35.554719 127.215121
//36.457132 127.264553
                        getAddr(my_lat,my_lng);
            }); // 현재 내 위치의 위도경도 구하기 end

function getAddr(lat,lng){
                              let geocoder = new kakao.maps.services.Geocoder();

                              let coord = new kakao.maps.LatLng(lat, lng);
                              let callback = function(result, status) {
                                  if (status === kakao.maps.services.Status.OK) {
//                                      console.log(result);
//                                      alert("결과1: "+result);
                                console.log(result);
                                 console.log(typeof 'result');

                                 console.log(result[0].address.region_1depth_name);
                                 console.log(result[0].address)
//                                 my_main_address = JSON.stringify(result[0].address.region_1depth_name);
//                                   my_main_address = result[0].address.region_2depth_name;
                                   my_main_address = result[0].address;
//                                    my_main_address = result ;
                                     $.ajax({ 　　
                                                type:'post' 　　,
                                                contentType:'application/json', 　　
                                                data:JSON.stringify(my_main_address) ,
                                                url: '/test' 　　,
                                                success: function(data) { 　　
                                                　　alert(data); 　
                                                console.log(data);　},
                                                error:function(e){
                                                　　　　alert("error:"+e); 　　
                                                }
                                            });




//                                    toload(my_main_address);
                                  }


//                                console.log(my_main_address)
//
//                                  toaddress(my_main_address);





                              };
                                 geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);


    }

//function toaddress(address){
//
////
////     $.ajax({
////            url : "/local_area",
////            data: my_main_address,
////            success(re)
////            alert("ddddd");
////     })
//
//        $.ajax({ 　　
//            type:'post' 　　,
//            contentType:'application/json' 　　
//            data:JSON.stringify(address) 　　,
//            url: '/test' 　　,
//            success: function(data) { 　　
//            　　alert(data); 　　},
//            error:function(e){
//            　　　　alert("error:"+e); 　　
//            }
//        });
//
//
//}

function toload(address){

//    var my_lat;
//    var my_lng;
//
//    navigator.geolocation.getCurrentPosition(function(position) {
//                            my_lat = position.coords.latitude, // 위도
//                            my_lng = position.coords.longitude; // 경도
//                             console.log( my_lat , my_lng );
//                         alert("1-2 :"+my_lat);
//                         alert("2-2 :"+my_lng);
//                         var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
//                                    center : new kakao.maps.LatLng( my_lat , my_lng ), // 지도의 중심좌표
//                                    level : 5 // 지도의 확대 레벨
//                                });
//
//                }); // 현재 내 위치의 위도경도 구하기 end


    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
//            navigator.geolocation.getCurrentPosition(function(position) {
//                                    var my_lat = position.coords.latitude, // 위도
//                                    var my_lng = position.coords.longitude; // 경도
//                                         console.log( my_lat , my_lng );
//                                        alert("1-2 :"+my_lat);
//                                         alert("2-2 :"+my_lng);
//                                         });
            center : new kakao.maps.LatLng( my_lat ,  my_lng ), // 지도의 중심좌표
            level : 3 // 지도의 확대 레벨
        });

        // 마커 클러스터러를 생성합니다
        // 마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
        // 클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
        // 이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
        // 클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다
        var clusterer = new kakao.maps.MarkerClusterer({
            map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
            averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
            minLevel: 5, // 클러스터 할 최소 지도 레벨
            disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
        });
   console.log(my_main_address   );
    $.ajax({
        url: "/getlist" ,
        data: my_main_address,
         async: false,
        success: function( re ){


            let markers =  [ ]

               for( let i=0; i<re.length; i++ ){
                // 주소-좌표 변환 객체를 생성합니다
                           var geocoder = new kakao.maps.services.Geocoder();

                      var searchaddress = re[i].t_address_2nd;
                      if( searchaddress == "" ) searchaddress =  re[i].t_address_1st;
                    console.log( i );
                     console.log( searchaddress );

                         // 주소로 좌표를 검색합니다
                                  geocoder.addressSearch( searchaddress , function( result, status) {

                                            if( result.length > 0 ) {

                                            var marker = new kakao.maps.Marker({
                                                position : new kakao.maps.LatLng(  result[0].y , result[0].x  )
                                            });

                                           clusterer.addMarker(marker);

                                            }

                                  });

               }

//        // 클러스터러에 마커들을 추가합니다
//        clusterer.addMarkers( markers );
//        console.log( markers );
        console.log( clusterer );
    }


    }); // 비동기 end
//          var map_now = new kakao.maps.Map(mapContainer, mapOption);
//                                        kakao.maps.event.addListener(map_now, 'idle', function () {
//                                        			var message = '지도의 중심좌표는 ' + map.getCenter().toString() + ' 이고,' +
//                                        							'확대 레벨은 ' + map.getLevel() + ' 레벨 입니다.';
//                                        			console.log(message);
//                                        		});



}

