# 공공 와이파이 API를 이용한 내 위치 인근 와이파이 찾기

## 사용방법
1. Open API 와이파이 정보 가져오기를 눌러 서울시 WIFI정보를 불러온다.
2. LAT, LNT 부분에 좌표값을 직접 입력하거나, '내 위치 가져오기'버튼을 눌러 현재 위치를 가져올 수 있다.
3. '근처 WIFI 정보 보기'를 클릭하면, 사용자 좌표에서부터 가까운 거리의 20개의 와이파이가 출력된다.
4. 조회했던 LAT, LNT 좌표 및 조회 시간을 알고 싶다면 '위치 히스토리 목록'에 들어가면 확인할 수 있다.
5. 해당 기록을 삭제하고 싶다면, 비고란에 있는 '삭제'버튼을 클릭한다.

## 사용 기술 스택
- JDK 1.8
- Tomcat 8.5
- Java
- Jsp
- MariaDB
- JSON

## 주요 기능
- Geolocation 을 이용한 현재 위치 불러오기
- 서울시 공공 API를 이용한 서울시 공공 와이파이 정보 가져오기
- 입력 위치 값 기준으로 가까운 20개의 와이파이 불러오기
- '근처 WIFI 정보 보기' 를 눌러 확인하면 '위치 히스토리 목록'에 해당 LAT, LNT, 조회일자가 저장되는 기능
- '위치 히스토리 목록'에서 삭제 버튼을 클릭하면 해당 내용이 지워지는 기능

## 외부 리소스 정보
- 서울 열린데이터 광장(서울시 공공 와이파이 서비스 위치 정보 OPEN API)
https://data.seoul.go.kr/dataList/OA-20883/S/1/datasetView.do

## 발생 가능한 에러
- "Geolocation API를 지원하지 않습니다."
(이 경우 위치정보를 허용해주시면 에러가 해결됩니다.)

## 프로젝트 후기
- 처음으로 하는 개인프로젝트라, 신경써야 하는 부분도 많았고 어려운 부분도 많았다. 에러도 물론 많았고.
- 그러나 그 과정을 헤쳐 나가는 과정에서 구글링과 주변 사람들의 도움으로 많은 것을 배울 수 있었다.
- 생각했던 기간보다 너무 오래 걸린 점이 아쉽지만, 첫 프로젝트를 정상적으로 제출할 수 있다는 점이 기쁘다.
- 지금은 프로그램이 구동되는것에 집중해서 나머지 부분을 많이 신경쓰지 못한 것 같아서, 보다 효율적인 구성을 만들기 위해 더 공부해야겠다고 느꼈다.
