import { BrowserRouter, Link, Route, Routes, useNavigate } from "react-router-dom"
import './Component13.css'
import { useRef } from "react";
function Home(props) {return (<>  </>) }
function Add(props) {
    
    // [4-1] : 입력상자들을 참조하는 useRef
    const idRef = useRef(null);
    const pwdRef = useRef(null);
    // [4-3] : 라우터 전용 페이지 전환 함수
    const nav = useNavigate();
    // [4-2] : 특정한 이벤트에서 참조중인 useRef current 확인하기
    const sing = async() => {
        const id = idRef.current.value; // idRef : 참조객체 , idRref.current : 참조객체가 참조중인 값 
        const pwd = pwdRef.current.value;
        const obj = { id, pwd};
        // * axios 를 이용한 서버*스프링) 통신 했다 치고
        alert('성공');
        // location.href= "/login" // 라우터 방식이 아닌 고전적인 HTML 방식을 새로고침
        nav('/login'); // 리우터 방식
    }

    return (<>
        <h3>호회원가입 페이지</h3>
        <input ref={idRef} placeholder="아이디"/>   <br/>
        <input ref={pwdRef} placeholder="비밀번호"/> <br/>
        <button onClick={sing} type="button"> 회원가입 </button>
    </>)
}
function Login(props) { 
    
    // [ 5-1 ] 입력받은 정보들을 갇는 form 참조하는 useRef
    const formRef = useRef(null);
    // [ 5-2 ] 특정한 이벤트/함수에서 참조중인 useRef current확인하기
    const log = async() => {
        const idd = formRef.current.element['id'].value;
        const pwd = formRef.current.element['pwd'].value;
        // ** axios 했다 치고 **
            alert('로그인성공'); 
            nav('/home');
            alert('실패');
    }
    return (<>
        <h3>호로그안 페이지</h3>
    <from>
        <input name="id" placeholder="아이디"/> <br/>
        <input name="pwd" placeholder="비밀번호"/> <br/>
        <button onClick={log} type="button"> 로그인 </button>
        </from>
    </>)
    }



export default function Component13(props){
    return(<>
    <BrowserRouter>
        <div class="container">
            <ul>
            <li><Link to="/"  > 홈</Link></li>
            <li><Link to="/add"  > 회원가입</Link></li>
            <li><Link to="/login"  > 로그인</Link></li>
            </ul>
            <div> 
                <Routes>
                    <Route path="/home" element = { <Home/> } />
                    <Route path="/add" element = { <Add/> } />
                    <Route path="/login" element = { <Login/> } />

                </Routes>
            </div>
            
            </div>
            </BrowserRouter>
    </>)
    
}