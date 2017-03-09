package com.hack;

public class Flower {
	public String whatIsYourName(){
		return "I have many names and types.";
	}
}
class Jasmine extends Flower {
	@Override
	public String whatIsYourName(){
		return "Jasmine";
	}
}
class Lily extends Flower {
	@Override
	public String whatIsYourName(){
		return "Lily";
	}
}

class Lotus extends Flower {
	@Override
	public String whatIsYourName(){
		return "Lotus";
	}
}

class State{
	public Flower yourNationalFlower(){
		return new Flower();
	}
}

class WestBengal extends State{
	@Override
	public Jasmine yourNationalFlower(){
		return new Jasmine();
	}
}
class Karnataka extends State{
	@Override
	public Lotus yourNationalFlower(){
		return new Lotus();
	}
}

class AndhraPradesh extends State{
	@Override
	public Lily yourNationalFlower(){
		return new Lily();
	}
}
