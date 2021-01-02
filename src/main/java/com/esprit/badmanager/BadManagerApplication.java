package com.esprit.badmanager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.esprit.badmanager.entities.Subject;
import com.esprit.badmanager.entities.Task;
import com.esprit.badmanager.entities.Team;
import com.esprit.badmanager.entities.User;
import com.esprit.badmanager.repositories.ClassroomRepository;
import com.esprit.badmanager.repositories.SubjectRepository;
import com.esprit.badmanager.repositories.TaskRepository;
import com.esprit.badmanager.repositories.TeamRepository;
import com.esprit.badmanager.repositories.UserRepository;
import com.esprit.badmanager.services.EmailService;

//@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class BadManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BadManagerApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(UserRepository userRepo,
			TeamRepository groupRepo,
			SubjectRepository subjectRepo,
			TaskRepository taskRepo,
			ClassroomRepository classRepo,
			EmailService emService
			) {
		return args -> {
			System.out.println("APP PASS =>" + System.getenv("GMAIL_APP_PASS"));
//			emService.sendEmail();
			//Subjects part
			Stream.of("WSN", "Systems and Processing", "CellularNetworks").forEach(sub -> {
				Subject s  = new Subject(sub, sub+"-4IoSys");// random generated ids (do not start from 1)
//				s.set
				subjectRepo.save(s);
				System.out.println(s+" saved");
			});
			//Team
			Team t = new Team("butterflies");
			t.setSubjectSubscriptions(Arrays.asList(subjectRepo.findById(1l).orElse(null)));
			Team tm = new Team("skulls");
			groupRepo.save(tm);
			groupRepo.save(t);
			
			List<User> teamMembers = t.getMembers();
			Stream.of("dude", "hazem", "majid").forEach(name->{
				User u = new User(name, name+"@damain.tn");
				u.setGroups(Arrays.asList(t));
				teamMembers.add(u);
				userRepo.save(u);
				System.out.println(u+" saved");
			});
			t.setMembers(teamMembers); // this was bad (double transcient reference errors)
			groupRepo.save(t);
			// Task
			Task t1 = new Task("Drink coffee","You have to buy and drink a cup of coffee", (Subject)subjectRepo.findById(1l).orElse(null), Arrays.asList(t,t));
			taskRepo.save(t1);
		};
	}

}
