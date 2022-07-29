package com.courzelo.classroom.serviceREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courzelo.classroom.entities.Meeting;
import com.courzelo.classroom.repositories.MeetingRepository;
import com.courzelo.classroom.serviceREST.iservicesREST.IserviceMeeting;

@Service
public class MeetingBusiness implements IserviceMeeting {
	@Autowired
	private MeetingRepository meetingRepository;

	@Override
	public Meeting addMeeting(Meeting m) {
		return meetingRepository.save(m);
	}
}
