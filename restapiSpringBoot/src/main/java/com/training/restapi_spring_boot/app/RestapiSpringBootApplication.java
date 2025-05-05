package com.training.restapi_spring_boot.app;

import com.training.restapi_spring_boot.app.dao.TraineeDAO;
import com.training.restapi_spring_boot.app.models.Trainee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static java.lang.System.out;

@SpringBootApplication(
		scanBasePackages = {
				"com.components",
				"com.training.restapi_spring_boot"
		}
)
public class RestapiSpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestapiSpringBootApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandineunner(TraineeDAO traineedao){
		return runner -> {
//			createNewTrainee(traineedao);
//			findTrainee(traineedao);
			getLastName(traineedao);
		};
	}

	public void createNewTrainee(TraineeDAO traineedao){
		out.println("making new trainee object");
		try {
			Trainee newTrainee = new Trainee("ali3@yahoo.com", "loka3", "ali");
			traineedao.save(newTrainee);
		}
		catch (Exception e){
			out.println(e.getMessage());
		}

	}

	public void findTrainee(TraineeDAO traineedao){
		try{
			Trainee trainee = traineedao.getTraineeById(2L);
			out.println(trainee);
		}
		catch(Exception e){
			out.println(e.getMessage());
		}
	}

//	public void getAllTrainees(TraineeDAO traineedao){
//		try{
//			List<Trainee> trainees = traineedao.getAllTrainees();
//			for(Trainee t:trainees){
//				out.println(t);
//			}
//		}
//		catch(Exception e){
//			out.println(e.getMessage());
//		}
//	}

	public void getLastName(TraineeDAO traineedao) {
		try {
			String lastNames = traineedao.getLastName("ali2@yahoo.com");
			out.println(lastNames);
		}
		catch (Exception e){
			out.println(e.getMessage());
		}
	}
}

