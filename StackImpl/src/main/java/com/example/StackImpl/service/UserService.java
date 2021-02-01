package com.example.StackImpl.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StackImpl.entity.User;
import com.example.StackImpl.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public List<User> push(User user) {

		repository.save(user);

		return repository.findAll();
	}

	public List<User> pop() {

		List<User> users = repository.findAll();

//		Comparator sortById =new Comparator<User>() {
//
//			@Override
//			public int compare(User o1, User o2) {
//				// TODO Auto-generated method stub
//				if(o1.getId() < o2.getId()) {
//                    return -1;
//                } else if (o1.getId() > o2.getId()) {
//                    return 1;
//                } else {
//                    return 0;
//                }
//				
//			}
//		};

		// Collections.sort(users, Comparator.comparing(User::getId));

		// Collections.reverse(users);
		if (users.size() > 0) {
			List<User> sortedUsers = users.stream().sorted(Comparator.comparing(User::getId))
					.collect(Collectors.toList());
			User lastUser = sortedUsers.get(0);
			repository.delete(lastUser);

		}

		return repository.findAll();
	}

	public List<User> getAllUsers() {

		return repository.findAll();
	}

}
