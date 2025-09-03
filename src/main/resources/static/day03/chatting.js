
console.log('chatting.js exe ');

// [1] 서버 웹 소켓과 연동하는 클라이언트 소켓 (객체) 생성
const client = new WebSocket("/chat");

// [2] 서버 웹 소켓과 연동 성공했을때
// event 이란? 함수의 매개변수 이면서 해당 이벤트 정보를 담고 있는 객체
client.onopen = (event) => {
    console.log('서버 소켓 연동 성공');
}
// [3] 서버 웹 소켓과 연동 끊겼을때
client.onclose = (event) => {
    console.log('서버 소켓 연동 실패');
}

// [4] 서버 웹 소켓으로 부터 메세지를 받았을때

client.onmessage = (event) => {
    console.log('서버 소켓 메세지 받기');
    console.log(event);
    console.log(event.data);
}


const onMsgSend = async () => {

}
