import axios from "axios";
import { useEffect, useState } from "react";

export default function Task5(props){

        // // 등록 
    const [sno , setSno ] = useState("");
    const [sname , setName ] = useState(""); // 성명
    const [sphone , setPhone ] = useState("");
    const [age , setAge ] = useState("");
    
    const [ user , setUser ] = useState ( []);

    // 등록
    const countbtn2 =async() => {
         if(sname.length > 5 || sphone.length > 13 || age.length > 3){
        alert('나이 5글자 전화번호 13 나이 3글자 적게');
        return;
        } 
        console.log(sname , sphone , age);
        const obj = { sname , sphone , age};
        const response = await axios.post("http://localhost:8080/springweb", obj)
        console.log(response.data);
        setUser([...user , response.data]);
        alert('등록됨');
        springprint();
    }
    // 전체조회
    const springprint = async()=>{
        const re = await axios.get("http://localhost:8080/springweb");
        setUser(re.data);
    }

    // 삭제
    const delbtn = async(sno) => {
        const response = await axios.delete(`http://localhost:8080/springweb?sno=${sno}`);
        const news = user.filter( (s)=> {return s.sno !== sno} )
        setUser([...news])
        alert('삭제됨');
        console.log(response.data);
    }

    // 특정조회
    const springprint2 = async(sno)=>{
        const re = await axios.get(`http://localhost:8080/springweb/aa?sno=${sno}`);
        if(re.data){
        setUser([re.data])
        }else{
            alert('못찾음');
            setUser([]);
        }
        console.log(re.data);
    }
    
    const [upsno , setUpsno] = useState(null); // 수정시 사용

    // 수정
    const upbtn = async(sno)=>{
        const obj = {sno , sname , sphone , age}
        const re = await axios.put(`http://localhost:8080/springweb/bb` , obj);
        setUpsno(null);
        console.log(re.data);
        springprint();
    }
    


    useEffect( ()=> {springprint()}, [] )

    
    return(<>
    <div className="box">
        <div>
        <input placeholder="성명" value={sname} onChange={ (e)=>{setName(e.target.value) } } />
        <input type="number" placeholder="연락처" value={sphone} onChange={ (e)=>{setPhone(e.target.value) } } />
        <input type="number" placeholder="나이" value={age} onChange={ (e)=>{setAge(e.target.value) } } />
        <button className="addbtn" onClick={countbtn2}>등록</button>
        <h3>전화기록부</h3>
        </div>
        {user.slice(0,5).map( (a)=>     
        <ul key={a.sno}>
                <li><span>번호:{a.sno}</span> <span>성명: </span>{a.sname} <span className="phoe">연락처:</span> {a.sphone} <span className="ag">나이: </span>{a.age}  </li>
                <button className="btn" onClick={ ()=> delbtn(a.sno)}> 삭제 </button>
                <button className="btn" onClick={ ()=> upbtn(a.sno)}> 수정 </button>
            </ul>
        )}
        <h6>총 {user.length}명</h6>
        <input type="number" placeholder="번호" value={sno} onChange={ (e)=>{setSno(e.target.value) } } />
        <button onClick={ ()=> springprint2(sno)}> 조회 </button> <button onClick={()=> springprint()}>전체조회</button>
        </div>
        
    </>)
}