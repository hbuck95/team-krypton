package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.MobileCallRecordsEntity;
import com.project.entities.PeopleMobileEntity;
import com.project.repository.PeopleMobileRepository;

@Service
public class PeopleMobileServiceImpl implements PeopleMobileService {

	private PeopleMobileRepository repo;

	@Autowired
	public PeopleMobileServiceImpl(PeopleMobileRepository repo) {
		this.repo = repo;
	}

	@Override
    public List<PeopleMobileEntity> getAssociate(List<MobileCallRecordsEntity> mobileCallRecordsEntity) {
        List<PeopleMobileEntity> associates = new ArrayList<PeopleMobileEntity>();
        for (int i = 0; i < mobileCallRecordsEntity.size(); i++) {
            String phoneNumber = mobileCallRecordsEntity.get(i).getReceiverMSISDN();
            PeopleMobileEntity associate = repo.findByPhoneNumber(phoneNumber);
            associates.add(associate);
        }
        return associates;
    }

	@Override
	public PeopleMobileEntity getPhoneNumber(PeopleMobileEntity peopleMobileEntity) {
		String forenames = peopleMobileEntity.getForenames();
		String surname = peopleMobileEntity.getSurname();
		String address = peopleMobileEntity.getAddress();
		PeopleMobileEntity phoneNumber = repo.findByForenames(forenames, surname, address);
		return phoneNumber;
	}

}
