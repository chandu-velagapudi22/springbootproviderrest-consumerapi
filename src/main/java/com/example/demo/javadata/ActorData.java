package com.example.demo.javadata;

import lombok.Data;

@Data
public class ActorData {

	private Integer actorId;
	private String actorName;
	private Integer actorage;
	private String actorStatus;

	public ActorData(Integer actorId, String actorName, Integer actorage, String actorStatus) {
		super();
		this.actorId = actorId;
		this.actorName = actorName;
		this.actorage = actorage;
		this.actorStatus = actorStatus;
	}

	public ActorData() {
		super();
		System.out.println("I am in the Zero parametrized constructor of ActorData class");
	}
}
