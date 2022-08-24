package RestAPIServer.demo.service;

public interface KakaoInfo {
    //=====================================기본 정보 ==============================================================================
    // String Redirect_URI = "http://www.detectiongas.com/kakaoLogin.do"; // 리다이렉트 URI(Cloud Deploy)
    final String Redirect_URI = "http://localhost:8080/kakaoLogin"; // 리다이렉트 URI(local용)
    final String RESTAPI_KEY = "27c978dd34db046ade506b3d1fb46013"; // 키
    final String SampleRequest= "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="; // 카카오 접속 앤드포인트  url
    //==========================================================================================================================
    //=============================================요청 URL=======================================================================
    final String AccessTokenReqURL = "https://kauth.kakao.com/oauth/token";
    final String UserInfoReqURL = "https://kapi.kakao.com/v2/user/me";
    final String UserLogotReqURL = "https://kapi.kakao.com/v1/user/logout";
    //=============================================카카오 메시지 보내는 정보 설정=========================================================
    final String FIRENDPROFILELIST_REQ= "https://kapi.kakao.com/v1/api/talk/profile";
    final String FRIENDS = "https://kapi.kakao.com/v1/api/talk/friends"; // 친구 목록 불러오기
    final String SEND_TALK_URL = "https://kapi.kakao.com/v2/api/talk/memo/default/send"; // 톡 보내는 URL
    //========================
}
