package email;

import email.model.Email;
import email.model.EmailForm;
import email.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String indexForm(Model model) {
        model.addAttribute("emailForm", new EmailForm());
        return "booking";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@ModelAttribute EmailForm emailForm, Model model) {
        if (emailForm.getRoom().isEmpty()) {
            model.addAttribute("error", "'Комната' не должно быть пустым");
            return "index";
        }
        emailService.save(new Email(emailForm.getDateIn(), emailForm.getDateOut(), emailForm.getRoom(), emailForm.getGuestCount()));
        model.addAttribute("emails", emailService.getAllEmails());
        return "list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("emails", emailService.getAllEmails());
        return "list";
    }
}
