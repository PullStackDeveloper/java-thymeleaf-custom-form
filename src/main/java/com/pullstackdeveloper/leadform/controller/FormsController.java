package com.pullstackdeveloper.leadform.controller;

import com.pullstackdeveloper.leadform.dto.FeedbackDTO;
import com.pullstackdeveloper.leadform.dto.LeadDTO;
import com.pullstackdeveloper.leadform.service.FeedbackService;
import com.pullstackdeveloper.leadform.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class FormsController {

    @Autowired
    private LeadService leadService;
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/form")
    public String showForm(@RequestParam(name = "type", defaultValue = "lead") String type,
                           @Valid FeedbackDTO feedbackDTO, BindingResult feedbackResult,
                           @Valid LeadDTO leadDTO, BindingResult leadResult,
                           Model model) {
        switch (type) {
            case "feedback":
                model.addAttribute("feedback", new FeedbackDTO());
                return "feedbackForm";
            case "lead":
            default:
                model.addAttribute("lead", new LeadDTO());
                return "leadForm";
        }
    }


    @PostMapping("/submit")
    public String submitForm(@RequestParam(name = "type", defaultValue = "lead") String type,
                             @Valid FeedbackDTO feedbackDTO, BindingResult feedbackResult,
                             @Valid LeadDTO leadDTO, BindingResult leadResult,
                             Model model) {
        if ("feedback".equals(type)) {
            if (feedbackResult.hasErrors()) {
                // Add feedback object back to the model to re-render the form with error messages
                model.addAttribute("feedback", feedbackDTO);
                return "feedbackForm";
            }
            feedbackService.saveFeedback(feedbackDTO);
            model.addAttribute("message", "Feedback submitted successfully!");
            model.addAttribute("feedback", new FeedbackDTO()); // Add a new FeedbackDTO to the model
            return "feedbackForm";
        } else {
            if (leadResult.hasErrors()) {
                // Add lead object back to the model to re-render the form with error messages
                model.addAttribute("lead", leadDTO);
                return "leadForm";
            }
            leadService.saveLead(leadDTO);
            model.addAttribute("message", "Lead submitted successfully!");
            model.addAttribute("lead", new LeadDTO()); // Add a new LeadDTO to the model
            return "leadForm";
        }
    }
}