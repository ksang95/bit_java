package day10;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time t1=new Time(13,20,20);
	}

}

class Time{
	int hour;
	int minute;
	int second;
	
	public Time() {
	}
	
	public Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	
}
