package com.pujari.Spring_boot_Rest.Repo;

import com.pujari.Spring_boot_Rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);

}

/*List<JobPost> jobs = new ArrayList<>(Arrays.asList(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
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

public void addJob(JobPost jobPost){
    jobs.add(jobPost);
}

public List<JobPost> getAllJobs(){
    return jobs;
}

public JobPost getJobPost(int postId) {
    for (JobPost post : jobs){
        if (post.getPostId() == postId){
            return post;
        }
    }
    return null;
}

public void updateJob(JobPost jobPost) {
    for (JobPost jobPost1 : jobs){
        if (jobPost1.getPostId() == jobPost.getPostId()){
            jobPost1.setPostDesc(jobPost.getPostDesc());
            jobPost1.setPostProfile(jobPost.getPostProfile());
            jobPost1.setReqExperience(jobPost.getReqExperience());
            jobPost1.setPostTechStack(jobPost.getPostTechStack());
        }
    }
}

public void deleteJob(int postId) {
    for (JobPost jobPost : jobs){
        if (jobPost.getPostId() == postId){
            jobs.remove(postId);
        }
    }
}*/
