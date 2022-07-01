





toload();

function toload(){
    var my_lat;
    var my_lng;
    navigator.geolocation.getCurrentPosition(function(position) {
                        my_lat = position.coords.latitude, // 위도
                        my_lng = position.coords.longitude; // 경도
                         console.log( my_lat , my_lng );
            }); // 현재 내 위치의 위도경도 구하기 end


    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
            center : new kakao.maps.LatLng( my_lat , my_lng), // 지도의 중심좌표
            level : 5 // 지도의 확대 레벨
        });

        // 마커 클러스터러를 생성합니다
        // 마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
        // 클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
        // 이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
        // 클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다
        var clusterer = new kakao.maps.MarkerClusterer({
            map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
            averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
            minLevel: 10, // 클러스터 할 최소 지도 레벨
            disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
        });

    $.ajax({
        url: "/getlist" ,
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
          var map_now = new kakao.maps.Map(mapContainer, mapOption);
                                        kakao.maps.event.addListener(map_now, 'idle', function () {
                                        			var message = '지도의 중심좌표는 ' + map.getCenter().toString() + ' 이고,' +
                                        							'확대 레벨은 ' + map.getLevel() + ' 레벨 입니다.';
                                        			console.log(message);
                                        		});



}

