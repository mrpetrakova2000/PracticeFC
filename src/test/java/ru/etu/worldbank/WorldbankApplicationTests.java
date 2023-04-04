//package ru.etu.worldbank;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import ru.etu.worldbank.models.User;
//import ru.etu.worldbank.service.UserService;
//
//import java.util.List;
//
//@SpringBootTest
//class WorldbankApplicationTests {
//	@Autowired
//	private UserService service;
//
//	@Test
//	void viewAll() {
//		List<User> users = service.getAll();
//		assert users != null;
//		for (User user : users){
//			user.viewUser();
//		}
//	}
//
//	@Test
//	void addUser() {
//		User user = new User("marina", "password");
//		User added = service.addUser(user);
//		assert added != null;
//		added.viewUser();
//	}
//
//	@Test
//	void findById() {
//		User user = service.findById(2);
//		assert user != null;
//		user.viewUser();
//	}
//
//	@Test
//	void findByLogin() {
//		User user = service.findByUsername("marina");
//		assert user != null;
//		user.viewUser();
//	}
//
//}
