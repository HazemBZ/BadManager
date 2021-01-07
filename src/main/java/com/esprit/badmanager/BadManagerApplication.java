package com.esprit.badmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.esprit.badmanager.entities.Classroom;
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
//@EnableDiscoveryClient
@EnableEurekaClient
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
			
			// TASKS 
			Task task = new Task();
			task.setDescription("Do stuff at the set amount of time");
			task.setDuration(12.2f);
			task.setName("Small Task");
			Task saved_task= taskRepo.save(task);
			//Subjects part0
			List<Subject> subjects = new ArrayList();
			Stream.of("WSN", "Systems and Processing", "CellularNetworks").forEach(sub -> {
				Subject s  = new Subject(sub, sub+"-4IoSys");// random generated ids (do not start from 1)
				User tut = new User("Peter", "peter@domain.bla","TUTOR");
				
				s.setTutor(userRepo.save(tut).getId());
//				s.set
				subjectRepo.save(s);
				System.out.println(s+" saved");
			});
			Subject ssub = subjectRepo.findSubjectByName("WSN").orElse(null);
			System.out.println("REPO SUBJECT FOUND");
			System.out.println(ssub);
			Task ttask = taskRepo.findById(2l).orElse(null);
			
			if (ssub != null && ttask != null) {
				System.out.println("FOUND AND SAVING TASK TO SUVJECT");
				task.setSubject(ssub.getId());
//				ssub.addTask(task);
				taskRepo.save(ttask);
			}
			System.out.println("FAILED TASK TO SUBJECT");
			
			//Team
			Team t = new Team("butterflies");
			t.setSubjectSubscriptions(Arrays.asList(subjectRepo.findSubjectByName("WSN").orElse(null)));
			Team tm = new Team("skulls");
			groupRepo.save(tm);
			groupRepo.save(t);
			
			List<User> teamMembers = t.getMembers();
			Stream.of("dude", "hazem", "majid").forEach(name->{
				User u = new User(name, name+"@damain.tn", "STUDENT");
				u.setGroups(Arrays.asList(t));
				teamMembers.add(u);
				userRepo.save(u);
				System.out.println(u+" saved");
			});
			t.setMembers(teamMembers); // this was bad (double transcient reference errors)
			groupRepo.save(t);
			// Task
			Task t1 = new Task("Drink coffee","You have to buy and drink a cup of coffee",subjectRepo.findSubjectByName("WSN").orElse(null).getId(), Arrays.asList(t,t));
			taskRepo.save(t1);
			
			// CLASSROOM 
			List<User> classroom_members = new ArrayList<User>();
			User tutor = new User("walid", "walid@domain.tn","TUTOR");
			
			classroom_members.addAll(teamMembers);
			classroom_members.add(tutor);
			userRepo.save(tutor);
			Classroom iosysClass = new Classroom("4ioSys", classroom_members, subjects);
			classRepo.save(iosysClass);
		};
	}

}
