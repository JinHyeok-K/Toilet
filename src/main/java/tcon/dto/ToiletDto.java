package tcon.dto;

import lombok.*;
import tcon.domain.ToiletEntity;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Builder @ToString
public class ToiletDto {

    private int tnum;               // 화장실 번호 PK
    private int tnum2;              // 지역별 화장실 번호 PK
    private String t_type;          // 구분( 개방? 공중? )
    private String t_name;          // 화장실 이름
    private String t_address_1st;   // 화장실 주소 (도로명)
    private String t_address_2nd;   // 화장실 주소 (지번)
    private String t_combine;       // 남녀 공용인지 아닌지
    private int t_man_big;          // 남성용 대변기 수
    private int t_man_small;        // 남성용 소변기 수
    private int t_man_big_sick;     // 남성 장애인용 대변기 수
    private int t_man_small_sick;   // 남성 장애인용 소변기 수
    private int t_man_big_baby;     // 남자 어린이용 대변기 수
    private int t_man_small_baby;   // 남자 어린이용 소변기 수
    private int t_woman_big;        // 여성용 대변기 수
    private int t_woman_big_sick;   // 여성 장애인용 대변기 수
    private int t_woman_big_baby;   // 여자 어린이용 대변기 수
    private String t_admin;         // 관리 기관 명
    private String t_call_num;      // 전화 번호
    private String t_open_time;     // 개방 시간
    private String t_set_up;        // 설치 연월
    private String t_lat;           // 위도
    private String t_lng;           // 경도
    private String t_owner;         // 화장실 소유 구분
    private String t_setup_type;    // 화장실 설치 장소 유형
    private String t_process;       // 오물 처리 방식 (푸세식  ? 수세식 )
    private String t_bell;          // 비상벨 설치 유무
    private String t_bell_Setup;    // 비상벨 설치 장소
    private String t_cctv;          // CCTV 설치 유무
    private String t_babypants_1;   // 기저귀 교환대 유무
    private String t_babypants_2;   // 기저귀 교환대 장소
    private String t_remodeling_date;   // 리모델링 날짜
    private String t_data_date;         // 데이터 기준 날짜

    public ToiletEntity toentity(){
        return ToiletEntity.builder()
                .tnum(this.tnum)                         // 화장실 번호 PK
                .tnum2(this.tnum)                        // 지역별 화장실 번호 PK
                .t_type(this.t_type)                     // 구분( 개방? 공중? )
                .t_name(this.t_name)                      // 화장실 이름
                .t_address_1st(this.t_address_1st)       // 화장실 주소 (도로명)
                .t_address_2nd(this.t_address_2nd)        // 화장실 주소 (지번)
                .t_combine(this.t_combine)                    // 남녀 공용인지 아닌지
                .t_man_big(this.t_man_big)                   // 남성용 대변기 수
                .t_man_small(this.t_man_small)       // 남성용 소변기 수
                .t_man_big_sick(this.t_man_big_sick)         // 남성 장애인용 대변기 수
                .t_man_small_sick(this.t_man_small_sick) // 남성 장애인용 소변기 수
                .t_man_big_baby(this.t_man_big_baby)         // 남자 어린이용 대변기 수
                .t_man_small_baby(this.t_man_small_baby)   // 남자 어린이용 소변기 수
                .t_woman_big(this.t_woman_big)             // 여성용 대변기 수
                .t_woman_big_sick(this.t_woman_big_sick)   // 여성 장애인용 대변기 수
                .t_woman_big_baby(this.t_woman_big_baby)   // 여자 어린이용 대변기 수
                .t_open_time(this.t_open_time)           // 개방 시간
                .t_bell(this.t_bell)                          // 비상벨 설치 유무
                .t_bell_Setup(this.t_bell_Setup)              // 비상벨 설치 장소
                .t_cctv(this.t_cctv)                     // CCTV 설치 유무
                .t_babypants_1(this.t_babypants_1)          // 기저귀 교환대 유무
                .t_babypants_2(this.t_babypants_2)            // 기저귀 교환대 장소
                .build();


    }




}
