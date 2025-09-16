
const products = [
    { title: "무선 키보드", price: 45000, inStock: true },
    { title: "게이밍 마우스", price: 32000, inStock: false },
    { title: "27인치 모니터", price: 280000, inStock: true }
  ]; 


// [3] CSs 파일 불러오기 : import 'CSS파일경로'
import './Task2.css'
  
// [1] 해당 .jsx 파일내 대표(defalut) 컴포넌트 만들기
export default function Task2( props ){
return (<> 
    <div className="products">{ /* 하위 컴포넌트 호출 과 동시에 props속성 자료 전달 */}
        {products.map((product , index ) =>  (
        <InfoCard key = { index } product = {product} />
        ))}
    </div>
</>
)   
} // func end 
// [2] 하위 컴포넌트 : 제품1개당 정보 구성하는 컴포넌트
function InfoCard( props ){
    const { title , price , inStock } = props.product
    return (<>
        <ul class="box">
            <li class="title"> { title } </li>
            <li> 가격: { price.toLocaleString() } </li>
            <li className={inStock ? "tre" : "fale"}> { inStock == true ? '재고있음' : '재고없음' }</li>
        </ul>
    </>)
}