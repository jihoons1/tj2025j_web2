import { useState } from "react";

import './Test4.css'

export default function Test4( props){
    // 등록 
    const [name , setName ] = useState(""); // 성명
    const [phone , setPhone ] = useState("");
    const [age , setAge ] = useState("");
    const [count , setCount ] = useState ( 0 ); 
    
    const user = [name , phone , age ]
    const [list , setList] = useState( [] );
    const countbtn2 =() => {
        const num = count + 1;
        setCount(num);
        console.log(name , phone , age);
         if(name.length > 5 || phone.length > 13 || age.length > 3){
        alert('나이 5글자 전화번호 13 나이 3글자 적게');
        return;
    }
        setList([...list , user]);
        alert('등록됨');
    }
    // 삭제
    const delbtn = (e) => {
        const num = count - 1;
        setCount(num);
        const news = list.filter(i=> i !== e);
        setList(news)
        alert('삭제됨');
    }

    
    return(<>
    <div className="box">
        <div>
        <input placeholder="성명" value={name} onChange={ (e)=>{setName(e.target.value) } } />
        <input type="number" placeholder="연락처" value={phone} onChange={ (e)=>{setPhone(e.target.value) } } />
        <input type="number" placeholder="나이" value={age} onChange={ (e)=>{setAge(e.target.value) } } />
        <button className="addbtn" onClick={countbtn2}>등록</button>
        <h3>전화기록부</h3>
        </div>
        {list.slice(0,5).map( (a)=>     
        <ul>
                <li><span>성명: </span>{a[0]} <span className="phoe">연락처:</span> {a[1]} <span className="ag">나이: </span>{a[2]}  </li>
                <button className="btn" onClick={ ()=> delbtn(a)}> 삭제 </button>
            </ul>
        )}
        <h6>총 {count}명</h6>
        </div>
        
    </>)
}