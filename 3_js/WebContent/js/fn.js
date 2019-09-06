/**
 * 
 */

console.log("fn.js log");
let name="홍길동";
let flag=true<10;
let now=new Date();
let num=99;
const pi=3.14;

/*
 * 자바스크립트 함수는 일급함수 - 함수를 값으로 다룰 수 있다. - 변수에 함수를 담을 수 있다. - 함수의 결과 값 리턴값으로 사용 가능 -
 * 함수의 인자로 사용 가능
 */

const log= console.log; // console.log(~)를 log(~)로 사용

function f1(){
	alert("hello javascript ~~~");
}

const f2=f1;

const f3= ()=>alert("hello javascript ~~~");
const f4= (i)=>alert(i); // 람다식


function sum(a,b,c){
	if(!c) c=0; // a,b만 있으면 c=0;
	return a+b+c;
}

function sumAll(){// 함수 호출할때 인자 넘겨주면 arguments로 처리
	let sum=0;
	for(let i=0; i<arguments.length; i++){
		sum+=arguments[i];
	}
	return sum;
}

function small(a,b){
	return a>b?b:a;
}

const min = (a,b) => a>b?b:a;

function callback(){
	log('callback');
}

function callTenTimes(fn){
	for(let i=0; i<10; i++){
		try{
		fn(); // fn이라는 함수가 인자로 들어오면 이 함수를 10번 수행
		}catch(e){
			log('함수 이름을 넘겨 주세요.');
		}
	}
}

// callTenTimes(callback);
// callTenTimes(function(){alert('~~~~');});
// let fc;
// callTenTimes(fc=()=>alert('~~~~'));

// let intervalId = setInterval(callback,3000);//3초 간격으로 callback 호출
// clearInterval(intervalId); //함수 호출 멈추게 하는 명령문

//let id2=setInterval(function(){log(new Date())},1000);

//setTimeout(function(){
//	clearInterval(id2);
	// location.href="http://www.naver.com";
	// location.href="http://localhost:8000/2_css/submenu/index.html"; //해당 주소로
	// 이동
//},5000); //5초 후 함수 호출 멈춤

function fa(){ //fa()로 호출->inner함수 리턴
	let data=0;
	function inner(){ //fa()()로 호출->data 리턴(1)
		return ++data;
	}
	return inner;
}
let ff1=fa; //호출할 때마다 새로운 outer의 새로운 inner 가짐
let ff2=fa(); //inner함수 가짐, 호출할 때마다 같은 outer의 새로운 inner 가짐

let fb1=function fa(){ 
	let data=0;
	function inner(){
		return ++data;
	}
	return inner;
};
let fb2=function fa(){ 
	let data=0;
	function inner(){
		return ++data;
	}
	return inner;
}();
