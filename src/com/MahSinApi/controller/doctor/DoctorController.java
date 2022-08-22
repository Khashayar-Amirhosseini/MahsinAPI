package com.MahSinApi.controller.doctor;
import com.MahSinApi.common.ServerAddress;
import com.MahSinApi.model.entity.Doctor;
import com.MahSinApi.model.service.DoctorService;
import com.MahSinApi.model.service.LikeService;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;


@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private UserService userService;
    @Autowired
    private LikeService likeService;

    private static  String UPLOAD_DIRECTORY = ServerAddress.UPLOAD_DIRECTORY;
    private static  String IMAGE_DIRECTORY=ServerAddress.IMAGE_DIRECTORY;
    @RequestMapping(value = "/doctor/saveDoctor.do",method=RequestMethod.POST)
    public Object saveDoctor(@ModelAttribute Doctor doctor,
                             @RequestParam long userId,
                             @RequestParam CommonsMultipartFile file) {
        try {
            doctor.setUser(userService.findOne(userId))
                    .setRecordControl(1)
                    .setLastUpdateDate(new Date(System.currentTimeMillis()))
                    .setState("active");
            doctorService.save(doctor);
            if (file.isEmpty()){}
            else{
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY+doctor.getId()+".png"));
                System.out.println("doctor picture has been saved");}

            System.out.println("doctor has been saved");
            System.out.println(doctor.toString());
            return doctor;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return e;
        }
    }

    @RequestMapping(value = "/doctor/updateDoctor.do",method = RequestMethod.POST)
    public Object updateDoctor(@ModelAttribute Doctor doctor,
                               @RequestParam final MultipartFile file,
                               @RequestParam long userId){
        try {
            System.out.println(doctor);
            System.out.println(file);
            System.out.println(userId);
            Date date=new Date(System.currentTimeMillis());
            doctor.setLastUpdateDate(date)
                    .setUser(userService.findOne(userId))
                    .setRecordControl(doctorService.findOne(doctor.getId()).getRecordControl());
            doctorService.update(doctor);
            System.out.println(doctor.toString());
            System.out.println("the mentioned doctor has been updated");
            if (file.isEmpty()){}
            else{
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY+doctor.getId()+".png"));
                System.out.println("doctor picture has been updated");}

            System.out.println("doctor has been saved");
            System.out.println(doctor.toString());
            return findAllDoctors();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }





    @RequestMapping("/guest/findAllDoctors.do")@ResponseBody
    public Object findAllDoctors(){
        try {


            List<Doctor> doctorList=doctorService.findAll();
            List<Object> doctors=new ArrayList<>();
            for (Doctor d:doctorList){
                HashMap<String,Object> map=new HashMap<String,Object>();
                map.put("id",d.getId());
                map.put("name",d.getName());
                map.put("family",d.getFamily());
                map.put("medicalId",d.getMedicalId());
                map.put("state",d.getState());
                map.put("about",d.getAbout());
                map.put("user",d.getUser());
                map.put("like",likeService.findCountOfActionByDoctor(d,"like"));
                map.put("disLike",likeService.findCountOfActionByDoctor(d,"disLike"));
                map.put("image",String.valueOf(getDoctorPicture(d.getId())));
                map.put("date",d.getLastUpdateDate());
                doctors.add(map);
            }
            System.out.println("All doctors have been fetched");
            return doctors;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findOnDoctor.do")@ResponseBody
    public Map<String,Object> findOnDoctor(long id){
        try {
            HashMap<String,Object> map=new HashMap<String,Object>();
            Doctor doctor=doctorService.findOne(id);
            map.put("id",doctor.getId());
            map.put("name",doctor.getName());
            map.put("family",doctor.getFamily());
            map.put("medicalId",doctor.getMedicalId());
            map.put("state",doctor.getState());
            map.put("about",doctor.getAbout());
            map.put("user",doctor.getUser());
            map.put("like",likeService.findCountOfActionByDoctor(doctor,"like"));
            map.put("disLike",likeService.findCountOfActionByDoctor(doctor,"disLike"));
            map.put("image",String.valueOf(getDoctorPicture(id)));
            map.put("date",doctor.getLastUpdateDate());


            //doctor.setImage(String.valueOf(getDoctorPicture(id)));
           // doctor.setLike(likeService.findCountOfActionByDoctor(doctor,"like"));
           // doctor.setDislike(likeService.findCountOfActionByDoctor(doctor,"disLike"));
            System.out.println("the doctor has been fetched");
            System.out.println(doctor.toString());
            return map;
        }
        catch (Exception e){
            HashMap<String,Object> map=new HashMap<String,Object>();
            System.out.println(e.getMessage());
            map.put("exception",e);
            return map ;
        }
    }
    /*@RequestMapping(value = "/guest/getDoctorPicture.do",produces = MediaType.IMAGE_JPEG_VALUE)
    public Object getDoctorPicture(@RequestParam long doctorId) throws IOException {
        try {

            File file=new File("C:\\demo\\demofile.txt");
            FileInputStream fis=new FileInputStream(file);

            InputStream in = getClass()
                    .getResourceAsStream(UPLOAD_DIRECTORY+doctorId+".png");
            System.out.println(UPLOAD_DIRECTORY+doctorId+".png");
            return IOUtils.toByteArray(in);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }*/
    /*@RequestMapping(value = "/guest/getDoctorPicture.do", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getDoctorPicture(@RequestParam long doctorId) throws IOException {

         imgFile = new ClassLoader(UPLOAD_DIRECTORY+doctorId+".png");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }*/
    @RequestMapping(value = "/guest/getDoctorPicture.do")
    public Object getDoctorPicture(@RequestParam long doctorId)
            throws IOException {
        File file = new File(UPLOAD_DIRECTORY+doctorId+".png");
        if(file.exists()) {
            /*HttpHeaders respHeaders = new HttpHeaders();
            respHeaders.setContentType(MediaType.IMAGE_PNG);
            return new ResponseEntity<>(
                    new FileSystemResource(file),respHeaders, HttpStatus.OK);*/
            return IMAGE_DIRECTORY+String.valueOf(doctorId)+".png";
        }
        else {
            return null;
        }
        /*HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentType(MediaType.IMAGE_PNG);
        respHeaders.setContentDispositionFormData("attachment", "fileNameIwant.pdf");*/
    }
    @RequestMapping("/admin/deleteDoctor.do")
    public Object deleteDoctor(@RequestParam long doctorId){
        try {
            Doctor doctor=doctorService.findOne(doctorId);
            doctorService.delete(doctor);
            File file=new File(UPLOAD_DIRECTORY+doctorId+".png");
            file.delete();
            System.out.println(doctor.toString());
            System.out.println("the mentioned doctor has been deleted");
            return findAllDoctors();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }


}

