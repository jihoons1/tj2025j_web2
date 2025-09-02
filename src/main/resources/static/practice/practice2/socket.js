
console.log('접속 체크 ');

const client = new WebSocket("/log");

// 연결/접속
client.onopen = (event)=> { 
    // 접속했을때 서버에게 접속 메세지 보내기 
    client.send('익명 사용자접속');
    
}

// 종료
client.onclose = (event)=> {
    // 접속했을때 종료 메세지 보내기 
    client.send('익명 사용자종료');
}

client.onmessage = (event) => {
    alert(`${event.data}`);
}


