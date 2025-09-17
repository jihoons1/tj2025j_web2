import { useState } from "react";

export default function Test3( props){

    const [count , setCount ] = useState( 0 ); // 기본값 0 
    // 증가
    const countbtn2 = () => {
        const num = count + 1;
        setCount(num);
    }
    // 감소
    const countbtn1 = () => {
        const num = count - 1;
        setCount(num);
    }

    // input
    const [ dataname , setDataname ]=useState('');

    return(<>

        <input value={dataname} onChange={ (e)=>{setDataname(e.target.value) } }/>
        <h4>현재 수량: {count}</h4>
        <button onClick={countbtn1}>감소</button>
        <button onClick={countbtn2}>증가</button>
        
    </>)
}