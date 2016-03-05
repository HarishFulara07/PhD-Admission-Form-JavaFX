/*
 * @author
 * 
 * Harish Fulara(2014143)
 * Anant Mittal(2014015)
 */

package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MyController {

	/*
	 * ID's for the fields in personal information
	 */
	
	@FXML
	private TextField email, name, eno, mobile, father_name, pin, c_addr1, c_addr2, c_addr3, p_addr1, p_addr2, p_addr3;
	@FXML
	private ComboBox<String> pref1, pref2, pref3, nationality;
	@FXML
	private RadioButton stream_cs, stream_ece, stream_cb, male, female, general, st, sc, obc, pd_yes, pd_no, war_yes, war_no;
	@FXML
	private DatePicker dob;
	@FXML
	private Text prompt1, wrong0, wrong1, wrong2, wrong3, wrong4, wrong5, wrong6, wrong7, wrong8, wrong9, wrong10, wrong11, wrong12, wrong13, wrong14;
	
	/*
	 * ID's for the fields in education information
	 */
	
	@FXML
	private TitledPane title1, title2, title3, title4;
	@FXML
	private CheckBox check1, check2, check3, check4;
	@FXML
	private RadioButton xcgpa, xpercentage, gradcgpa, gradpercentage, pgcgpa, pgpercentage;
	@FXML
	private TextField xmark1, xmark2, xiimark, collegename, universityname
	, collegecity, gradmark1, gradmark2, pgcollege, pgcity, pgthesis, pgmark1, pgmark2
	, otherexam, othersubject, otherscore, otherrank, gatearea, gatemark, gatescore, gaterank;
	@FXML
	private ComboBox<String> outof1, xyear, xiiyear, collegestate, gradyear, gradstate, outof2, ece_pref1, ece_pref2
	, ece_pref3,ece_pref4, pgstate, pgyear, outof3, otheryear, gateyear, xboard, xiiboard, degree, discipline, pgdegree, pgdiscipline;
	@FXML
	private TextArea achievement;
	@FXML
	private Text prompt2, wrong15, wrong16, wrong17, wrong18, wrong19, wrong20, wrong21, wrong22, wrong23, wrong24, wrong25
	,wrong26, wrong27, wrong28, wrong29, wrong30, wrong31, wrong32, wrong33, wrong34, wrong35, wrong36
	, wrong37, wrong38, wrong39, wrong40, wrong41, wrong42, wrong43, wrong44, wrong45, wrong46, wrong47, wrong48, wrong49, wrong50
	, nofile1, nofile2, success1, success2;
	
	/*
	 * ID's for the fields in submit tab
	 */
	
	@FXML
	private Button submit;
	
	/*
	 * Other Declarations
	 */
	
	BufferedWriter writer = null;
	BufferedReader reader = null;
	BufferedWriter writer1 = null;
	LocalDate localDate;
	int tabflag1 = 0, tabflag2 = 0;
	
	/*
	 * Implementations for Tab1
	 */
	
	@FXML
	public void tab1selected(Event event)
	{
		pref1.setItems(FXCollections.observableArrayList("---Mandatory---"));
		pref2.setItems(FXCollections.observableArrayList("---Optional---"));
		pref3.setItems(FXCollections.observableArrayList("---Optional---"));
		nationality.getItems().addAll("Afghan","Albanian","Algerian","American","Andorran","Angolan",
				"Argentine","Armenian","Aromanian","Aruban","Australian","Austrian","Azeri","Bahamian","Bahraini"
				,"Bangladeshi","Barbadian","Belarusian","Belgian","Belizean","Bermudian","Boer","Bosniak","Brazilian","Breton"
				,"British","British Virgin Islander","Bulgarian","Burmese","Macedonian Bulgarian","Burkinabè","Burundian"
				,"Cambodian","Cameroonian","Canadian","Catalan","Cape Verdean","Chadian"
				,"Chilean","Chinese","Colombian","Comorian","Congole","Croatian","Cuban","Cypriot","Turkish Cypriot"
				,"Czech","Dane","Dominican (Republic)","Dominican (Commonwealth)","Dutch","East Timorese","Ecuadorian"
				,"Egyptian","Emirati","English","Eritrean","Estonian","Ethiopian","Faroese","Finn","Finnish Swedish","Fijian"
				,"Filipino","French citizen","Georgian","German","Baltic German","Ghanaian","Gibraltar","Greek","Greek Macedonian","Grenadian"
				,"Guatemalan","Guianese (French)","Guinean","Guinea-Bissau national","Guyanese","Haitian","Honduran","Hong Kong"
				,"Hungarian","Icelander","Indian","Indonesian","Iranian (Persian)","Iraqi","Irish","Israeli","Italian","Ivoirian"
				,"Jamaican","Japanese","Jordanian","Kazakh","Kenyan","Korean","Kosovo Albanian","Kurd","Kuwaiti","Lao","Latvian","Lebanese"
				,"Liberian","Libyan","Liechtensteiner","Lithuanian","Luxembourger","Macedonian","Malagasy","Malaysian","Malawian"
				,"Maldivian","Maldivian","Malian","Maltes","Manx","Mauritian","Mexican","Moldovan","Moroccan","Mongolian","Montenegrin","Namibian"
				,"Nepalese","New Zealander","Nicaraguan","Nigerien","Nigerian","Norwegian","Pakistani","Palauan","Palestinian","Panamanian"
				,"Papua New Guinean","Paraguayan","Peruvian","Pole","Portuguese","Puerto Rican","Quebecer","Réunionnai","Romanian"
				,"Russian","Baltic Russians","Rwandan","Salvadoran","São Tomé and Príncipe","Saudi","Scot","Senegalese","Serb"
				,"Sierra Leonean","Singaporean","Sindhian","Slovak","Slovene","Somali","South African","Spaniard","Sri Lankan","St Lucian"
				,"Sudanese","Surinamese","Swede","Swiss","Syrian","Taiwanese","Tanzanian","Thai","Tibetan","Tobagonian","Trinidadian"
				,"Tunisian","Turk","Tuvaluan","Ugandan","Ukrainian","Uruguayan","Uzbek","Vanuatuan","Venezuelan","Vietnames","Welsh","Yemeni","Zambians","Zimbabwean");

		 nationality.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), nationality.getValue(), nationality.getItems());
		            if (s != null) {
		                nationality.setValue(s);
		            }
		        }
		 });
	}
	
	/*
	 * Nationality Jumper Function
	 */
	
	static String jumpTo(String keyPressed, String currentlySelected, List<String> items)
	{
	    String key = keyPressed.toUpperCase();
	    if (key.matches("^[A-Z,0-9]$")) 
	    {
	        boolean letterFound = false;
	        boolean foundCurrent = currentlySelected == null;
	        for (String s : items)
	        {
	            if (s.toUpperCase().startsWith(key)) 
	            {
	                letterFound = true;
	                if (foundCurrent) 
	                {
	                    return s;
	                }
	                foundCurrent = s.equals(currentlySelected);
	            }
	        }
	        if (letterFound) 
	        {
	            return jumpTo(keyPressed, null, items);
	        }
	    }
	    return null;
	}
	
	@FXML
	public void csOnAction(ActionEvent event)
	{
		pref1.setItems(FXCollections.observableArrayList("Artificial Intelligence and Robotics","Compilers","Computer Architecture and System Design"
				,"Computer Graphics","Computer Vision","Image Analysis and Biometrics","Information Management and Data Engineering"
				,"Machine Learning","Massively Parallel Systems","Mobile Computing and Networking Applications","Program Aalysis"
				,"Security and Privacy","Signal and Image Processing","Software Engineering","Theoretical Computer Science","Wireless Networks"));
	
		pref2.setItems(FXCollections.observableArrayList("Artificial Intelligence and Robotics","Compilers","Computer Architecture and System Design"
				,"Computer Graphics","Computer Vision","Image Analysis and Biometrics","Information Management and Data Engineering"
				,"Machine Learning","Massively Parallel Systems","Mobile Computing and Networking Applications","Program Aalysis"
				,"Security and Privacy","Signal and Image Processing","Software Engineering","Theoretical Computer Science","Wireless Networks"));
		
		pref3.setItems(FXCollections.observableArrayList("Artificial Intelligence and Robotics","Compilers","Computer Architecture and System Design"
				,"Computer Graphics","Computer Vision","Image Analysis and Biometrics","Information Management and Data Engineering"
				,"Machine Learning","Massively Parallel Systems","Mobile Computing and Networking Applications","Program Aalysis"
				,"Security and Privacy","Signal and Image Processing","Software Engineering","Theoretical Computer Science","Wireless Networks"));
	}
	
	@FXML
	public void eceOnAction(ActionEvent event)
	{
		pref1.setItems(FXCollections.observableArrayList("Computer Architecture and System Design","Controls and Robotics"
				,"Digital and Analog VLSI Systems Design","Electromagnetics","Embedded and VLSI Systems Design"
				,"Embedded Sysems","Fiber-Wireless Architecture","Machine Learning","OFDM based Optical Access Networks"
				,"Optical Wireless Communication Systems","RF and Mixed Signal Electronics","Signal and Image Processing"
				,"Wireless Communication","Wireless Networks"));
		
		pref2.setItems(FXCollections.observableArrayList("Computer Architecture and System Design","Controls and Robotics"
				,"Digital and Analog VLSI Systems Design","Electromagnetics","Embedded and VLSI Systems Design"
				,"Embedded Sysems","Fiber-Wireless Architecture","Machine Learning","OFDM based Optical Access Networks"
				,"Optical Wireless Communication Systems","RF and Mixed Signal Electronics","Signal and Image Processing"
				,"Wireless Communication","Wireless Networks"));
		
		pref3.setItems(FXCollections.observableArrayList("Computer Architecture and System Design","Controls and Robotics"
				,"Digital and Analog VLSI Systems Design","Electromagnetics","Embedded and VLSI Systems Design"
				,"Embedded Sysems","Fiber-Wireless Architecture","Machine Learning","OFDM based Optical Access Networks"
				,"Optical Wireless Communication Systems","RF and Mixed Signal Electronics","Signal and Image Processing"
				,"Wireless Communication","Wireless Networks"));
	}
	
	@FXML
	public void cbOnAction(ActionEvent event)
	{
		pref1.setItems(FXCollections.observableArrayList("Biophysics","Structural Biology","Systems Biology"));
		pref2.setItems(FXCollections.observableArrayList("Biophysics","Structural Biology","Systems Biology"));
		pref3.setItems(FXCollections.observableArrayList("Biophysics","Structural Biology","Systems Biology"));
	}
	
	/*
	 * Implementations for Tab2
	 */
	
	@FXML
	public void tab2selected(Event event)
	{
		
		outof1.setItems(FXCollections.observableArrayList("4","10"));
		outof2.setItems(FXCollections.observableArrayList("4","10"));
		outof3.setItems(FXCollections.observableArrayList("4","10"));
		
		xboard.getItems().addAll("Andhra Pradesh Board of Intermediate Education","Andhra Pradesh Board of Secondary Education","Board of Higher Secondary Education, Delhi"
				,"Assam Board of Secondary Education","Bihar School Examination Board","Board of Youth Education India","Board of School Education, Haryana"
				,"Board of Secondary Education, Madhya Pradesh","Board of Secondary Education Madhya Bharat Gwalior","Board of Secondary Education, Rajasthan"
				,"Chhattisgarh Board of Secondary Education","Central Board of Secondary Education","Central Board Of Patna, Bihar","Central Board Of Education Ajmer New Delhi"
				,"Goa Board of Secondary & Higher Secondary Education","Gujarat Secondary Education Board","Himachal Pradesh Board of School Education"
				,"Indian Board of Science Education(not recognized)","Indian Board of School Education","Indian Board of Computer Education","J&K State Board of School Education"
				,"Jharkhand Academic Council(not recognized)","Karnataka Board of the Pre-University Education","Karnataka Secondary Education Examination Board"
				,"Kerala Board of Public Examinations","Maharashtra State Board of Secondary and Higher Secondary Education","Manipur Board of Secondary Education"
				,"Manipur Council of Higher Secondary Education","Meghalaya Board of School Education","Mizoram Board of School Education","Northwest Accreditation Commission"
				,"Nagaland Board of School Education","National Institute of Open Schooling","Orissa Board of Secondary Education","Orissa Council of Higher Secondary Education"
				,"Punjab School Education Board","Rajasthan Board of Secondary Education","Tamil Nadu Board of Higher Secondary Education"
				,"Tamil Nadu Board of Secondary Education","Tamilnadu Council for Open and Distance Learning","Tripura Board of Secondary Education"
				,"Telangana Board of Intermediate Education","Telangana Board of Secondary Education","Uttar Pradesh Board of High School and Intermediate Education"
				,"Sampurnanand Sanskrit Vishwavidyalaya Varanasi Uttar Pradesh","Uttarakhand Board of School Education","West Bengal Board of Secondary Education"
				,"West Bengal Council of Higher Secondary Education","West Bengal State Council of Vocational Education and Training"
				,"Board of Secondary Education Kant Shahjahanpur Uttar Pradesh","The West Bengal Council of Rabindra Open Schooling"
				,"Institution of Secondary Distance Education (ISDE) Approved by Distance Education Council & Permanent Equivalency granted by MPBSE");
		
		xiiboard.getItems().addAll("Andhra Pradesh Board of Intermediate Education","Andhra Pradesh Board of Secondary Education","Board of Higher Secondary Education, Delhi"
				,"Assam Board of Secondary Education","Bihar School Examination Board","Board of Youth Education India","Board of School Education, Haryana"
				,"Board of Secondary Education, Madhya Pradesh","Board of Secondary Education Madhya Bharat Gwalior","Board of Secondary Education, Rajasthan"
				,"Chhattisgarh Board of Secondary Education","Central Board of Secondary Education","Central Board Of Patna, Bihar","Central Board Of Education Ajmer New Delhi"
				,"Goa Board of Secondary & Higher Secondary Education","Gujarat Secondary Education Board","Himachal Pradesh Board of School Education"
				,"Indian Board of Science Education(not recognized)","Indian Board of School Education","Indian Board of Computer Education","J&K State Board of School Education"
				,"Jharkhand Academic Council(not recognized)","Karnataka Board of the Pre-University Education","Karnataka Secondary Education Examination Board"
				,"Kerala Board of Public Examinations","Maharashtra State Board of Secondary and Higher Secondary Education","Manipur Board of Secondary Education"
				,"Manipur Council of Higher Secondary Education","Meghalaya Board of School Education","Mizoram Board of School Education","Northwest Accreditation Commission"
				,"Nagaland Board of School Education","National Institute of Open Schooling","Orissa Board of Secondary Education","Orissa Council of Higher Secondary Education"
				,"Punjab School Education Board","Rajasthan Board of Secondary Education","Tamil Nadu Board of Higher Secondary Education"
				,"Tamil Nadu Board of Secondary Education","Tamilnadu Council for Open and Distance Learning","Tripura Board of Secondary Education"
				,"Telangana Board of Intermediate Education","Telangana Board of Secondary Education","Uttar Pradesh Board of High School and Intermediate Education"
				,"Sampurnanand Sanskrit Vishwavidyalaya Varanasi Uttar Pradesh","Uttarakhand Board of School Education","West Bengal Board of Secondary Education"
				,"West Bengal Council of Higher Secondary Education","West Bengal State Council of Vocational Education and Training"
				,"Board of Secondary Education Kant Shahjahanpur Uttar Pradesh","The West Bengal Council of Rabindra Open Schooling"
				,"Institution of Secondary Distance Education (ISDE) Approved by Distance Education Council & Permanent Equivalency granted by MPBSE");
		
		
		degree.getItems().addAll("BTech (Bachelor of Technology)","BE (Bachelor of Engineering)","B.Sc (Bachelor of Science)","Other");
		
		discipline.getItems().addAll("Computer Science","Information Technology","Electronic and Communication","Electrical"
				,"Electronics and Electrical","Other");
		
		pgdegree.getItems().addAll("MTech (Master of Technology)","ME (Master of Engineering)"
				,"MS (Master of Science)","M.Sc (Master of Science)","Other");
		
		pgdiscipline.getItems().addAll("Computer Science","Information Technology","Electronic and Communication","Electrical"
				,"Electronics and Electrical","Other");
		
		xyear.setItems(FXCollections.observableArrayList("2015","2014","2013","2012","2011"
				,"2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"
				,"1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987"
				,"1986","1985","1984","1983","1982","1981","1980"));
		
		xiiyear.setItems(FXCollections.observableArrayList("2015","2014","2013","2012","2011"
				,"2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"
				,"1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987"
				,"1986","1985","1984","1983","1982","1981","1980"));
		
		gradyear.setItems(FXCollections.observableArrayList("2015","2014","2013","2012","2011"
				,"2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"
				,"1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987"
				,"1986","1985","1984","1983","1982","1981","1980"));
		
		pgyear.setItems(FXCollections.observableArrayList("2015","2014","2013","2012","2011"
				,"2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"
				,"1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987"
				,"1986","1985","1984","1983","1982","1981","1980"));
		
		otheryear.setItems(FXCollections.observableArrayList("2015","2014","2013","2012","2011"
				,"2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"
				,"1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987"
				,"1986","1985","1984","1983","1982","1981","1980"));
		
		gateyear.setItems(FXCollections.observableArrayList("2015","2014","2013","2012","2011"
				,"2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"
				,"1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987"
				,"1986","1985","1984","1983","1982","1981","1980"));
		
		gradstate.setItems(FXCollections.observableArrayList("Andaman and Nicobar Islands","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chhattisgarh"
				,"Dadra and Nagar Haveli","Daman and Diu","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Lakshadweep"
				,"Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","New Delhi","Orissa","Punjab"
				,"Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"
				,"Puducherry"));
		
		pgstate.setItems(FXCollections.observableArrayList("Andaman and Nicobar Islands","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chhattisgarh"
				,"Dadra and Nagar Haveli","Daman and Diu","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Lakshadweep"
				,"Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","New Delhi","Orissa","Punjab"
				,"Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"
				,"Puducherry"));
		
		ece_pref1.setItems(FXCollections.observableArrayList("Advanced Signal Processing","Statistical Signal Processing"
				,"Digital VLSI Design","Analog CMOS Design","Digital Communications","Communication Networks"
				,"Linear Systems","Introducton to Robotics","RF Circuit Design","Antenna and Propagation","Embedded Systems"));
		
		ece_pref2.setItems(FXCollections.observableArrayList("Advanced Signal Processing","Statistical Signal Processing"
				,"Digital VLSI Design","Analog CMOS Design","Digital Communications","Communication Networks"
				,"Linear Systems","Introducton to Robotics","RF Circuit Design","Antenna and Propagation","Embedded Systems"));
		
		ece_pref3.setItems(FXCollections.observableArrayList("Advanced Signal Processing","Statistical Signal Processing"
				,"Digital VLSI Design","Analog CMOS Design","Digital Communications","Communication Networks"
				,"Linear Systems","Introducton to Robotics","RF Circuit Design","Antenna and Propagation","Embedded Systems"));
		
		ece_pref4.setItems(FXCollections.observableArrayList("Advanced Signal Processing","Statistical Signal Processing"
				,"Digital VLSI Design","Analog CMOS Design","Digital Communications","Communication Networks"
				,"Linear Systems","Introducton to Robotics","RF Circuit Design","Antenna and Propagation","Embedded Systems"));
		
		xboard.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), xboard.getValue(), xboard.getItems());
		            if (s != null) {
		                xboard.setValue(s);
		            }
		        }
		 });
		
		xiiboard.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), xiiboard.getValue(), xiiboard.getItems());
		            if (s != null) {
		                xiiboard.setValue(s);
		            }
		        }
		 });
		
		degree.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), degree.getValue(), degree.getItems());
		            if (s != null) {
		                degree.setValue(s);
		            }
		        }
		 });
		
		discipline.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), discipline.getValue(), discipline.getItems());
		            if (s != null) {
		                discipline.setValue(s);
		            }
		        }
		 });
		
		pgdegree.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), pgdegree.getValue(), pgdegree.getItems());
		            if (s != null) {
		                pgdegree.setValue(s);
		            }
		        }
		 });
		
		pgdiscipline.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), pgdiscipline.getValue(), pgdiscipline.getItems());
		            if (s != null) {
		                pgdiscipline.setValue(s);
		            }
		        }
		 });
		
		xyear.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), xyear.getValue(), xyear.getItems());
		            if (s != null) {
		                xyear.setValue(s);
		            }
		        }
		 });
		
		xiiyear.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), xiiyear.getValue(), xiiyear.getItems());
		            if (s != null) {
		            	xiiyear.setValue(s);
		            }
		        }
		 });
		
		gradyear.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), gradyear.getValue(), gradyear.getItems());
		            if (s != null) {
		                gradyear.setValue(s);
		            }
		        }
		 });
		
		pgyear.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), pgyear.getValue(), pgyear.getItems());
		            if (s != null) {
		                pgyear.setValue(s);
		            }
		        }
		 });
		
		otheryear.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), otheryear.getValue(), otheryear.getItems());
		            if (s != null) {
		                otheryear.setValue(s);
		            }
		        }
		 });
		
		gateyear.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), gateyear.getValue(), gateyear.getItems());
		            if (s != null) {
		                gateyear.setValue(s);
		            }
		        }
		 });
		
		gradstate.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), gradstate.getValue(), gradstate.getItems());
		            if (s != null) {
		                gradstate.setValue(s);
		            }
		        }
		 });
		
		pgstate.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), pgstate.getValue(), pgstate.getItems());
		            if (s != null) {
		                pgstate.setValue(s);
		            }
		        }
		 });
		
		ece_pref1.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), ece_pref1.getValue(), ece_pref1.getItems());
		            if (s != null) {
		                ece_pref1.setValue(s);
		            }
		        }
		 });
		
		ece_pref2.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), ece_pref2.getValue(), ece_pref2.getItems());
		            if (s != null) {
		                ece_pref2.setValue(s);
		            }
		        }
		 });
		
		ece_pref3.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), ece_pref3.getValue(), ece_pref3.getItems());
		            if (s != null) {
		                ece_pref3.setValue(s);
		            }
		        }
		 });
		
		ece_pref4.setOnKeyReleased(new EventHandler<KeyEvent>()
		 {
		        @Override
		        public void handle(KeyEvent event) 
		        {
		            String s = jumpTo(event.getText(), ece_pref4.getValue(), ece_pref4.getItems());
		            if (s != null) {
		                ece_pref4.setValue(s);
		            }
		        }
		 });
		
		check1.selectedProperty().bindBidirectional(title1.expandedProperty());
		title1.setExpanded(false);
	    title1.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
	    title1.setGraphic(check1);
	    title1.lookup(".title").setStyle("-fx-padding: 0 0 4 -10;" + "-fx-background-color: null;");
	    
	    check2.selectedProperty().bindBidirectional(title2.expandedProperty());
		title2.setExpanded(false);
	    title2.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
	    title2.setGraphic(check2);
	    title2.lookup(".title").setStyle("-fx-padding: 0 0 4 -10;" + "-fx-background-color: null;");
	    
	    check3.selectedProperty().bindBidirectional(title3.expandedProperty());
		title3.setExpanded(false);
	    title3.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
	    title3.setGraphic(check3);
	    title3.lookup(".title").setStyle("-fx-padding: 0 0 4 -10;" + "-fx-background-color: null;");
	    
	    check4.selectedProperty().bindBidirectional(title4.expandedProperty());
		title4.setExpanded(false);
	    title4.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
	    title4.setGraphic(check4);
	    title4.lookup(".title").setStyle("-fx-padding: 0 0 4 -10;" + "-fx-background-color: null;");
	    
	}
	
	/*
	 * Implementation for Tab3
	 */
	
	public void tab5selected(Event event)
	{
		if(tabflag1 == 1 && tabflag2 == 1)
		{
			tabflag1 = 0;
			tabflag2 = 0;
			submit.setDisable(false);
		}
		else
		{
			submit.setDisable(true);
		}
	}
	
	/*
	 * Personal Information Tab
	 */
	
	public void save1onAction(ActionEvent event) throws IOException
	{
		
		int flag0 = 0, flag1 = 0, flag2 = 0, flag3 = 0, flag4 = 0, flag5 = 0, flag6 = 0, flag7 = 0, flag8 = 0, flag9 = 0, flag10 = 0, flag11 = 0, flag12 = 0, flag13 = 0, flag14 = 0;
		String stream = null, gender = null, category = null, pd = null, war = null; 
		
		prompt1.setVisible(false);
		wrong0.setVisible(false);
		wrong1.setVisible(false);
		wrong2.setVisible(false);
		wrong3.setVisible(false);
		wrong4.setVisible(false);
		wrong5.setVisible(false);
		wrong6.setVisible(false);
		wrong7.setVisible(false);
		wrong8.setVisible(false);
		wrong9.setVisible(false);
		wrong11.setVisible(false);
		wrong11.setVisible(false);
		wrong12.setVisible(false);
		wrong13.setVisible(false);
		wrong14.setVisible(false);
		
		if(email.getText().compareTo("") != 0)
		{
			flag1 = 1;
		}
		else
		{
			wrong1.setVisible(true);
		}
		
		if(name.getText().compareTo("") != 0 && name.getText().matches("[a-z,A-Z,' ']+"))
		{
			flag2 = 1;
		}
		else
		{
			wrong2.setVisible(true);
		}
		
		if(c_addr1.getText().compareTo("") != 0)
		{
			flag3 = 1;
		}
		else
		{
			wrong3.setVisible(true);
		}
		
		if(mobile.getText().length() != 10)
		{
			mobile.setText("");
			mobile.setPromptText("Invalid Number: Not a 10 digit mobile number");
			wrong4.setVisible(true);
		}
		else if(mobile.getText().compareTo("") != 0)
		{
			if(mobile.getText().matches("[0-9]+"))
			{
				flag4 = 1;
			}
			else
			{
				mobile.setText("");
				mobile.setPromptText("Invalid Number: Letter(s) not allowed");
				wrong4.setVisible(true);
			}
		}
		else
		{
			wrong4.setVisible(true);
		}
		
		if(stream_cs.isSelected() == true)
		{
			stream = "Computer Science";
			flag5 = 1;
		}
		else if(stream_ece.isSelected() == true)
		{
			stream = "Electronics and Communication";
			flag5 = 1;
		}
		else if(stream_cb.isSelected() == true)
		{
			stream = "Computational Biology";
			flag5 = 1;
		}
		else
		{
			wrong5.setVisible(true);
		}
		
		if(pref1.getValue() != null)
		{
			flag6 = 1;
		}
		else
		{
			wrong6.setVisible(true);
		}
		
		if(male.isSelected() == true)
		{
			gender = "male";
			flag7 = 1;
		}
		else if(female.isSelected() == true)
		{
			gender = "female";
			flag7 = 1;
		}
		else
		{
			wrong7.setVisible(true);
		}
		
		if(general.isSelected() == true)
		{
			category = "general";
			flag8 = 1;
		}
		else if(sc.isSelected() == true)
		{
			category = "SC";
			flag8 = 1;
		}
		else if(st.isSelected() == true)
		{
			category = "ST";
			flag8 = 1;
		}
		else if(obc.isSelected() == true)
		{
			category = "OBC";
			flag8 = 1;
		}
		else
		{
			wrong8.setVisible(true);
		}
		
		if(pd_yes.isSelected() == true)
		{
			pd = "Y";
			flag9 = 1;
		}
		else if(pd_no.isSelected() == true)
		{
			pd = "N";
			flag9 = 1;
		}
		else
		{
			wrong9.setVisible(true);
		}
		
		if(dob.getValue() != null)
		{
			LocalDate entered = dob.getValue();
			Calendar c =  Calendar.getInstance();
			c.set(entered.getYear(), entered.getMonthValue() - 1, entered.getDayOfMonth());
			Date date = c.getTime();
			Date curr = new Date();
			
			if(date.before(curr))
			{
				flag0 = 1;
			}
			else
			{
				wrong0.setVisible(true);
			}
			
		}
		else
		{
			wrong0.setVisible(true);
		}
		
		if(war_yes.isSelected() == true)
		{
			war = "Y";
			flag10 = 1;
		}
		else if(war_no.isSelected() == true)
		{
			war = "N";
			flag10 = 1;
		}
		else
		{
			wrong10.setVisible(true);
		}
		
		if(father_name.getText().compareTo("") != 0 && father_name.getText().matches("[a-z,A-Z,' ']+"))
		{
			flag11 = 1;
		}
		else
		{
			wrong11.setVisible(true);
		}
		
		if(nationality.getValue() != null)
		{
			flag12 = 1;
		}
		else
		{
			wrong12.setVisible(true);
		}
		
		if(p_addr1.getText().compareTo("") != 0)
		{
			flag13 = 1;
		}
		else
		{
			wrong13.setVisible(true);
		}
		
		if(pin.getText().compareTo("") != 0 && pin.getText().matches("[0-9]+"))
		{
			flag14 = 1;
		}
		else
		{
			wrong14.setVisible(true);
		}
		
		if(flag0 == 1 && flag1 == 1 && flag2 == 1 && flag3 == 1 && flag4 == 1 && flag5 == 1 && flag6 == 1 && flag7 == 1
				&& flag8 == 1 && flag9 == 1 && flag10 == 1 && flag11 == 1 && flag12 == 1 && flag13 == 1 && flag14 == 1)
		{
			writer = new BufferedWriter(new FileWriter("temp.txt"));
			writer1 = new BufferedWriter(new FileWriter("temp1.txt"));
			
			writer.write(email.getText() + "\n");
			writer.write(name.getText() + "\n");
			writer.write(c_addr1.getText() + "\n");
			writer.write(c_addr2.getText() + "\n");
			writer.write(c_addr3.getText() + "\n");
			writer.write(mobile.getText() + "\n");
			writer.write(stream  + "\n");
			writer.write(pref1.getValue() + "\n");
			writer.write(pref2.getValue() + "\n");
			writer.write(pref3.getValue() + "\n");
			writer.write(gender + "\n");
			writer.write(category + "\n");
			writer.write(pd + "\n");
			localDate = dob.getValue();
			writer.write(localDate.getMonthValue() + "/" + localDate.getDayOfMonth() + "/" + localDate.getYear() + "\n");
			writer.write(war + "\n");
			writer.write(father_name.getText() + "\n");
			writer.write(nationality.getValue() + "\n");
			writer.write(p_addr1.getText() + "\n");
			writer.write(p_addr2.getText() + "\n");
			writer.write(p_addr3.getText() + "\n");
			writer.write(pin.getText() + "\n");
			
			writer1.write("Personal Information\n\n");
			writer1.write("Email: " + email.getText() + "\n");
			writer1.write("Name: " + name.getText() + "\n");
			writer1.write("Correspondence Address: " + c_addr1.getText() + ", " + c_addr2.getText() + ", " + c_addr3.getText() + "\n");
			writer1.write("Mobile: " + mobile.getText() + "\n");
			writer1.write("Stream: " + stream  + "\n");
			writer1.write("Preference1: " + pref1.getValue() + "\n");
			writer1.write("Preference2: " + pref2.getValue() + "\n");
			writer1.write("Preference3: " + pref3.getValue() + "\n");
			writer1.write("Gender: " + gender + "\n");
			writer1.write("Category: " + category + "\n");
			writer1.write("Physically Disabled: " + pd + "\n");
			writer1.write("Date of Birth(MM/DD/YYYY): " + localDate.getMonthValue() + "/" + localDate.getDayOfMonth() + "/" + localDate.getYear() + "\n");
			writer1.write("Children/War Widows of Defence Personnel killed/Disabled in action: " + war + "\n");
			writer1.write("Father name: " + father_name.getText() + "\n");
			writer1.write("Nationality: " + nationality.getValue() + "\n");
			writer1.write("Permanent Address: " + p_addr1.getText() + ", " + p_addr2.getText() + ", " + p_addr3.getText() + "\n");
			writer1.write("Pincode: " + pin.getText() + "\n");
			
			prompt1.setVisible(true);
			prompt1.setText("Data saved successfully");
			prompt1.setFill(Color.GREEN);
			tabflag1 = 1;
			writer.close();
			writer1.close();
			
		}
		else
		{
			prompt1.setVisible(true);
			prompt1.setText("One or more error(s) exist in the page");
			prompt1.setFill(Color.FIREBRICK);
		}
	}
	
	/*
	 * Education Information Tab
	 */
	
	public void save2onAction(ActionEvent event) throws IOException
	{
		int flag1 = 0,flag2 = 0,flag3 = 0,flag4 = 0,flag5 = 0,flag6 = 0,flag7 = 0,flag8 = 0,flag9 = 0,flag10 = 0,flag11 = 0
		,flag12 = 0,flag13 = 0,flag14 = 0,flag15 = 0,flag16 = 0,flag17 = 0,flag18 = 0,flag19 = 0,flag20 = 0;
		
		double mark1 = 0, mark2 = 0, mark3 = 0;
		
		prompt2.setVisible(false);
		wrong15.setVisible(false);
		wrong16.setVisible(false);
		wrong17.setVisible(false);
		wrong18.setVisible(false);
		wrong19.setVisible(false);
		wrong20.setVisible(false);
		wrong21.setVisible(false);
		wrong22.setVisible(false);
		wrong23.setVisible(false);
		wrong24.setVisible(false);
		wrong25.setVisible(false);
		wrong26.setVisible(false);
		wrong27.setVisible(false);
		wrong28.setVisible(false);
		wrong29.setVisible(false);
		wrong30.setVisible(false);
		wrong31.setVisible(false);
		wrong32.setVisible(false);
		wrong33.setVisible(false);
		wrong34.setVisible(false);
		wrong35.setVisible(false);
		wrong36.setVisible(false);
		wrong37.setVisible(false);
		wrong38.setVisible(false);
		wrong39.setVisible(false);
		wrong40.setVisible(false);
		wrong41.setVisible(false);
		wrong42.setVisible(false);
		wrong43.setVisible(false);
		wrong44.setVisible(false);
		wrong45.setVisible(false);
		wrong46.setVisible(false);
		wrong47.setVisible(false);
		wrong48.setVisible(false);
		wrong49.setVisible(false);
		wrong50.setVisible(false);
		success1.setVisible(false);
		success2.setVisible(false);
		nofile1.setText("No File Chosen");
		nofile1.setFill(Color.BLACK);
		nofile2.setText("No File Chosen");
		nofile2.setFill(Color.BLACK);
		
		if(xboard.getValue() != null)
		{
			flag1 = 1;
		}
		else
		{
			wrong15.setVisible(true);
		}
		
		if(xcgpa.isSelected() == true)
		{
			double mark;
			
			if(xmark1.getText().compareTo("") != 0 && xmark1.getText().matches("[0-9,.]+"))
			{
				
				if(outof1.getValue() == null)
				{
					mark = Double.valueOf(xmark1.getText());
					if(mark <= 4 && mark >= 0)
					{
						outof1.setValue("4");
						mark1 = Double.valueOf(xmark1.getText()) * 23.75;
						flag2 = 1;
					}
					else
					{
						wrong16.setVisible(true);
					}
				}
				else if(outof1.getValue().compareTo("4") == 0)
				{
					mark = Double.valueOf(xmark1.getText());
					if(mark <= 4 && mark >= 0)
					{
						mark1 = Double.valueOf(xmark1.getText()) * 23.75;
						flag2 = 1;
					}
					else
					{
						wrong16.setVisible(true);
					}
				}
				else if(outof1.getValue().compareTo("10") == 0)
				{
					mark = Double.valueOf(xmark1.getText());
					if(mark <= 10 && mark >= 0)
					{
						mark1 = Double.valueOf(xmark1.getText()) * 9.5;
						flag2 = 1;
					}
					else
					{
						wrong16.setVisible(true);
					}
				}
				else
				{
					wrong16.setVisible(true);
				}
				
			}
			else
			{
				wrong16.setVisible(true);
			}
		}
		else if(xpercentage.isSelected() == true)
		{
			if(xmark2.getText().compareTo("") != 0 && xmark2.getText().matches("[0-9,.]+"))
			{
				double mark = Double.valueOf(xmark2.getText());
				if(mark <= 100 && mark >= 0)
				{
					mark1 = Double.valueOf(xmark2.getText());
					flag2 = 1;
				}
				else
				{
					wrong16.setVisible(true);
				}
			}
			else
			{
				wrong16.setVisible(true);
			}
		}
		else
		{
			wrong16.setVisible(true);
		}
		
		if(xyear.getValue() != null)
		{
			flag3 = 1;
		}
		else
		{
			wrong17.setVisible(true);
		}
		
		if(xiiboard.getValue() != null)
		{
			flag4 = 1;
		}
		else
		{
			wrong18.setVisible(true);
		}
		
		if(xiimark.getText().compareTo("") != 0)
		{
			double mark = Double.valueOf(xiimark.getText());
			if(mark <= 100 && mark >= 0)
			{
				flag5 = 1;
			}
			else
			{
				wrong19.setVisible(true);
			}
			
		}
		else
		{
			wrong19.setVisible(true);
		}
		
		if(xiiyear.getValue() != null)
		{
			int year1 = Integer.valueOf(xyear.getValue());
			int year2 = Integer.valueOf(xiiyear.getValue());
			if(year2 - year1 >= 2)
			{
				flag6 = 1;
			}
			else
			{
				wrong20.setVisible(true);
			}
		}
		else
		{
			wrong20.setVisible(true);
		}
		
		if(flag1 == 1 && flag2 == 1 && flag3 == 1 && flag4 == 1 && flag5 == 1 && flag6 == 1)
		{
			flag7 = 1;
		}
		
		if(degree.getValue() != null)
		{
			flag8 = 1;
		}
		else
		{
			wrong21.setVisible(true);
		}
		
		if(discipline.getValue() != null)
		{
			flag9 = 1;
		}
		else
		{
			wrong22.setVisible(true);
		}
		
		if(collegename.getText().compareTo("") != 0)
		{
			flag10 = 1;
		}
		else
		{
			wrong23.setVisible(true);
		}
		
		if(universityname.getText().compareTo("") != 0)
		{
			flag11 = 1;
		}
		else
		{
			wrong24.setVisible(true);
		}
		
		if(collegecity.getText().compareTo("") != 0)
		{
			flag12 = 1;
		}
		else
		{
			wrong25.setVisible(true);
		}
		
		if(gradstate.getValue() != null)
		{
			flag13 = 1;
		}
		else
		{
			wrong26.setVisible(true);
		}
		
		if(gradyear.getValue() != null)
		{
			int year1 = Integer.valueOf(xiiyear.getValue());
			int year2 = Integer.valueOf(gradyear.getValue());
			if(year2 - year1 >= 3)
			{
				flag14 = 1;
			}
			else
			{
				wrong27.setVisible(true);
			}
		}
		else
		{
			wrong27.setVisible(true);
		}
		
		if(gradcgpa.isSelected() == true)
		{
			double mark;
			
			if(gradmark1.getText().compareTo("") != 0 && gradmark1.getText().matches("[0-9,.]+"))
			{
				if(outof2.getValue() == null)
				{
					mark = Double.valueOf(gradmark1.getText());
					if(mark <= 4 && mark >= 0)
					{
						outof2.setValue("4");
						mark2 = Double.valueOf(gradmark1.getText()) * 23.75;
						flag15 = 1;
					}
					else
					{
						wrong28.setVisible(true);
					}
				}
				else if(outof2.getValue().compareTo("4") == 0)
				{
					mark = Double.valueOf(gradmark1.getText());
					if(mark <= 4 && mark>= 0)
					{
						mark2 = Double.valueOf(gradmark1.getText()) * 23.75;
						flag15 = 1;
					}
					else
					{
						wrong28.setVisible(true);
					}
				}
				else if(outof2.getValue().compareTo("10") == 0)
				{
					mark = Double.valueOf(gradmark1.getText());
					if(mark <= 10 && mark >= 0)
					{
						mark2 = Double.valueOf(gradmark1.getText()) * 9.5;
						flag15 = 1;
					}
					else
					{
						wrong28.setVisible(true);
					}
				}
				else
				{
					wrong28.setVisible(true);
				}
				
			}
			else
			{
				wrong28.setVisible(true);;
			}
		}
		else if(gradpercentage.isSelected() == true)
		{
			if(gradmark2.getText().compareTo("") != 0 && gradmark2.getText().matches("[0-9,.]+"))
			{
				double mark = Double.valueOf(gradmark2.getText());
				if(mark <= 100 && mark >= 0)
				{
					mark1 = Double.valueOf(gradmark2.getText());
					flag15 = 1;
				}
				else
				{
					wrong28.setVisible(true);
				}
			}
			else
			{
				wrong28.setVisible(true);
			}
		}
		else
		{
			wrong28.setVisible(true);
		}
		
		if(flag8 == 1 && flag9 == 1 && flag10 == 1 && flag11 == 1 && flag12 == 1 && flag13 == 1 && flag14 == 1 && flag15 == 1)
		{
			flag16 = 1;
		}
		
		if(check1.isSelected() == true)
		{
			int xflag = 0, yflag = 0, zflag = 0;
			if(ece_pref1.getValue() != null)
			{
				xflag = 1;
			}
			else
			{
				wrong29.setVisible(true);
			}
			if(ece_pref2.getValue() != null && ece_pref2.getValue().compareTo(ece_pref1.getValue()) != 0)
			{
				yflag = 1;
			}
			else
			{
				wrong30.setVisible(true);
			}
			if(ece_pref3.getValue() != null &&  ece_pref3.getValue().compareTo(ece_pref2.getValue()) != 0
					&&  ece_pref3.getValue().compareTo(ece_pref1.getValue()) != 0
					&&  ece_pref2.getValue().compareTo(ece_pref1.getValue()) != 0)
			{
				zflag = 1;
			}
			else
			{
				wrong31.setVisible(true);
			}
			
			if(xflag == 1 && yflag == 1 && zflag == 1)
			{
				flag17 = 1;
			}
		}
		else if(check1.isSelected() == false)
		{
			flag17 = 1;
		}
		
		if(check2.isSelected() == true)
		{
			int flaga = 0, flagb = 0, flagc = 0, flagd = 0, flage = 0, flagf = 0, flagg = 0, flagh = 0; 
			
			if(pgcollege.getText().compareTo("") != 0)
			{
				flaga = 1;
			}
			else
			{
				wrong32.setVisible(true);
			}
			
			if(pgcity.getText().compareTo("") != 0)
			{
				flagb = 1;
			}
			else
			{
				wrong33.setVisible(true);
			}
			
			if(pgstate.getValue() != null)
			{
				flagc = 1;
			}
			else
			{
				wrong34.setVisible(true);
			}
			
			if(pgdiscipline.getValue() != null)
			{
				flagd = 1;
			}
			else
			{
				wrong35.setVisible(true);
			}
			
			if(pgdegree.getValue() != null)
			{
				flage = 1;
			}
			else
			{
				wrong36.setVisible(true);
			}
			
			if(pgthesis.getText().compareTo("") != 0)
			{
				flagf = 1;
			}
			else
			{
				wrong37.setVisible(true);
			}
			
			if(pgyear.getValue() != null)
			{
				int year1 = Integer.valueOf(gradyear.getValue());
				int year2 = Integer.valueOf(pgyear.getValue());
				if(year2 > year1)
				{
					flagg = 1;
				}
				else
				{
					wrong38.setVisible(true);
				}
			}
			else
			{
				wrong38.setVisible(true);
			}
			
			if(pgcgpa.isSelected() == true)
			{
				double mark;
				
				if(pgmark1.getText().compareTo("") != 0 && pgmark1.getText().matches("[0-9,.]+"))
				{
					if(outof3.getValue() == null)
					{
						mark = Double.valueOf(pgmark1.getText());
						if(mark <= 4 && mark >= 0)
						{
							outof3.setValue("4");
							mark3 = Double.valueOf(pgmark1.getText()) * 23.75;
							flagh = 1;
						}
						else
						{
							wrong39.setVisible(true);
						}
					}
					else if(outof3.getValue().compareTo("4") == 0)
					{
						mark = Double.valueOf(pgmark1.getText());
						if(mark <= 4 && mark >= 0)
						{
							mark3 = Double.valueOf(pgmark1.getText()) * 23.75;
							flagh = 1;
						}
						else
						{
							wrong39.setVisible(true);
						}
					}
					else if(outof3.getValue().compareTo("10") == 0)
					{
						mark = Double.valueOf(pgmark1.getText());
						if(mark <= 10 && mark >= 0)
						{
							mark3 = Double.valueOf(pgmark1.getText()) * 9.5;
							flagh = 1;
						}
						else
						{
							wrong39.setVisible(true);
						}
					}
					else
					{
						wrong39.setVisible(true);
					}
					
				}
				else
				{
					wrong39.setVisible(true);;
				}
			}
			else if(pgpercentage.isSelected() == true)
			{
				if(pgmark2.getText().compareTo("") != 0 && pgmark2.getText().matches("[0-9,.]+"))
				{
					double mark = Double.valueOf(pgmark2.getText());
					if(mark <= 100 && mark >= 0)
					{
						mark1 = Double.valueOf(pgmark2.getText());
						flagh = 1;
					}
					else
					{
						wrong39.setVisible(true);
					}
				}
				else
				{
					wrong39.setVisible(true);
				}
			}
			else
			{
				wrong39.setVisible(true);
			}
			
			if(flaga == 1 && flagb == 1 && flagc == 1 && flagd == 1 && flage == 1 && flagf == 1 && flagg == 1 && flagh == 1)
			{
				flag18 = 1;
			}
		}
		else if(check2.isSelected() == false)
		{
			flag18 = 1;
		}
		
		if(check3.isSelected() == true)
		{
			int flaga = 0, flagb = 0, flagc = 0, flagd = 0;
			
			if(otherexam.getText().compareTo("") != 0)
			{
				flaga = 1;
			}
			else
			{
				wrong40.setVisible(true);
			}
				
			
			if(othersubject.getText().compareTo("") != 0)
			{
				flagb = 1;
			}
			else
			{
				wrong41.setVisible(true);
			}
			
			if(otherscore.getText().compareTo("") != 0 && otherscore.getText().matches("[0-9,.]+"))
			{
				flagc = 1;
			}
			else
			{
				wrong43.setVisible(true);
			}
			
			if(otheryear.getValue() != null)
			{
				flagd = 1;
			}
			else
			{
				wrong42.setVisible(true);
			}
			
			if(flaga == 1 && flagb == 1 && flagc == 1 && flagd == 1)
			{
				flag19 = 1;
			}
		}
		else if(check3.isSelected() == false)
		{
			flag19 = 1;
		}
		
		if(check4.isSelected() == true)
		{
			int flaga = 0, flagb = 0, flagc = 0, flagd = 0;
			
			if(gatearea.getText().compareTo("") != 0)
			{
				flaga = 1;
			}
			else
			{
				wrong44.setVisible(true);
			}
			
			if(gateyear.getValue() != null)
			{
				int year1 = Integer.valueOf(gateyear.getValue());
				if(check2.isSelected() == true)
				{
					int year2 = Integer.valueOf(pgyear.getValue());
					if(year1 >= year2)
					{
						flagb = 1;
					}
					else
					{
						wrong45.setVisible(true);
					}
				}
				else if(gradyear.getValue() != null)
				{
					int year2 = Integer.valueOf(gradyear.getValue());
					if(year1 > year2)
					{
						flagb = 1;
					}
					else
					{
						wrong45.setVisible(true);
					}
				}
				else
				{
					wrong45.setVisible(true);
				}
			}
			else
			{
				wrong45.setVisible(true);
			}
			
			if(gatemark.getText().compareTo("") != 0 && gatemark.getText().matches("[0-9,.,-]+"))
			{
				double mark = Double.valueOf(gatemark.getText());
				if(mark <= 100)
				{
					flagc = 1;
				}
				else
				{
					wrong46.setVisible(true);
				}
			}
			else
			{
				wrong46.setVisible(true);
			}
			
			if(gatescore.getText().compareTo("") != 0 && gatescore.getText().matches("[0-9,.]+"))
			{
				Double mark = Double.valueOf(gatescore.getText());
				if(mark >= 0 && mark <= 100)
				{
					flagd = 1;
				}
				else
				{
					wrong47.setVisible(true);
				}
			}
			else
			{
				wrong47.setVisible(true);
			}


			if(flaga == 1 && flagb == 1 && flagc == 1 && flagd == 1)
			{
				flag20 = 1;
			}
		}
		else if(check4.isSelected() == false)
		{
			flag20 = 1;
		}
		
		if(flag7 == 1 && flag16 == 1 && flag17 == 1 && flag18 == 1 && flag19 == 1 && flag20 == 1)
		{
			writer = new BufferedWriter(new FileWriter("temp.txt",true));
			writer1 = new BufferedWriter(new FileWriter("temp1.txt",true));
			
			writer.write(xboard.getValue() + "\n");
			writer.write(mark1 + "\n");
			writer.write(xyear.getValue() + "\n");
			writer.write(xiiboard.getValue() + "\n");
			writer.write(xiimark.getText() + "\n");
			writer.write(xiiyear.getValue() + "\n");
			writer.write(degree.getValue()+ "\n");
			writer.write(discipline.getValue() + "\n");
			writer.write(collegename.getText() + "\n");
			writer.write(universityname.getText() + "\n");
			writer.write(collegecity.getText() + "\n");
			writer.write(gradstate.getValue() + "\n");
			writer.write(gradyear.getValue() + "\n");
			writer.write(mark2 + "\n");
			
			if(check1.isSelected() == true)
			{
				writer.write(ece_pref1.getValue() + "\n");
				writer.write(ece_pref2.getValue() + "\n");
				writer.write(ece_pref3.getValue() + "\n");
				writer.write(ece_pref4.getValue() + "\n");
			}
			else
			{
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
			}
			
			if(check2.isSelected() == true)
			{
				writer.write(pgcollege.getText() + "\n");
				writer.write(pgcity.getText() + "\n");
				writer.write(pgstate.getValue() + "\n");
				writer.write(pgdiscipline.getValue() + "\n");
				writer.write(pgdegree.getValue() + "\n");
				writer.write(pgthesis.getText() + "\n");
				writer.write(pgyear.getValue() + "\n");
				writer.write(mark3 + "\n");
			}
			else
			{
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
			}
			
			if(check3.isSelected() == true)
			{
				writer.write(otherexam.getText() + "\n");
				writer.write(othersubject.getText() + "\n");
				writer.write(otheryear.getValue() + "\n");
				writer.write(otherscore.getText() + "\n");
				writer.write(otherrank.getText() + "\n");
			}
			else
			{
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
			}
			
			if(check4.isSelected() == true)
			{
				writer.write(gatearea.getText() + "\n");
				writer.write(gateyear.getValue() + "\n");
				writer.write(gatemark.getText() + "\n");
				writer.write(gatescore.getText() + "\n");
				writer.write(gaterank.getText() + "\n");
			}	
			else
			{
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
				writer.write("-1"  + "\n");
			}
			
			writer.write(achievement.getText() + "\n");
			
			writer1.write("\nSchooling Information\n\n");
			writer1.write("Xth Board: " + xboard.getValue() + "\n");
			writer1.write("Xth Marks: " + mark1 + "\n");
			writer1.write("Xth Passsing Year: " + xyear.getValue() + "\n");
			writer1.write("XIIth Board: " + xiiboard.getValue() + "\n");
			writer1.write("XIIth Marks: " + xiimark.getText() + "\n");
			writer1.write("XIIth Passing Year: " + xiiyear.getValue() + "\n");
			writer1.write("\nGraduation Information\n\n");
			writer1.write("Graduation Degree: " +  degree.getValue()+ "\n");
			writer1.write("Graduation Discipline: " + discipline.getValue() + "\n");
			writer1.write("College Name: " + collegename.getText() + "\n");
			writer1.write("University Name: " + universityname.getText() + "\n");
			writer1.write("College City: " + collegecity.getText() + "\n");
			writer1.write("College State: " + gradstate.getValue() + "\n");
			writer1.write("Graduation Passing Year: " + gradyear.getValue() + "\n");
			writer1.write("Graduation Marks: " + mark2 + "\n");
			
			if(check1.isSelected() == true)
			{
				writer1.write("\nECE Preferences\n\n");
				writer1.write("Preference1: " + ece_pref1.getValue() + "\n");
				writer1.write("Preference2: " + ece_pref2.getValue() + "\n");
				writer1.write("Preference3: " + ece_pref3.getValue() + "\n");
				writer1.write("Preference4: " + ece_pref4.getValue() + "\n");
			}
			
			if(check2.isSelected() == true)
			{
				writer1.write("\nPost Graduation Information\n\n");
				writer1.write("College Name: " + pgcollege.getText() + "\n");
				writer1.write("City: " + pgcity.getText() + "\n");
				writer1.write("State: " + pgstate.getValue() + "\n");
				writer1.write("Discipline: " + pgdiscipline.getValue() + "\n");
				writer1.write("Degree: " + pgdegree.getValue() + "\n");
				writer1.write("Thesis: " + pgthesis.getText() + "\n");
				writer1.write("Year of Passing: " + pgyear.getValue() + "\n");
				writer1.write("Marks: " + mark3 + "\n");
			}
			
			
			if(check3.isSelected() == true)
			{
				writer1.write("\nOther Information\n\n");
				writer1.write("Exam: " + otherexam.getText() + "\n");
				writer1.write("Subject: " + othersubject.getText() + "\n");
				writer1.write("Year: " + otheryear.getValue() + "\n");
				writer1.write("Score: " + otherscore.getText() + "\n");
				writer1.write("Rank: " + otherrank.getText() + "\n");
			}
			
			if(check4.isSelected() == true)
			{
				writer1.write("\nGate Information\n\n");
				writer1.write("Area: " + gatearea.getText() + "\n");
				writer1.write("Year: " + gateyear.getValue() + "\n");
				writer1.write("Marks: " + gatemark.getText() + "\n");
				writer1.write("Score: " + gatescore.getText() + "\n");
				writer1.write("Rank: " + gaterank.getText() + "\n");
			}	
			
			writer1.write("Achievement(s): " + achievement.getText() + "\n");
			
			prompt2.setVisible(true);
			prompt2.setText("Data saved successfully");
			prompt2.setFill(Color.GREEN);
			tabflag2 = 1;
			writer.close();
			writer1.close();
		}
		else
		{
			prompt2.setVisible(true);
			prompt2.setText("One or more error(s) exist in the page");
			prompt2.setFill(Color.FIREBRICK);
		}
		
	}
	
	/*
	 * ActionListener's for tab2 radiobuttons
	 */
	
	public void xcgpaonAction(ActionEvent event)
	{
		xmark2.setText("");
	}
	
	public void xpercentageonAction(ActionEvent event)
	{
		xmark1.setText("");
	}
	
	public void gradcgpaonAction(ActionEvent event)
	{
		gradmark2.setText("");
	}
	
	public void gradpercentageonAction(ActionEvent event)
	{
		gradmark1.setText("");
	}
	
	public void pgcgpaonAction(ActionEvent event)
	{
		pgmark2.setText("");
	}
	
	public void pgpercentageonAction(ActionEvent event)
	{
		pgmark1.setText("");
	}
	
	/*
	 * ActionListener for Upload Buttons
	 */
	
	public void uploadCV(ActionEvent event) throws IOException
	{
		File dir1 = new File("./src/CV");
		if(dir1.exists() == false)
		{
			dir1.mkdir();
		}
		
		File dir2 = new File("./src/Applicant");
		if(dir2.exists() == false)
		{
			dir2.mkdir();
			writer = new BufferedWriter(new FileWriter("./src/Applicant/eno.txt"));
			writer.write("0");
			writer.close();
		}
		
		FileChooser cv = new FileChooser();
		cv.setTitle("CV/Resume");
		File file = cv.showOpenDialog(new Stage());
		double megabytes = file.length()/(1024 * 1024);
		
		if(file != null && megabytes <= 10)
		{
			nofile1.setText(file.getName());
			nofile1.setFill(Color.ROYALBLUE);
			success1.setVisible(true);
			reader = new BufferedReader(new FileReader("./src/Applicant/eno.txt"));
			String str = reader.readLine();
			int enrollment_no = Integer.valueOf(str) + 1;
			String file_name = "./src/CV/PhD2015" + String.valueOf(enrollment_no) + ".pdf"; 
			reader.close();
		
			Files.copy(file.toPath(), new File(file_name).toPath(),StandardCopyOption.REPLACE_EXISTING);
		}
		else
		{
			nofile1.setText("File size exceeded or invalid file");
			nofile1.setFill(Color.FIREBRICK);
		}
	}
	
	public void uploadPurpose(ActionEvent event) throws IOException
	{
		File dir1 = new File("./src/SOP");
		if(dir1.exists() == false)
		{
			dir1.mkdir();
		}
		
		File dir2 = new File("./src/Applicant");
		if(dir2.exists() == false)
		{
			dir2.mkdir();
			writer = new BufferedWriter(new FileWriter("./src/Applicant/eno.txt"));
			writer.write("0");
			writer.close();
		}
		
		FileChooser sop = new FileChooser();
		sop.setTitle("Statement of Purpose");
		File file = sop.showOpenDialog(new Stage());
		double megabytes = file.length()/(1024 * 1024);
		
		if(file != null && megabytes <= 10)
		{
			nofile2.setText(file.getName());
			nofile2.setFill(Color.ROYALBLUE);
			success2.setVisible(true);
			reader = new BufferedReader(new FileReader("./src/Applicant/eno.txt"));
			String str = reader.readLine();
			int enrollment_no = Integer.valueOf(str) + 1;
			String file_name = "./src/SOP/PhD2015" + String.valueOf(enrollment_no) + ".pdf"; 
			reader.close();
			
			Files.copy(file.toPath(), new File(file_name).toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
		else
		{
			nofile2.setText("File size exceeded or invalid file");
			nofile2.setFill(Color.FIREBRICK);
		}
	}
	
	/*
	 * ActionListener for Submit Button
	 */
	
	public void submitonAction(ActionEvent event) throws IOException, DocumentException
	{
		File dir = new File("./src/Applicant");
		if(dir.exists() == false)
		{
			dir.mkdir();
			writer = new BufferedWriter(new FileWriter("./src/Applicant/eno.txt"));
			writer.write("0");
			writer.close();
		}
		
		reader = new BufferedReader(new FileReader("./src/Applicant/eno.txt"));
		
		String str = reader.readLine();
		int enrollment_no = Integer.valueOf(str);
		enrollment_no++;
		writer = new BufferedWriter(new FileWriter("./src/Applicant/eno.txt"));
		writer.write(String.valueOf(enrollment_no));
		reader.close();
		writer.close();
		
		writer = new BufferedWriter(new FileWriter("temp.txt",true));
		String date = new SimpleDateFormat("MM-dd-yyyy hh:mm").format(new Date());
		writer.write(date);
		writer.close();
		
		String file_name = "./src/Applicant/PhD2015" + String.valueOf(enrollment_no) + ".txt"; 
		String file_name1 = "./src/Applicant/PhD2015" + String.valueOf(enrollment_no) + ".pdf"; 
		
		File oldfile = new File("temp.txt");
		reader = new BufferedReader(new FileReader("temp1.txt"));
		
		Document pdfDoc = new Document();    
        PdfWriter writer = PdfWriter.getInstance(pdfDoc,new FileOutputStream(file_name1));  
        pdfDoc.open();  
        pdfDoc.setMarginMirroring(true);  
        pdfDoc.setMargins(36, 72, 108,180);  
        pdfDoc.topMargin();  
        Font myfont = new Font();  
        Font bold_font = new Font();  
        bold_font.setStyle(Font.BOLD);  
        bold_font.setSize(10);  
        myfont.setStyle(Font.NORMAL);  
        myfont.setSize(10);  
        pdfDoc.add(new Paragraph("\n"));
        
        String strLine;  
        
        while ((strLine = reader.readLine()) != null)  {  

            Paragraph para =new Paragraph(strLine+"\n",myfont);  
            para.setAlignment(Element.ALIGN_JUSTIFIED);  
            pdfDoc.add(para);  
        }
        
        pdfDoc.close();
        writer.close();
        reader.close();
        
		oldfile.renameTo(new File(file_name));
		
		submit.setDisable(true);
	}
}