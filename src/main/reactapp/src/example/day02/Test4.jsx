import { useState } from "react";

export default function Task4( props ){
    // 1. useState : 상태(변수값) 관리(변수값에따른재렌더링) 훅
    const [ name , setName ] = useState('')
    const [ phone , setPhone ] = useState('')
    const [ age , setAge ] = useState('')
    const [ members , setMembers ] = useState( [ ] ); // 회원정보 객체를 담는 리스트
    // 2. '등록' 버튼을 클릭 했을때 함수
    const onAdd = ( ) => {
        const obj = { name , phone , age } // 2-1 : 입력받은 데이터들을 객체화
        members.push( obj ); // 2-2 : 객체를 리스트에 저장 
        setMembers( [...members] )// 2-3 : 리스트를 재렌더링
        // ( 주의할점 : 객체/배열는 ...스프레드 연산자 이용한 복사 = 주소 값 변경 ) 
    } 
    // 3. 삭제 버튼을 클릭했을때 , 무엇을 삭제할지 매개변수(pk/중복값없는) 필요
    const onDelete = ( deletePhone )=>{ console.log( deletePhone );
        // 3-1 : 반복문 이용하여 리스트내 삭제할 번호를 찾아서 제거한다. // for vs forEach vs map +return vs filter + if
        const newMembers = members.filter( (m)=> { return m.phone != deletePhone ; })
        // 3-2 : *** 수정된 리스트를 재렌더링 
        setMembers( [ ...newMembers ] );
    }
    return (<>
        성명 : <input value={ name } onChange={ (e)=>{ setName(e.target.value ) } } /> 
        연락처 : <input value={ phone } onChange={ (e)=>{ setPhone( e.target.value) } }/> 
        나이 : <input value={ age } onChange={ (e)=>{ setAge( e.target.value ) } } />
        <button onClick={ onAdd }> 등록 </button> <br/>
        {   members.map( ( m ) => { 
                return <div> 
                        { m.name } { m.phone } { m.age } 
                        <button onClick={ ()=> { onDelete( m.phone ) }  }> 삭제 </button> 
                    </div> 
            })
        } 
    </>)
} // func end 

    // ---------- jsx에서 { } 중괄호 js표현식의 시작과 끝
    // ----------- [1] 1. onClick = { 함수명 } 또는
    //                  2. onClick = { ()=>{} } * 주의할점 : onClick = { 함수명 } 
    //                  3. onClick = { ()=>{} }
    // ----------1. onClick { 함수명 } 또는 2. onClick = { ()=>{} } 3. 주의할점 : onClick={ 함수명() }
    // ----------[2] 리스트 출력시 forEach대신 map 사용한다.



    // // 등록 
    // const [name , setName ] = useState(""); // 성명
    // const [phone , setPhone ] = useState("");
    // const [age , setAge ] = useState("");
    // const [count , setCount ] = useState ( 0 ); 
    
    // const user = [name , phone , age ]
    // const [list , setList] = useState( [] );
    // const countbtn2 =() => {
    //     const num = count + 1;
    //     setCount(num);
    //     console.log(name , phone , age);
    //      if(name.length > 5 || phone.length > 13 || age.length > 3){
    //     alert('나이 5글자 전화번호 13 나이 3글자 적게');
    //     return;
    // }
    //     setList([...list , user]);
    //     alert('등록됨');
    // }
    // // 삭제
    // const delbtn = (e) => {
    //     const num = count - 1;
    //     setCount(num);
    //     const news = list.filter(i=> i !== e);
    //     setList(news)
    //     alert('삭제됨');
    // }

    
    // return(<>
    // <div className="box">
    //     <div>
    //     <input placeholder="성명" value={name} onChange={ (e)=>{setName(e.target.value) } } />
    //     <input type="number" placeholder="연락처" value={phone} onChange={ (e)=>{setPhone(e.target.value) } } />
    //     <input type="number" placeholder="나이" value={age} onChange={ (e)=>{setAge(e.target.value) } } />
    //     <button className="addbtn" onClick={countbtn2}>등록</button>
    //     <h3>전화기록부</h3>
//         </div>
//         {list.slice(0,5).map( (a)=>     
//         <ul>
//                 <li><span>성명: </span>{a[0]} <span className="phoe">연락처:</span> {a[1]} <span className="ag">나이: </span>{a[2]}  </li>
//                 <button className="btn" onClick={ ()=> delbtn(a)}> 삭제 </button>
//             </ul>
//         )}
//         <h6>총 {count}명</h6>
//         </div>
        
//     </>)
// }