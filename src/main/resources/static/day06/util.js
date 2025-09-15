// util.js
// 1. 함수
const hello = (name) => { return name+"님"};
// 2. 함수를 기본값으로 내보내기 defalut export : 1개만 가능
export default hello;
// 3. 이름 을 붙인 내보내기 , named export : 여러개 가능
export const PI = 3.14;
export const E = 2.71