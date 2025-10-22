package org.web2.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web2.model.dto.UserDto;
import org.web2.service.JwtService;
import org.web2.service.UserService;

@RequiredArgsConstructor
@RestController // 빈등록
@RequestMapping("/user") // 공통 url
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserDto dto) {
        int result = userService.signup(dto);
        return ResponseEntity.ok(result);

    }

    // 2-1 로그인(+ 세션 : 자바웹서버(톰켓)의 임시 저장소 )
//    @PostMapping("/login")
//    public ResponseEntity< ? > login(@RequestBody UserDto dto , HttpSession session){
//        UserDto result = userService.login(dto);
//        if (result == null) { // 만약에 로그인 성공 했다면  성공한 유저의 아이디를 세션에 저장
//            session.setAttribute("loginUser", result.getUid());
//        }
//        return ResponseEntity.ok(result);
//    }
    // 2-2. 로그인(+ 쿠키 : 자바웹서버(톰켓)의 임시 저장소 )
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto, HttpServletResponse response) {
        UserDto result = userService.login(userDto);
        if (result != null) { // 만약에 로그인 성공 했다면  성공한 유저의 아이디를 *쿠키*에 저장
            // * 로그인정보를 세션에 저장하면 서버이므로 안전하다. 쿠키(클아이언트) 저장하면 위험하다.
            // 안전장치 필요하다.
            // Cookie cookie = new Cookie("쿠키명" , 값 );
            // response.addCookie( 생성한쿠키 );
            // Cookie cookie = new Cookie("loginUser", result.getUid());

            // **** 쿠키에 저장하는 회원정보를 토큰으로 저장하기 ******
            Cookie cookie = new Cookie( "loginUser" , jwtService.createToken(result.getUid() , result.getUrole() ) );

            // 클라이언트 에서 해당 쿠키를 노출(탈취) 방지 = 주로 민감한정보
            cookie.setHttpOnly(true); // .setHttpsOnly( true ) : 무조건 Http 에서만 사용. 즉] JS 접근 불가능
            cookie.setSecure(false); // http 이용하여 탈취 하더라도 암호화 , 단 https 에서만 가능
            // + 설정
            cookie.setPath("/");// 쿠키에 접근할수 있는 경로
            cookie.setMaxAge(60 * 60); // 쿠키의 유효기간(초) , 1시간
            response.addCookie(cookie); // 생성한 쿠키를 클라이언트에게 반환한다.
        }
        return ResponseEntity.ok(result);
    }

    // 3. 현재 로그인된 정보 호출 ( + 마이페이지 )
    @GetMapping("/info")
    public ResponseEntity<?> myInfo(HttpServletRequest request) { // 쿠키 활용한 로그인상태를 확인 // request 요청/호출
        // 3-1 : 현재 클라이언트(브라우저) 저장된 모든 쿠키 가져오기
        Cookie[] cookies = request.getCookies();
        // 3-2 : 반복문 이용한 특정한 쿠키명 찾기
        if (cookies != null) { // 만약에 쿠키들이 존재하면
            for (Cookie c : cookies) { // 하나씩 쿠키들을 반복하여
                if (c.getName().equals("loginUser")) { // "loginUser" 쿠키명과 같다면
                    // String uid = c.getValue(); // 쿠키의 저장된 값 반환 ex] uid

                    // ***** 쿠키의 저장된 토큰 반환 하기 ******
                    String token = c.getValue(); // 쿠키의 저장된 토큰 반환
                    boolean checked = jwtService.checkToken(token); // 토큰 검증
                    if (checked) { // 만약에 토큰이 유효하면
                        String uid = jwtService.getUid(token); // 토큰에 저장된 클레임(회원아이디) 추출하기
                        // 3-3 : 서비스를 호출하여 내정보 조회
                        UserDto result = userService.myInfo(uid);
                        return ResponseEntity.ok(result); // 로그인 상태로 회원정보 조회
                    }//
                    // 만약에 토큰이 유효하지 않으면
                    return ResponseEntity.ok(null); // 비어있음
                }
            }
        }
        return ResponseEntity.ok(null); // 비로그인 상태
    }

    // 4. 로그아웃
    @GetMapping("/logout")
    public ResponseEntity< ? > logout(HttpServletResponse response){ // 응답/ 반환
        // 4-1 : 삭제할 쿠키명을 null 값으로 변경한다.
        Cookie cookie = new Cookie("loginUser" , null );
        cookie.setHttpOnly( true );
        cookie.setSecure( false );
        cookie.setPath("/"); // 모든 경로 에서 로그아웃 하려고
        cookie.setMaxAge( 0 ); // 즉시 삭제하라는 뜻 : 0초
        response.addCookie(cookie); // 동일한 쿠키명으로 null 저장하면 기존 쿠키명 사라진다.


        return ResponseEntity.ok(true);

    }


}