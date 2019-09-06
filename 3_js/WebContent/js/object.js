/**
 * 자바스크립트 객체
 */

const log = console.log;

let array = [ '가', '다', '하', '나' ];

array[4] = '~~~~'; // 없는 인덱스 부르면 undefined
array.pop(); // 배열을 스택처럼 사용 가능
array.push('A');

for (let i = 0; i < array.length; i++) {
	// log(array[i]);
}

// array.forEach(i=>log(i));
// array.forEach(i=>document.write("<h4>"+i+"</h4>"));

// array.filter(i=>i>'다').forEach(i=>log(i)); //원하는 것만 필터링

// 자바스크립트 객체 : 싱글톤
/*
let student = {
		name : "홍길동",
		ko : 99,
		eng : 100,
		sum : function() {
			return this.ko + this.eng; //바깥에 있는것 쓰려면 this 붙여야 한다. 안 붙이면 함수 내의 새로운 변수가 됨
		},
		avg : function() {
			return this.sum() / 2;
		}
	}


student["name"];
student.name;
student.avg();

student.address = '서울'; // 추가
delete student.address; // 삭제
delete student.sum;


for(let data in student){
	log(student[data]);
}
*/

/*
let product = [
	{name:"바나나",price:700},
	{name:"체리",price:1700},
	{name:"사과",price:900},
	{name:"배",price:5000},
	{name:"수박",price:17000}
];

product[0];
product[0].name;
product[0]["name"];

for(let data in product){
	log(product[data]);
	for(let d in product[data])
		log(product[data][d]);
}

function print_product(data){
	log(data.name,"::",data.price);
}

print_product(product[0]);
for (let data in product){
	print_product(product[data]);
}

product.forEach(i=>print_product(i));
*/


//자바스크립트 객체 => 생성자 함수를 통한 객체 생성

function Student(name,ko,eng){
	this.name=name;
	this.ko=ko;
	this.eng=eng;
}

Student.prototype.sum=function(){ //Student가 공유하는 공유 메소드. 함수는 공유 영역(프로토타입 영역)에 올라감->공간 낭비 막음
	return this.ko+this.eng;
}

Student.prototype.avg=function(){
	return this.sum()/2;
}

let s1=new Student("홍길동",90,77); //데이터는 각각의 영역에 올라감
let s2=new Student("고길동",99,97);
let s3=new Student("박길동",69,57);

//log(s1.name,"/",s1.avg());
//log(s2.name,"/",s2.avg());
//log(s3.name,"/",s3.avg());
/*
s1.grade=function(){ //원하는 특정 객체에만 함수 등록
	return this.avg() > 80 ? 'A' : 'B';
}
*/
Student.prototype.grade=function(){
	return this.avg() > 80 ? 'A' : 'B';
}

//log(s1.name,"/",s1.avg(),"/",s1.grade());
//log(s2.name,"/",s2.avg(),"/",s2.grade());
//log(s3.name,"/",s3.avg(),"/",s3.grade());

/*Object.prototype.grade=function(){
	return this.avg() > 80 ? 'A' : 'B';
}*/

let students=[
	new Student("홍길동",90,77),
	new Student("고길동",99,97),
	new Student("박길동",69,57),
	new Student("이길동",89,77),
	new Student("강길동",59,97),
	new Student("나길동",99,27)
];
/*
log("평균 리스트");
students.forEach(i=>log(i.name+":"+i.avg()));
let testin;
let testof;
for(let data in students){
	testin=data; //인덱스
	log(students[data].name," / ",students[data].avg());
}
for(let data of students){
	testof=data; //데이터
	log(data.name," / ",data.avg());
}
log(testof);
log(testin);
*/
log(s1.toString()); //'object' 출력(Object의 메소드)
/*s1.toString=function(){ //s1에 toString 메소드 만들어줌(오버라이딩)
	return this.name+"::"+this.avg();
}*/
Student.prototype.toString=function(){
	return this.name+"::"+this.avg();
}
log(s1.toString());
log(s2.toString());

for(let data of students){
	log(data.toString());
}