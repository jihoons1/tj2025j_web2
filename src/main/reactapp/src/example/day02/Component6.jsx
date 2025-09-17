import { useState } from "react";

export default function Component6(props){

    // [1] 리엑트에서 상태관리(변수를 대신에 관리) 라이브러리(미리만들어진함수) 사용하기
    // useState 사용법
    // 1. 파일 상단에 import (useState ) from "react"; 또는 useState 자동완성
    // 2. useState( 초기값 );
        // --> 반환값 : [0]데이터 , [1]재렌더링함수
    const state = useState("유재석");
    console.log(state); 
    console.log(state[0] ); // 유재석 : 0번쨰 인덱스 useState가 관리하는 값이 들어있음
    console.log(state[1] ); // f : 1번쨰 인덱스에는 값이 변경되면 (??)실행되는 함수가 들어있음
    const state2 = () => {
        state[0] = '강호동';    console.log(state[0]);
        state[1]("강호동");
    }
    return(<>
        <h3> useState 상태관리 </h3>
        <h4> useState의 초기값 : { state[0] } </h4>
        <h4> useState의 값 변경 <button onClick={ state2 } > 변경 </button> </h4>
    </>)
}