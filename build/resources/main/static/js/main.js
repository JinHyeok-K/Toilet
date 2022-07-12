
var my_lat;
var my_lng;
//var my_address = [];
//let test_lat = 37.398530;
//let test_lng = 126.927358;
//35.356803 126.657096
//34.959553 126.776534
//37.269062 127.055567
//37.398530 126.927358
navigator.geolocation.getCurrentPosition(function(position) {
                        my_lat = position.coords.latitude, // 위도
                        my_lng = position.coords.longitude; // 경도
// test lat, lng
//my_lat =test_lat;
//my_lng =test_lng;
                        getAddr(my_lat,my_lng);
            }); // 현재 내 위치의 위도경도 구하기 end

function getAddr(lat,lng){
                              let geocoder = new kakao.maps.services.Geocoder();

                              let coord = new kakao.maps.LatLng(lat, lng);
                              let callback = function(result, status) {
                                  if (status === kakao.maps.services.Status.OK) {

                                console.log(result);
                                 console.log(typeof 'result');

                                let location1 = result[0].address.region_1depth_name; // 접속위치의 시, 구 정보
                                let location2 = result[0].address.region_2depth_name; // 접속위치의 시, 구 정보
                                if (location1 == '전남') {
                                    location1 ='전라남도'

                                }else if (location1 =='전북'){
                                     location1 ='전라북도'
                                }else if (location1 == '충북'){
                                     location1 ='충청북도'
                                }else if (location1 =='충남'){
                                  location1 ='충청남도'
                             }else if (location1 == '경북'){
                                  location1 ='경상북도'
                             }else if (location1 == '경남'){
                                    location1 ='경상남도'
                             }
                                    console.log(location1,location2);

                                    toload(location1,location2); // 접속 위치 시, 구 기반 화장실 리스트 불러오기
                                  }
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

function toload(address1,address2){


    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div

            center : new kakao.maps.LatLng( my_lat ,  my_lng ), // 지도의 중심좌표
            level : 2 // 지도의 확대 레벨
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
    map.setMaxLevel(7); // 7레벨 까지만 축소 가능
    let param = { "location1":address1,"location2":address2} // 접속 위치 정보 반환용 변수

    let my_marker = new kakao.maps.Marker({
        position : new kakao.maps.LatLng( my_lat , my_lng  ),
        clickable: true
    });
    my_marker.setMap(map);
    let my_message = '<div style= "display: block;  background: #50627F;  color: #fff; text-align: center; '+
                                  'height: 24px; line-height:22px; border-radius:5px; padding:0px 10px;" > 여 기 계 시 나 요? &nbsp; <span>&nbsp;   </span> </div>';
    let myiwContent = my_message,
        myiwRemoveable = true;

    let myinfowindow = new kakao.maps.InfoWindow({
        content : myiwContent,
        removable: myiwRemoveable
    })
     myinfowindow.open(map, my_marker);



    $.ajax({
        url: "/getlist" ,
        dataType: "json",
        data: param,
        async: false,
        success: function( re ){


            let markers =  [ ]



               for( let i=0; i<re.length; i++ ){

                // 주소-좌표 변환 객체를 생성합니다
                           let geocoder = new kakao.maps.services.Geocoder();

                      let searchaddress = re[i].t_address_2nd; // n번째 화장실 주소

                      let searchtoilet_name = re[i].t_name; // n번째 화장실 이름
                      let searchtoilet_open_time = re[i].t_open_time;// n번째 화장실 개방 시간
                      let searchtoilet_t_man_big = re[i].t_man_big;// n번째 화장실 남성용 대변기 수
                      let searchtoilet_t_man_small = re[i].t_man_small;// n번째 화장실 남성용 대변기 수
                      let searchtoilet_t_man_big_sick = re[i].t_man_big_sick;// n번째 화장실 장애인 남성 대변기 수
                      let searchtoilet_t_man_small_sick = re[i].t_man_small_sick;// n번째 화장실 장애인 남성 소변기 수
                       let searchtoilet_t_man_big_baby = re[i].t_man_big_baby;// n번째 화장실 장애인 남성 대변기 수
                        let searchtoilet_t_man_small_baby = re[i].t_man_small_baby;// n번째 화장실 장애인 남성 소변기 수

                      let searchtoilet_t_woman_big = re[i].t_woman_big;// n번째 화장실 남성용 대변기 수
                      let searchtoilet_t_woman_big_sick = re[i].t_woman_big_sick;// n번째 화장실 장애인 남성 대변기 수
                      let searchtoilet_t_woman_big_baby = re[i].t_woman_big_baby;// n번째 화장실 장애인 남성 소변기 수

                      if( searchaddress == "" || searchaddress.length<=3 ) searchaddress =  re[i].t_address_1st;
//                          console.log( i );
//                          console.log( searchaddress );
//                          console.log( searchaddress.length );
                         // 주소로 좌표를 검색합니다
                                  geocoder.addressSearch( searchaddress , function( result, status) {

                                            if( result.length > 0 ) {

                                            let marker = new kakao.maps.Marker({
                                                position : new kakao.maps.LatLng(  result[0].y , result[0].x  ),
                                                clickable: true
                                            });

                                             let iwContent = '<div style="margin-right: 10px; ">'+
//, style="margin-right: 10px;
                                                                '<br>화장실 이름 :' + searchtoilet_name+'<br>'+
                                                                '주소 :' + searchaddress+'<br>'+
                                                                '개방 시간 : '  + searchtoilet_open_time +'<br><br>'+
                                                                '===== 화장실 시설 내역 ===== <br>'+
                                                                '           <ul style="list-style: none;  padding-left: 0px; " > '+
                                                                '           <li> 남성용 대변기 수 : ' + searchtoilet_t_man_big    +'개</li>'+
                                                                '           <li> 남성용 소변기 수 : ' + searchtoilet_t_man_small    +'개    </li>'+
                                                                '           <li> 장애인 남성 대변기 수 : ' + searchtoilet_t_man_big_sick    +'개 </li>'+
                                                                '           <li> 장애인 남성 소변기 수 : ' + searchtoilet_t_man_small_sick    +'개 </li>'+
                                                                '           <li> 남자 어린이 대변기 수 : ' + searchtoilet_t_man_big_baby    +'개 </li>'+
                                                                '           <li> 남자 어린이 소변기 수 : ' + searchtoilet_t_man_small_baby    +'개 </li><br>'+
                                                                '           <li> 여성 대변기 수 : ' + searchtoilet_t_woman_big    +'개 </li>'+
                                                                '           <li> 장애인 여성 대변기 수 : ' + searchtoilet_t_woman_big_sick    +'개 </li>'+
                                                                '           <li> 여자 어린이 대변기 수 : ' + searchtoilet_t_woman_big_baby    +'개 </li>'+
                                                                '           '+
                                                                '       </ul>'+
                                                                '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                                                 iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
                                             // 인포윈도우를 생성합니다

//                                             let infowindow = new kakao.maps.InfoWindow({
////                                                 content : re[i].iwContent,
//                                                 content : iwContent,
//
//
//                                             });
                                                let infowindow = new kakao.maps.InfoWindow({
//                                                     position:  new kakao.maps.LatLng( result[0].y , result[0].x),
                                                     content: '<div class=info-title style="width:300px; height:400px; padding:5px;"> '+iwContent  + '</div>',
                                                                                                    // 인포윈도우 내부에 들어갈 컨텐츠 입니다.
                                                 });
//                                                 mLabel.open(map, marker);
//
                                             // 마커에 클릭이벤트를 등록합니다
                                              kakao.maps.event.addListener(marker, 'click', function() {
                                                    // 마커 위에 인포윈도우를 표시합니다
                                                    infowindow.open(map, marker);
                                              kakao.maps.event.addListener(map,'click',function(){
                                                infowindow.close();
                                              });
                                              });
                                           clusterer.addMarker(marker);


                                            }

                                  });

               }
//               error(e)
//               console.log(e);



//        console.log( clusterer );
    },
    error:function(request,status,error){
    alert("code="+request.status+"message="+request.responseText+"error="+error);//
    }









    }); // 비동기 end : 접속 위치 기반 주변 화장실 정보

        let infoTitle = document.querySelectorAll('.info-title');
                   infoTitle.forEach(function(e) {
                       let w = e.offsetWidth + 10;
                       let ml = w/2;
                       e.parentElement.style.top = "82px";
                       e.parentElement.style.left = "50%";
                       e.parentElement.style.marginLeft = -ml+"px";
                       e.parentElement.style.width = w+"px";
                       e.parentElement.previousSibling.style.display = "none";
                       e.parentElement.parentElement.style.border = "0px";
                       e.parentElement.parentElement.style.background = "unset";
                   });



}

