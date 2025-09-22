import axios from "axios";
import { useEffect, useState } from "react"

// ======== 스프링 서버 day07(boardService13) =======
export default function Component10(props){

    // [1] 입력받은 데이터들을 관리하는 useState 가 필요
    // const [ bno , setBno ] = useState("");
    const [ bcontent , setBcontent] = useState("");
    const [ bwriter , setBwriter] = useState("");
    

    // [2] 등록
    const boardWrite=async()=>{
        const obj = {bcontent , bwriter } 
        const response = await axios.post("http://localhost:8080/board" , obj) // 2-2 axios 요청
        console.log(response.data);
        boardPrint(); // 2-3 : 출력함수 실행

    }
    // [3] 출력할 데이터들 을 관리하는 useState
    const [ boards , setBoards ] = useState ( [ {bno : 1 , bcontent : 'test' , bwriter : 'test' } ] );
    // [4] 출력할 데아터들 을 axios 이용하여 스프링에게 요청 , 2-3 실행
    const boardPrint = async()=>{
        const response = await axios.get("http://localhost:8080/board");// 4-1 axios 요청
        setBoards(response.data); // 4-2 : axios 요청값을 setState ㅇ용한 재렌더링
    }

    // [6] 삭제
    const boardDelete =async(bno)=>{ 
        // 6-1 : 삭제할 bno 를 매개변수로 받아서 반복문 이용하여 삭제할 bno 를 제외한 새로운 리스트 생성
        console.log("delete test");
        const response = await axios.delete(`http://localhost:8080/board?bno=`+bno);// http://localhost:8080/board?bno=${bno}
        // 6-2 : 삭제할 bno 를 매개변수로 받아서 반복문 이용하여 삭제할 bno를 제외한 새로운 리스트 생성
        const delMembers = boards.filter( (b)=> { return b.bno != bno } )
        setBoards([...delMembers]); // 6-3 재렌더링
        console.log(response.data)
    }

    // // 개별
    // const boardFind =async(bno)=>{
    //     console.log('find test');
    // }

    // [5] useEffect 이용한 최초 컴포넌트 실행시 출력함수 실행
    useEffect( ()=> {boardPrint()} , [] ) // 의존성배열이 비어있는 경우 ☆☆☆1번만☆☆☆ 실행
    
    return(<>
        <h3> 스프링 서버의 boardservice13(day07) 통신 </h3>
        내용 : <input value={bcontent} onChange={(e)=>{setBcontent(e.target.value) } }/>
        이름 : <input value={bwriter} onChange={(e)=>{setBwriter(e.target.value) } }/>
        <button onClick={ boardWrite }> 등록 </button>
        {/* 번호 : <input value={bno} onChange={(e)=>{setBno(e.target.value) } }/>
        <button onClick={ boardFind } > 개별조회 </button> */}
        {
            boards.map( (board)=>{
                return <div> 번호 : [{board.bno}] 내용: [{board.bcontent}]  이름: [{board.bwriter}] 
                            <button onClick={ ()=> {boardDelete(board.bno) } }> 삭제 </button>
                            
                    </div>
                
            })
        }
    </>)
} // func end