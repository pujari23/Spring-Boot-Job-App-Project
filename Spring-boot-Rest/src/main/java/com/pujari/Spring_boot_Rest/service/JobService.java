package com.pujari.Spring_boot_Rest.service;

import com.pujari.Spring_boot_Rest.Repo.JobRepo;
import com.pujari.Spring_boot_Rest.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost){
        jobRepo.save(jobPost);
       // jobRepo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return jobRepo.findAll();
        //return jobRepo.getAllJobs();
    }

    public JobPost getJobPost(int postId) {
        return jobRepo.findById(postId).orElse(new JobPost());
        //return jobRepo.getJobPost(postId);
    }

    public void updateJob(JobPost jobPost) {
        jobRepo.save(jobPost);
        // jobRepo.updateJob(jobPost);
    }

    public void deleteJob(int postId) {
        jobRepo.deleteById(postId);
        // jobRepo.deleteJob(postId);

    }

    public void load() {

          List<JobPost> jobs = new ArrayList<>(Arrays.asList(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

                // Frontend Developer Job Post

                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")),

                // Data Scientist Job Post
                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),

                // Network Engineer Job Post
                new JobPost(4, "Network Engineer",
                        "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),

                // Mobile App Developer Job Post
                new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                        3, List.of("iOS Development", "Android Development", "Mobile App")),

                // DevOps Engineer Job Post
                new JobPost(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",
                        4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes"))));

          jobRepo.saveAll(jobs);

    }

    public List<JobPost> search(String keyword) {
        return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
