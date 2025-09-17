import { useState } from "react"

export default function Component7(props) {
    // [1] useState 변수 선언 : 구문 분해 이용한 useState 반환값을 변수화
    // 1. import { useState } from "react"
    // 2. count [ 변수명 , set변수명 ] = useState( 초기값 );
    //  * 변수명은 카멜표기법 , set변수명은 변수명앞에 set 붙인다.
    const [count , setCount ] = useState( 0 );
    // 3. 특정한 useState 값을 변경
    const countAdd = () => { 
        //  sexXXX( 새로운값 ); // 만일 값이 변경되었을때 해당 컴포넌트재실행(재렌더링)
        const newValue = count + 1;
        setCount( newValue ); } // 훅(갈고리 : 특정한 기능을 실행하면 다른 기능들도 실행) 

    const [ array , setArray ] = useState( ['딸기'] );
    const arrayAdd = ( ) => {
        // 주의할점은 useState는 수박을 관리 하는게 아니라 수박을 포함하는 [ ] 관리 
        array.push( '사과' ); // [ ] --> [ '사과' ] --> ['수박' , '사과' ]
        // setArray( array ); // 불가능
        setArray( [...array] )
        console.log(array);
    }
    // [3]
    const [ data , setDate ] = useState('');
    const dataAdd = (e)=>{
        // onChange가 실행 되었을때 event(이벤트 결과 정보)가 함수의 매개변수로 전달된다.
        console.log(e);
        console.log(e.target); // onChange가 발동한 마크업 가져오기
        console.log(e.target.value); // onChage가 발동한 마크업의 입력받은 값 가져오기
        setDate( e.target.value); // ------------------ 입력받은 값을 useState 로 변경한다. setXXX( )
    }
    // 
    const inputBtn = ()=> {
        console.log(data);
        console.log(array);
        console.log(count);

    }

    return(<>
        <h3> useState 예제1 {count} </h3>
        <button onClick={ countAdd }> count증가 </button>
        <h3> useState 예제2 : {array} </h3>
        <button onClick={arrayAdd}> 과일추가 </button>
        <h3> useState 예제3  </h3>
        <input value={data} onChange={dataAdd}/>
        <input value={data} onChange={ (e)=>{setDate(e.target.value) } } />
        <br></br>
        <button onClick={inputBtn}> 글자 </button>
    </>)
} // func end


/*
    /. 데이터/자료 : 값
    2. 자료타입 : 값의 분류(한국 분리수거 VS 미국 분리수거)
        - 기본타입(리터럴:미리만들어진데이터들) VS 참조타입(객체/주소값)
    3. 자료의 주소값 변경 기준
        1 -> 2 : 리터럴/(주소) 변경
        'a' -> 'b' : 주소 변경
        { name : 유재석 } -> { name : 유재석 , age : 40 } : 주소 변경 x
         [ '수박' ] -> [ '수박', '사과' ]

    4. 예시
    let a = 1(101번지);
    let b = 1(101번지);
    let c = "유재석"(102번지);
    let d = "유재석"(102번지);
    let f = { age : 1 } ( 103번지{ 101번지 } )
    let g = { age : 1 } ( 104번지{ 101번지 } )
    let h = [ 1 ] ( 105번지[ 101번지 ] )
    let k = [ 1 ] ( 106번지[ 101번지 ] )

 */