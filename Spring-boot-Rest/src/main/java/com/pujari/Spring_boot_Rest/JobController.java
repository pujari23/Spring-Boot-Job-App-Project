package com.pujari.Spring_boot_Rest;

import com.pujari.Spring_boot_Rest.model.JobPost;
import com.pujari.Spring_boot_Rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// controller + responseBody(when you want to return data)
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService service;



    @GetMapping(path="jobPosts", produces = {"application/json"})//it only gives json format
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJobPost(@PathVariable int postId){
        return service.getJobPost(postId);
    }



    @PostMapping(path = "jobPost")//server only accept in xml format , consumes = {"application/xml"}
    public JobPost addJob(@RequestBody JobPost jobPost){//@RequestBody when you want to accept data
        service.addJob(jobPost);
        return service.getJobPost(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){//conversion of json data is by jackson library
        service.updateJob(jobPost);               //by default jackson will work on only JSON
        return service.getJobPost(jobPost.getPostId());//if we want to work with xml then we have to add another jackson library
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("load")
    public String load(){
        service.load();
        return "success";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }

}
