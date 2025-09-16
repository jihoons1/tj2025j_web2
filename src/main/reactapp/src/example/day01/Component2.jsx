
// * 함수 안에 함수 호출
// 즉] 컴포넌트 안에 컴포넌트 호출 가능하다.

// (1) function
// (2) 컴포넌트명 : 아뭐나 하되 default 컴포넌트 파일명 일치
// (3) ( props ) : property속성 으로 <컴포넌트 속성=값 속성=값 />
// (4) { } : 중괄호안에서 JS 와 HTML 작성한다.
// (5) return : HTML과 js가 혼합된 JSX 문법을 사용할 수 있다. JSP(HTML+JAVA) JSX(HTML+JS0)
// (6) JSX 파일내 export default 함수를 정의한다.

// [1] 메인페이지
export default function Component2( props ) {
    const name = "유재석"; // JS 코드
    // return 뒤로 html 작성
    return <div> <Header/> Component2 <Footer/> </div>
} // func end 

// [2] 헤더페이지
function Header( props ){
    return <div>헤더 메뉴</div>
} // func end

// [3] 푸터페이지
function Footer( props ){
    return <div> 푸터 메뉴 </div>
} // func end
