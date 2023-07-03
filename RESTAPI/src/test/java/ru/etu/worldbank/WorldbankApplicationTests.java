//package ru.etu.worldbank;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import ru.etu.worldbank.models.FemaleInMathDm;
//import ru.etu.worldbank.service.FemaleInMathDmService;
//
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//class WorldbankApplicationTests {
//	@Autowired
//	private FemaleInMathDmService service;
//
//	@Test
//	void viewAll() {
//		List<FemaleInMathDm> female = service.get(null);
//		assert female != null;
//		for (FemaleInMathDm fem : female){
//			fem.view();
//		}
//	}
//
//	@Test
//	void view() {
//		List<FemaleInMathDm> female = service.get(Optional.of("TUR"));
//		assert female != null;
//		for (FemaleInMathDm fem : female){
//			fem.view();
//		}
//	}
//
//}
