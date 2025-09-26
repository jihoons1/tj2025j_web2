import { useState } from 'react';
import Button from '@mui/joy/Button';
import Box from '@mui/joy/Box';
import Input from '@mui/joy/Input';
import Select from '@mui/joy/Select';
import Option from '@mui/joy/Option';
import Switch from '@mui/joy/Switch';
import Avatar from '@mui/joy/Avatar';
import Badge from '@mui/joy/Badge';
import Typography from '@mui/joy/Typography';
import SideBar from './SideBar';
export default function Component14(props){

    const handleChange = (event, newValue) => {
        alert(`You chose "${newValue}"`);
    };
       const [checked, setChecked] = useState(false);

    return(<>

        <h4> MUI 설치 : npm install @mui/joy @emotion/react @emotion/styled </h4>
        <p> 소문자 마크업 : html , 대문자 마크업 : 컴포넌트( 다른 패키지이면 import ) </p>
        <button> html </button>
        <Button  color="primary"
                onClick={function(){}}
                size="lg"
                variant="outlined"> Hello world </Button>
        <p> 2. 마크업 속성 props 이란 : 마크업 안에 , 마크업 속성명=속성값 </p>

        <h4> 1. 버튼 : https://mui.com/joy-ui/react-button/#basics</h4>
        <Box sx={{ display: 'flex', gap: 2, flexWrap: 'wrap' }}>
            <Button>Button</Button>
            <Button disabled>Disabled</Button>
            <Button loading>Loading</Button>
        </Box>

        <h4> 2. 입력상자 : https://mui.com/joy-ui/react-input/#basics </h4>
            <Input placeholder="Type in here…" />

        <h4> 3. 선택상자 : https://mui.com/joy-ui/react-select/ </h4>
        <Select defaultValue="dog" onChange={handleChange}>
            <Option value="dog">Dog</Option>
            <Option value="cat">Cat</Option>
            <Option value="fish">Fish</Option>
            <Option value="bird">Bird</Option>
        </Select>

        <h4> 4. 스위치 : https://mui.com/joy-ui/react-switch/ </h4>
        <Switch
            checked={checked}
            onChange={(event) => setChecked(event.target.checked)}
        />

        <h4> 5. 아바타 : https://mui.com/joy-ui/react-avatar/ </h4>
        {/* <p> style = { { CSS적용카멜표기법 } } </p> */}
        <p> Box 는 div 와 같은 유형 , css 적용하는 방법 : 1. CSS 파일 2. CSS객체 </p>
            <Box sx={{ display: 'flex', gap: 2 }}>
                <Avatar />
                <Avatar>JG</Avatar>
                <Avatar alt="Remy Sharp" src="/static/images/avatar/1.jpg" />
            </Box>

        <h4>  뱃지 : </h4>
         <Badge>
            <Typography sx={{ fontSize: 'xl' }}>🛒</Typography>
        </Badge>

        <h4> 6. 리스트 : https://mui.com/joy-ui/react-list/#collapsible-list</h4>
        <p> npm install @mui/icons-material </p>
        <SideBar />

    </>)
}

/*
    1. 리액트에서 CSS 적용하는 방법
        1안) CSS파일 생성한다. --> CSS 파일을 적용할 컴포넌트 에서 import 'css파일경로'
        2안) CSS객체 --> 컴포넌트에서 객체유형으로 CSS 작성한다. <컴포넌트명 style={{ CSS카멜표기법 }}
            { font-size : 10px } ---> { fontSize : "10" }

    { JSX 시작 { 객체 시작} }
*/