# changgong-suryong
2020 캡스톤 디자인 프로젝트 - 창공수룡



## 주요 파일 설명
- Application/app/src/main/java/com/example/myapplication/
    - MainActivity.java : 메인 화면, 앱 권한 확인
    - Sub1.java : 사용안내 화면
    - Simplesetting.java : 간편설정 화면
      - Simplesetting 0 ~ 4 : 사용자 주소 및 긴급 연락처를 수집
      - Simplesetting 5 : 알림 주기 설정 및 생존 알림 설정(notification 채널 생성)
    - Detailsetting.java : 기기설정 화면, 아두이노와 블루투스 연결/해제 설정
    - Alarmreport.java : 알림기록 화면, 알림기록 확인 및 알람 초기화 기능
    - AlarmCheck.java : 생존 알림 확인 화면
    - RingtonePlayingService.java : 알림음 재생 및 알림 실패 로그 추가, 알림 확인 실패 시 긴급연락처 신고 기능

- Arduino
  BT_1_.ino : 문열림감지센서 값 수집

- Report
  프로젝트 개발 중 보고서 및 공모전 발표 자료
