package com.email.gmail;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
@PropertySource("classpath:application.properties")
public class EmailService {

    final Configuration configuration;
    final JavaMailSender javaMailSender;

    public EmailService(Configuration configuration, JavaMailSender javaMailSender) {
        this.configuration = configuration;
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(UserInfo user) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("Vashista's Email");
        helper.setTo(user.getEmail());
        String emailContent = getEmailContent(user);
        helper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
    }
    @Value("${f.path}")
    String path;
    String getEmailContent(UserInfo user) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates/");
        configuration.getTemplate(path).process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
