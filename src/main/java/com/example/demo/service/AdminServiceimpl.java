package com.example.demo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AdminEntity;
import com.example.demo.repositary.AdminRepositary;
@Service
public class AdminServiceimpl implements AdminService {
	 private volatile List<Double> previousGenValues = new ArrayList<Double>();
    @Autowired
	private AdminRepositary repo;
    @Autowired
    private JavaMailSender mailSender;

	@Override
	public AdminEntity save(AdminEntity entity) {
		AdminEntity savedentity=repo.save(entity);
		return savedentity;
	}

	    public String getUniqtValue() {
	        Random random = new Random();
	        double nextValue=0;
	        while(previousGenValues.contains(Double.valueOf(nextValue))) {
	            nextValue = random.nextDouble();
	        }
	        previousGenValues.add(Double.valueOf(nextValue));
	        return String.valueOf(nextValue);
	    }
	    public void sendSimpleEmail(String toEmail,
	                                String body,
	                                String subject) {
	        SimpleMailMessage message = new SimpleMailMessage();

	        message.setFrom("ashokkumarpanda1995@gmail.com");
	        message.setTo(toEmail);
	        message.setText(body);
	        message.setSubject(subject);

	        mailSender.send(message);
	        System.out.println("Mail Send...");
	    }

	    public void sendEmailWithAttachment(String toEmail,
	                                        String body,
	                                        String subject,
	                                        String attachment) throws MessagingException {

	        MimeMessage mimeMessage = mailSender.createMimeMessage();

	        MimeMessageHelper mimeMessageHelper
	                = new MimeMessageHelper(mimeMessage, true);

	        mimeMessageHelper.setFrom("ashokkumarpanda1995@gmail.com");
	        mimeMessageHelper.setTo(toEmail);
	        mimeMessageHelper.setText(body);
	        mimeMessageHelper.setSubject(subject);

	        FileSystemResource fileSystem
	                = new FileSystemResource(new File(attachment));

	        mimeMessageHelper.addAttachment(fileSystem.getFilename(),
	                fileSystem);

	        mailSender.send(mimeMessage);
	        System.out.println("Mail Send...");

	    }
}
