package com.psl.vms.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.psl.vms.model.Visitor;
import com.psl.vms.service.VisitorService;

@RestController
@RequestMapping("/visitors")
public class VisitorController {

	@Autowired
	VisitorService visitorService;
	
	/**
	 * Create Visitor
	 * @param visitor
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Visitor createVisitor(@RequestBody Visitor visitor) {
		return visitorService.createVisitor(visitor);
	}
	
	/**
	 * Read Visitor By Id
	 * @param visitorId
	 * @return
	 */
	@RequestMapping(value = "/{visitorId}", method = RequestMethod.GET)
	public Visitor readVisitorById(@PathVariable("visitorId") String visitorId) {
		Visitor visitor = visitorService.readVisitorById(visitorId);
		System.out.println(visitor.toString());
		return visitor;
	}
	
	/**
	 * Read Vistor By Location
	 * @param location
	 * @param date
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Visitor> readVisitorsByLocation(@RequestParam(value = "location", required=false) String location, @RequestParam(value = "date", required=false) String date) {
		List<Visitor> listVisitor = null;
		if((location != null) && (date != null)){
			listVisitor = visitorService.readVisitorsByLocationandDate(location, date);
			System.out.println("location and date");
		}else if(location != null){
			listVisitor = visitorService.readVisitorsByLocation(location);
			System.out.println("location");
		}else if(date != null){
			listVisitor = visitorService.readVisitorsByDate(date);
			System.out.println("date");
		}else{
			listVisitor = visitorService.readVisitors();
			System.out.println("all");
		}
		System.out.println(listVisitor);
		return listVisitor;
	}
	
	/**
	 * Delete Visitor By visitor Id
	 * @param visitorId
	 * @return
	 */
	@RequestMapping(value = "/{visitorId}", method = RequestMethod.DELETE)
	public Visitor removeVisitor(@PathVariable("visitorId") String visitorId){
		return visitorService.removeVisitorById(visitorId);
	}
	
	/**
	 * edit visitor
	 * @param visitor
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Visitor editVisitor(@RequestBody Visitor visitor) {
		System.out.println(visitor.toString());
		return visitorService.editVisitor(visitor);
	}
	
	/**
	 * upload Image
	 * @param file
	 * @return
	 */
	@RequestMapping(value="/upload", method=RequestMethod.POST)
    public String handleFileUpload( 
            @RequestParam("file") MultipartFile file){
            String name = "test11";
            
        if (!file.isEmpty()) {
            try {
            	
            	InputStream inputStream = null;
            	OutputStream outputStream = null;
            	
            	inputStream = file.getInputStream();
            	outputStream = new FileOutputStream("D:\\Temp\\" + file.getOriginalFilename());
            	System.out.println(file.getOriginalFilename());
            	
            	int readBytes = 0;
            	byte[] buffer = new byte[8192];
            	
            	while((readBytes = inputStream.read(buffer, 0, 8192)) != -1){
            		outputStream.write(buffer, 0 , readBytes);
            	}
            	inputStream.close();
            	outputStream.close();
                /*byte[] bytes = file.getBytes();
                BufferedOutputStream stream = 
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();*/
                
            } catch (Exception e) {
                
            }
        } else {
            
        }
        
        return "Done";
    }
}
