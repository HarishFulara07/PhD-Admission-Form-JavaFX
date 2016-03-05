/*
 * @author
 * 
 * Harish Fulara(2014143)
 * Anant Mittal(2014015)
 */

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AdminController implements Initializable{
    
	static private final ObservableList<Person> personData = FXCollections.observableArrayList();
    static private int screen_val = 0;
	
	@FXML 
    private TableView<Person> tableView;
    @FXML 
    private TableColumn<Person,String> ColumnName;
    @FXML 
    private TableColumn<Person,String> ColumnEnrollment;
    @FXML 
    private TableColumn<Person,Boolean> ColumnLink;
    @FXML
    private Button backButton;
    @FXML
    private CheckBox admin_equalsThanGateScore_CheckBox;
    @FXML
    private CheckBox admin_equalsXIIBoardPercentage_CheckBox;

    @FXML
    private CheckBox admin_greaterThanPostGraduationPercentage_CheckBox;

    @FXML
    private ComboBox<String> admin_postGraduationDepartment_ComboBox;

    @FXML
    private Tab admin_tab2selected;

    @FXML
    private ComboBox<String> admin_postDegree_ComboBox;

    @FXML
    private Tab admin_tab1selected;

    @FXML
    private ToggleGroup admin_dob_ToggleGroup;

    @FXML
    private TextField admin_email;

    @FXML
    private ToggleGroup admin_pd_ToggleGroup;

    @FXML
    private CheckBox admin_equalsPostGraduationPercentage_CheckBox;

    @FXML
    private RadioButton admin_dobOn_radioButton;

    @FXML
    private ComboBox<String> admin_classXIIBoard_ComboBox;

    @FXML
    private ComboBox<String> admin_postGraduationState_ComboBox;

    @FXML
    private CheckBox admin_greaterThanGraduationPercentage_CheckBox;

    @FXML
    private CheckBox admin_greaterThanGateScore_CheckBox;

    @FXML
    private Tab admin_tab3selected;

    @FXML
    private TextField admin_postGraduationUniversity_TextField;

    @FXML
    private RadioButton admin_female_radioButton;

    @FXML
    private CheckBox admin_lesserThanPostGraduationPercentage_CheckBox;

    @FXML
    private ComboBox<String> admin_classXBoard_ComboBox;

    @FXML
    private Button admin_filterButton;

    @FXML
    private ComboBox<String> admin_graduationDegree_ComboBox;

    @FXML
    private DatePicker admin_dob_DatePicker;

    @FXML
    private CheckBox admin_greaterThanXBoardPercentage_CheckBox;

    @FXML
    private CheckBox admin_equalsGraduationPercentage_CheckBox;

    @FXML
    private DatePicker admin_applicationDatedFrom_DatePicker;

    @FXML
    private RadioButton admin_pdYes_radioButton;

    @FXML
    private CheckBox admin_lesserThanXBoardPercentage_CheckBox;

    @FXML
    private DatePicker admin_applicationDatedUpto_DatePicker;

    @FXML
    private RadioButton admin_dobafter_radioButton;

    @FXML
    private ComboBox<String> admin_category;

    @FXML
    private ComboBox<String> admin_graduationState_ComboBox;

    @FXML
    private RadioButton admin_male_radioButton;

    @FXML
    private RadioButton admin_pdNo_radioButton;

    @FXML
    private RadioButton admin_dobBefore_radioButton;

    @FXML
    private TextField admin_enrollmentno;

    @FXML
    private ComboBox<String> admin_graduationDepartment_ComboBox;

    @FXML
    private TextField admin_graduationUniversity_TextField;

    @FXML
    private ComboBox<String> admin_phdStream_ComboBox;

    @FXML
    private ToggleGroup admin_gender_ToggleGroup;

    @FXML
    private TextField admin_name;

    @FXML
    private CheckBox admin_equalsXBoardPercentage_CheckBox;

    @FXML
    private CheckBox admin_lesserThanGraduationPercentage_CheckBox;

    @FXML
    private CheckBox admin_lesserThanXIIBoardPercentage_CheckBox;

    @FXML
    private CheckBox admin_greaterThanXIIBoardPercentage_CheckBox;

    @FXML
    private CheckBox admin_lesserThanGateScore_CheckBox;
    
    @FXML
    private TextField admin_XBoardPercentage_TextField;
    @FXML
    private TextField admin_XIIBoardPercentage_TextField;
    @FXML
    private TextField admin_graduationPercentage_TextField;
    @FXML
    private TextField admin_postGraduationPercentage_TextField;
    @FXML
    private TextField admin_gateScore_TextField;
    @FXML
    private Tab admin_tab3;
    @FXML
    private Tab admin_tab2;
    @FXML
    private Tab admin_tab1;
    @FXML
    private Label admin_graduationState_Label;
    @FXML
    private Label tab2_uncheckXBoard;
    @FXML
    private Label tab2_uncheckXIIBoard;
    @FXML
    private Label tab2_uncheckGraduation;
    @FXML
    private Label tab2_uncheckPGGraduation;
    @FXML
    private Label tab2_uncheckGateScore;
    @FXML
    private Label tab2_invalidXBoard;
    @FXML
    private Label tab2_invalidXIIBoard;
    @FXML
    private Label tab2_invalidGraduation;
    @FXML
    private Label tab2_invalidPGGraduation;
    @FXML
    private Label tab2_invalidGateScore;
    @FXML
    private Label admin_dob_errorLabel;
    @FXML
    private Label futureDateError;
    @FXML
    private Label mainError;
    
    @FXML
    void tab1selected(Event e) 
    {   
        
        admin_category.setItems(FXCollections.observableArrayList("General","OBC","SC","ST","Other"));
    }
    
    @FXML
    void tab2selected(Event e)
    {   
        
        admin_phdStream_ComboBox.setItems(FXCollections.observableArrayList("Computer Science","Electronics and Communication","Computational Biology"));
        
	admin_graduationDegree_ComboBox.setItems(FXCollections.observableArrayList("BTech (Bachelor of Technology)","BE (Bachelor of Engineering)","B.Sc (Bachelor of Science)","Other"));
        admin_postDegree_ComboBox.setItems(FXCollections.observableArrayList("MTech (Master of Technology)","ME (Master of Engineering)"
				,"MS (Master of Science)","M.Sc (Master of Science)","Other"));
        admin_classXBoard_ComboBox.setItems(FXCollections.observableArrayList("Andhra Pradesh Board of Intermediate Education",
                                                    "Andhra Pradesh Board of Secondary Education",
                                                    "Board of Higher Secondary Education, Delhi",
                                                    "Assam Board of Secondary Education",
                                                    "Bihar School Examination Board",
                                                    "Board of Youth Education India",
                                                    "Board of School Education, Haryana",
                                                    "Board of Secondary Education, Madhya Pradesh",
                                                    "Board of Secondary Education Madhya Bharat Gwalior",
                                                    "Board of Secondary Education, Rajasthan",
                                                    "Chhattisgarh Board of Secondary Education",
                                                    "Central Board of Secondary Education",
                                                    "Central Board Of Patna, Bihar",
                                                    "Central Board Of Education Ajmer New Delhi",
                                                    "Goa Board of Secondary & Higher Secondary Education",
                                                    "Gujarat Secondary Education Board",
                                                    "Himachal Pradesh Board of School Education",
                                                    "Indian Board of Science Education(not recognized)",
                                                    "Indian Board of School Education",
                                                    "ndian Board of Computer Education",
                                                    "J&K State Board of School Education",
                                                    "Jharkhand Academic Council(not recognized)",
                                                    "Karnataka Board of the Pre-University Education",
                                                    "Karnataka Secondary Education Examination Board",
                                                    "Kerala Board of Public Examinations",
                                                    "Maharashtra State Board of Secondary and Higher Secondary Education",
                                                    "Manipur Board of Secondary Education",
                                                    "Manipur Council of Higher Secondary Education",
                                                    "Meghalaya Board of School Education",
                                                    "Mizoram Board of School Education",
                                                    "Northwest Accreditation Commission",
                                                    "Nagaland Board of School Education",
                                                    "National Institute of Open Schooling",
                                                    "Orissa Board of Secondary Education",
                                                    "Orissa Council of Higher Secondary Education",
                                                    "Punjab School Education Board",
                                                    "Rajasthan Board of Secondary Education",
                                                    "Tamil Nadu Board of Higher Secondary Education",
                                                    "Tamil Nadu Board of Secondary Education",
                                                    "Tamilnadu Council for Open and Distance Learning",
                                                    "Tripura Board of Secondary Education",
                                                    "Telangana Board of Intermediate Education",
                                                    "Telangana Board of Secondary Education",
                                                    "Uttar Pradesh Board of High School and Intermediate Education",
                                                    "Sampurnanand Sanskrit Vishwavidyalaya Varanasi Uttar Pradesh",
                                                    "Uttarakhand Board of School Education",
                                                    "West Bengal Board of Secondary Education",
                                                    "West Bengal Council of Higher Secondary Education",
                                                    "West Bengal State Council of Vocational Education and Training",
                                                    "Board of Secondary Education Kant Shahjahanpur Uttar Pradesh",
                                                    "The West Bengal Council of Rabindra Open Schooling",
                                                    "Institution of Secondary Distance Education (ISDE) Approved by Distance Education Council & Permanent Equivalency granted by MPBSE",
                                                    "Others"));

                                                     
    
    admin_classXIIBoard_ComboBox.setItems(FXCollections.observableArrayList("Andhra Pradesh Board of Intermediate Education",
                                                    "Andhra Pradesh Board of Secondary Education",
                                                    "Board of Higher Secondary Education, Delhi",
                                                    "Assam Board of Secondary Education",
                                                    "Bihar School Examination Board",
                                                    "Board of Youth Education India",
                                                    "Board of School Education, Haryana",
                                                    "Board of Secondary Education, Madhya Pradesh",
                                                    "Board of Secondary Education Madhya Bharat Gwalior",
                                                    "Board of Secondary Education, Rajasthan",
                                                    "Chhattisgarh Board of Secondary Education",
                                                    "Central Board of Secondary Education",
                                                    "Central Board Of Patna, Bihar",
                                                    "Central Board Of Education Ajmer New Delhi",
                                                    "Goa Board of Secondary & Higher Secondary Education",
                                                    "Gujarat Secondary Education Board",
                                                    "Himachal Pradesh Board of School Education",
                                                    "Indian Board of Science Education(not recognized)",
                                                    "Indian Board of School Education",
                                                    "ndian Board of Computer Education",
                                                    "J&K State Board of School Education",
                                                    "Jharkhand Academic Council(not recognized)",
                                                    "Karnataka Board of the Pre-University Education",
                                                    "Karnataka Secondary Education Examination Board",
                                                    "Kerala Board of Public Examinations",
                                                    "Maharashtra State Board of Secondary and Higher Secondary Education",
                                                    "Manipur Board of Secondary Education",
                                                    "Manipur Council of Higher Secondary Education",
                                                    "Meghalaya Board of School Education",
                                                    "Mizoram Board of School Education",
                                                    "Northwest Accreditation Commission",
                                                    "Nagaland Board of School Education",
                                                    "National Institute of Open Schooling",
                                                    "Orissa Board of Secondary Education",
                                                    "Orissa Council of Higher Secondary Education",
                                                    "Punjab School Education Board",
                                                    "Rajasthan Board of Secondary Education",
                                                    "Tamil Nadu Board of Higher Secondary Education",
                                                    "Tamil Nadu Board of Secondary Education",
                                                    "Tamilnadu Council for Open and Distance Learning",
                                                    "Tripura Board of Secondary Education",
                                                    "Telangana Board of Intermediate Education",
                                                    "Telangana Board of Secondary Education",
                                                    "Uttar Pradesh Board of High School and Intermediate Education",
                                                    "Sampurnanand Sanskrit Vishwavidyalaya Varanasi Uttar Pradesh",
                                                    "Uttarakhand Board of School Education",
                                                    "West Bengal Board of Secondary Education",
                                                    "West Bengal Council of Higher Secondary Education",
                                                    "West Bengal State Council of Vocational Education and Training",
                                                    "Board of Secondary Education Kant Shahjahanpur Uttar Pradesh",
                                                    "The West Bengal Council of Rabindra Open Schooling",
                                                    "Institution of Secondary Distance Education (ISDE) Approved by Distance Education Council & Permanent Equivalency granted by MPBSE",
                                                    "Others"));
    
    admin_graduationDepartment_ComboBox.setItems(FXCollections.observableArrayList("Computer Science","Information Technology","Electronic and Communication","Electrical"
			,"Electronics and Electrical","Other"));
    admin_postGraduationDepartment_ComboBox.setItems(FXCollections.observableArrayList("Computer Science","Information Technology","Electronic and Communication","Electrical"
			,"Electronics and Electrical","Other"));
    admin_graduationState_ComboBox.setItems(FXCollections.observableArrayList("Andaman and Nicobar Islands","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chhattisgarh"
				,"Dadra and Nagar Haveli","Daman and Diu","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Lakshadweep"
				,"Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","New Delhi","Orissa","Punjab"
				,"Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"
				,"Puducherry"));
    admin_postGraduationState_ComboBox.setItems(FXCollections.observableArrayList("Andaman and Nicobar Islands","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chhattisgarh"
				,"Dadra and Nagar Haveli","Daman and Diu","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Lakshadweep"
				,"Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","New Delhi","Orissa","Punjab"
				,"Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"
				,"Puducherry"));

        
    //searching result for phd treams
    admin_phdStream_ComboBox.setOnKeyReleased(new EventHandler<KeyEvent>()
    {
        @Override   
        public void handle(KeyEvent event)
        {
        String s = jumpTo(event.getText(),admin_phdStream_ComboBox.getValue(),admin_phdStream_ComboBox.getItems());
        if (s != null) 
           {
            admin_phdStream_ComboBox.setValue(s);
            
            }
        }
    });
    
    
    
    
    admin_classXBoard_ComboBox.setOnKeyReleased((KeyEvent event1) -> {
        String s = jumpTo(event1.getText(), admin_classXBoard_ComboBox.getValue(), admin_classXBoard_ComboBox.getItems());
        if (s != null) 
        {
        	admin_classXBoard_ComboBox.setValue(s);
            
        }
    });
    
    
    admin_classXIIBoard_ComboBox.setOnKeyReleased((KeyEvent event1) -> {
        String s = jumpTo(event1.getText(), admin_classXIIBoard_ComboBox.getValue(), admin_classXIIBoard_ComboBox.getItems());
        if (s != null) 
        {
        	admin_classXIIBoard_ComboBox.setValue(s);
            
        }
    });
    
    
    admin_graduationDegree_ComboBox.setOnKeyReleased((KeyEvent event1) -> {
        String s = jumpTo(event1.getText(), admin_graduationDegree_ComboBox.getValue(), admin_graduationDegree_ComboBox.getItems());
        if (s != null) 
        {
        	admin_graduationDegree_ComboBox.setValue(s);
            
        }
    });
    
    
    admin_graduationDepartment_ComboBox.setOnKeyReleased((KeyEvent event1) -> {
        String s = jumpTo(event1.getText(), admin_graduationDepartment_ComboBox.getValue(), admin_graduationDepartment_ComboBox.getItems());
        if (s != null) 
        {
        	admin_graduationDepartment_ComboBox.setValue(s);
            
        }
    });
    
    
    admin_graduationState_ComboBox.setOnKeyReleased((KeyEvent event1) -> {
        String s = jumpTo(event1.getText(), admin_graduationState_ComboBox.getValue(), admin_graduationState_ComboBox.getItems());
        if (s != null) 
        {
        	admin_graduationState_ComboBox.setValue(s);
            
        }
    });
    
    
    admin_postDegree_ComboBox.setOnKeyReleased((KeyEvent event1) -> {
        String s = jumpTo(event1.getText(), admin_postDegree_ComboBox.getValue(), admin_postDegree_ComboBox.getItems());
        if (s != null) 
        {
        	admin_postDegree_ComboBox.setValue(s);
            
        }
    });
    
    
    admin_postGraduationDepartment_ComboBox.setOnKeyReleased((KeyEvent event1) -> {
        String s = jumpTo(event1.getText(), admin_postGraduationDepartment_ComboBox.getValue(), admin_postGraduationDepartment_ComboBox.getItems());
        if (s != null) 
        {
        	admin_postGraduationDepartment_ComboBox.setValue(s);
            
        }
    });
    
    
    admin_postGraduationState_ComboBox.setOnKeyReleased((KeyEvent event1) -> {
        String s = jumpTo(event1.getText(), admin_postGraduationState_ComboBox.getValue(), admin_postGraduationState_ComboBox.getItems());
        if (s != null) 
        {
        	admin_postGraduationState_ComboBox.setValue(s);
            
        }
    });
    
    
    
    
    
    
    
}
    
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
    void tab3selected(Event event) throws IOException
    {
       
    }
    
    @FXML
    public void goBack(ActionEvent event) throws IOException
    {
        System.out.println("Data has been filtered and added to the table");
            Stage table_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Parent table_parent=FXMLLoader.load(getClass().getResource("project.fxml"));
            Scene table_scene=new Scene(table_parent);
            table_stage.setScene(table_scene);
            table_stage.show();
            personData.removeAll(personData);
    }
    
    int flag1 = 0;
    int flag2 = 0;
    int flag3 = 0;
    int flag8 = 0;
    int flag5 = 0;
    int flag6 = 0;
    
    void firstCheckForInvalidInput()
    {   
        
        if((admin_dobafter_radioButton.isSelected() == true ||admin_dobBefore_radioButton.isSelected() == true || admin_dobOn_radioButton.isSelected() == true) && (admin_dob_DatePicker.getValue()) !=null)
        {   
        }
        else if((admin_dobafter_radioButton.isSelected() == false && admin_dobBefore_radioButton.isSelected() == false && admin_dobOn_radioButton.isSelected() == false) && (admin_dob_DatePicker.getValue()) ==null)
        {
        }
        else
        {
            flag1 = 1;
            mainError.setVisible(true);
            admin_dob_errorLabel.setVisible(true);
        }
        
        if(((admin_equalsXBoardPercentage_CheckBox.isSelected() || admin_greaterThanXBoardPercentage_CheckBox.isSelected() || admin_lesserThanXBoardPercentage_CheckBox.isSelected())) && ((!admin_XBoardPercentage_TextField.getText().equals(""))))
        {
                Double per=Double.parseDouble(admin_XBoardPercentage_TextField.getText());
                if(0>=per || per>=100)
                {  
                    flag2 = 1;
                    mainError.setVisible(true);
                    tab2_invalidXBoard.setVisible(true);
                }
            
        }
        else if(((!admin_equalsXBoardPercentage_CheckBox.isSelected() && !admin_greaterThanXBoardPercentage_CheckBox.isSelected() && !admin_lesserThanXBoardPercentage_CheckBox.isSelected())) && ((admin_XBoardPercentage_TextField.getText().equals(""))))
        {
        }
        else
        {    
               flag2 = 1;
               mainError.setVisible(true);
               tab2_uncheckXBoard.setVisible(true);
        }
        
        if(((admin_equalsXIIBoardPercentage_CheckBox.isSelected() || admin_greaterThanXIIBoardPercentage_CheckBox.isSelected() || admin_lesserThanXIIBoardPercentage_CheckBox.isSelected())) && ((!admin_XIIBoardPercentage_TextField.getText().equals(""))))
        {
            //error
            
                Double per=Double.parseDouble(admin_XIIBoardPercentage_TextField.getText());
                if(0>=per || per>=100)
                {
                    flag3 = 1;
                    mainError.setVisible(true);
                    tab2_invalidXIIBoard.setVisible(true);
                }   
        }
        else if(((!admin_equalsXIIBoardPercentage_CheckBox.isSelected() && !admin_greaterThanXIIBoardPercentage_CheckBox.isSelected() && !admin_lesserThanXIIBoardPercentage_CheckBox.isSelected())) && ((admin_XIIBoardPercentage_TextField.getText().equals(""))))
        {
            
        }
        else
        {
            flag3 = 1;
               mainError.setVisible(true);
               tab2_uncheckXIIBoard.setVisible(true);
        }
        
        if(((admin_equalsGraduationPercentage_CheckBox.isSelected()||admin_greaterThanGraduationPercentage_CheckBox.isSelected()||admin_lesserThanGraduationPercentage_CheckBox.isSelected())) && ((!admin_graduationPercentage_TextField.getText().equals(""))))
        {
            //error
            
                Double per=Double.parseDouble(admin_graduationPercentage_TextField.getText());
                if(0>=per || per>=100)
                {   
                    flag8 = 1;
                    mainError.setVisible(true);
                    tab2_invalidGraduation.setVisible(true);
                }
                
        }
        else if(((!admin_equalsGraduationPercentage_CheckBox.isSelected()&&!admin_greaterThanGraduationPercentage_CheckBox.isSelected()&&!admin_lesserThanGraduationPercentage_CheckBox.isSelected())) && ((admin_graduationPercentage_TextField.getText().equals(""))))
        {
            
        }
         else
                {  
                    flag8 = 1;
                    mainError.setVisible(true);
                    tab2_uncheckGraduation.setVisible(true);
                }   
        
        if(((admin_equalsPostGraduationPercentage_CheckBox.isSelected()||admin_greaterThanPostGraduationPercentage_CheckBox.isSelected()||admin_lesserThanPostGraduationPercentage_CheckBox.isSelected())) && ((!admin_postGraduationPercentage_TextField.getText().equals(""))))
        {
            //error
            
              Double per=Double.parseDouble(admin_postGraduationPercentage_TextField.getText());
              
                if(0 >=per || per>=100.00)
                {
                    flag5 = 1;
                    mainError.setVisible(true);
                    tab2_invalidPGGraduation.setVisible(true);
                }
                
            
            
        }
        else if(((!admin_equalsPostGraduationPercentage_CheckBox.isSelected()&&!admin_greaterThanPostGraduationPercentage_CheckBox.isSelected()&&!admin_lesserThanPostGraduationPercentage_CheckBox.isSelected())) && ((admin_postGraduationPercentage_TextField.getText().equals(""))))
        {
            
        }
        else
        {
            flag5 = 1;
                    mainError.setVisible(true);
                    tab2_uncheckPGGraduation.setVisible(true);
        }
        
        if(((admin_equalsThanGateScore_CheckBox.isSelected()||admin_greaterThanGateScore_CheckBox.isSelected()||admin_lesserThanGateScore_CheckBox.isSelected()))&&((!admin_gateScore_TextField.getText().equals(""))))
        {
            //error
            
            
             Double per=Double.parseDouble(admin_gateScore_TextField.getText());
                if(0>=per || per>=100)
                {
                    flag6 = 1;
                    mainError.setVisible(true);
                    tab2_invalidGateScore.setVisible(true);
                }
                
            
            
        }
        else if(((!admin_equalsThanGateScore_CheckBox.isSelected()&&!admin_greaterThanGateScore_CheckBox.isSelected()&&!admin_lesserThanGateScore_CheckBox.isSelected()))&&((admin_gateScore_TextField.getText().equals(""))))
        {
            
        }
        else
                {
                    flag6 = 1;
                    mainError.setVisible(true); 
                    tab2_uncheckGateScore.setVisible(true);
                }
        
    }
    
    void removeError()
    {   
        flag1 = 0;
        flag2 = 0;
        flag3 = 0;
        flag8 = 0;
        flag5 = 0;
        flag6 = 0;
        mainError.setVisible(false);
        admin_dob_errorLabel.setVisible(false);
        tab2_uncheckXBoard.setVisible(false);
        tab2_uncheckXIIBoard.setVisible(false);
        tab2_uncheckGraduation.setVisible(false);
        tab2_uncheckPGGraduation.setVisible(false);
        tab2_uncheckGateScore.setVisible(false);
        tab2_invalidXBoard.setVisible(false);
        tab2_invalidXIIBoard.setVisible(false);
        tab2_invalidGraduation.setVisible(false);
        tab2_invalidPGGraduation.setVisible(false);
        tab2_invalidGateScore.setVisible(false);
    }
    
    @FXML               
    void filterResult(ActionEvent event) throws FileNotFoundException, IOException 
    {   
        //sanity checks
        
    	removeError();
        firstCheckForInvalidInput();
        
        if(flag1 == 1 || flag2 == 1 || flag3 == 1  || flag5 == 1 || flag6 == 1 || flag8 == 1)
        {
            return;
        }
        
        if(admin_dob_ToggleGroup.getSelectedToggle()!=null && admin_dob_DatePicker.getValue()==null)
        {   
            System.err.println("error");
            admin_dob_errorLabel.setVisible(true);
            admin_dob_DatePicker.requestFocus();
            
        }
        
        boolean flagEmail=false;
        boolean flagName=false;
        boolean flagEnrollmentNumber=false;
        boolean flagCategory=false;
        boolean flagGender=false;
        boolean flagPhysicallyDisabled=false;
        boolean flagDOB=false;
        boolean flagPhdstream=false;
        boolean flagGraduationDegree=false;
        boolean flagPostGraduationDegree=false;
        boolean flagXBoard=false;
        boolean flagXIIBoard=false;
        boolean flagGraduationDepartment=false;
        boolean flagPostGraduationDepartment=false;
        boolean flagGraduationUniversity=false;
        boolean flagPostGraduationUniversity=false;
        boolean flagGraduationState=false;
        boolean flagPostGraduationState=false;
        boolean flagXpercentage=false;
        boolean flagXIIpercentage=false;
        boolean flagGraduationPercentage=false;
        boolean flagPostGraduationPercentage=false;
        boolean flagGATEScore=false;
        boolean flagtime1 = false;
        boolean flagtime2 = false;
        
        //TextField
        if(!admin_email.getText().equals(""))
        {
            flagEmail=true;
        }
        if(!admin_enrollmentno.getText().equals(""))
        {
            flagEnrollmentNumber=true;
        }
        if(!admin_name.getText().equals(""))
        {
            flagName=true;
        }
        if(!admin_graduationUniversity_TextField.getText().equals(""))
        {
            flagGraduationUniversity=true;
        }
        if(!admin_postGraduationUniversity_TextField.getText().equals(""))
        {
            flagPostGraduationUniversity=true;
        }
        
        //RadioButtons
        if(admin_gender_ToggleGroup.getSelectedToggle()!=null)
        {
            flagGender=true;
        }
        if(admin_dob_ToggleGroup.getSelectedToggle()!=null && admin_dob_DatePicker.getValue()!=null)
        {
            flagDOB=true;
        }
        if(admin_pd_ToggleGroup.getSelectedToggle()!=null)
        {
            flagPhysicallyDisabled=true;
        }
        
        
        if(admin_category.getValue()!=null)
        {
            flagCategory=true;
        }
        if(admin_classXBoard_ComboBox.getValue()!=null)
        {
            flagXBoard=true;
        }
        if(admin_classXIIBoard_ComboBox.getValue()!=null)
        {
            flagXIIBoard=true;
        }
        if(admin_graduationDegree_ComboBox.getValue()!=null)
        {
            flagGraduationDegree=true;
        }
        if(admin_graduationDepartment_ComboBox.getValue()!=null)
        {
            flagGraduationDepartment=true;
        }
        if(admin_postDegree_ComboBox.getValue()!=null)
        {
            flagPostGraduationDegree=true;
        }
        if(admin_phdStream_ComboBox.getValue()!=null)
        {
            flagPhdstream=true;
        }
        if(admin_postGraduationDepartment_ComboBox.getValue()!=null)
        {
            flagPostGraduationDepartment=true;
        }
        if(admin_postGraduationState_ComboBox.getValue() != null)
        {
            flagPostGraduationState=true;
        }
        if(admin_graduationState_ComboBox.getValue() != null)
        {
        	flagGraduationState = true;
        }
        
        //Checkbox
        if((admin_equalsGraduationPercentage_CheckBox.isSelected()==true || admin_greaterThanGraduationPercentage_CheckBox.isSelected()==true || admin_lesserThanGraduationPercentage_CheckBox.isSelected()==true)&& (!admin_graduationPercentage_TextField.getText().equals("")))
        {
            flagGraduationPercentage=true;
        }
        if((admin_equalsXBoardPercentage_CheckBox.isSelected()==true || admin_greaterThanXBoardPercentage_CheckBox.isSelected()==true || admin_lesserThanXBoardPercentage_CheckBox.isSelected()==true)&& (!admin_XBoardPercentage_TextField.getText().equals("")))
        {
            flagXpercentage=true;
        }
        if((admin_equalsXIIBoardPercentage_CheckBox.isSelected()==true || admin_greaterThanXIIBoardPercentage_CheckBox.isSelected()==true || admin_lesserThanXIIBoardPercentage_CheckBox.isSelected()==true)&& (!admin_XIIBoardPercentage_TextField.getText().equals("")))
        {
            flagXIIpercentage=true;
        }
        if((admin_equalsPostGraduationPercentage_CheckBox.isSelected()==true || admin_greaterThanPostGraduationPercentage_CheckBox.isSelected()==true || admin_lesserThanPostGraduationPercentage_CheckBox.isSelected()==true)&& (!admin_postGraduationPercentage_TextField.getText().equals("")))
        {
            flagPostGraduationPercentage=true;
        }
        if((admin_equalsThanGateScore_CheckBox.isSelected()==true || admin_greaterThanGateScore_CheckBox.isSelected()==true || admin_lesserThanGateScore_CheckBox.isSelected()==true)&& (!admin_gateScore_TextField.getText().equals("")))
        {
            flagGATEScore=true;
        }
        if(admin_applicationDatedFrom_DatePicker.getValue() != null)
        {
        	flagtime1 = true;
        	
        }
        if(admin_applicationDatedUpto_DatePicker.getValue() != null)
        {
        	flagtime2 = true;
        }
       
        int num;
        try (BufferedReader myreader = new BufferedReader(new FileReader("./src/Applicant/eno.txt"))) {
            num = Integer.valueOf(myreader.readLine());
        }
        int i=0;
        for(i=1;i<=num;i++)
        {   
            try
            {   
                String name = "./src/Applicant/PhD2015" + String.valueOf(i) + ".txt";
                String fileEmail;
                String fileName;                
                String fileStream;                 
                String fileGender;               
                String fileCategory;               
                String filePD;             
                String[] dobParts;                   
                String filexBoard;   
                String filexPercentage;                   
                String filexiiBoard;
                String filexiiPercentage;                  
                String fileGraduationDegree;
                String fileGraduationDiscipline;      
                String fileGraduationUniversity;  
                String fileGraduationPercentage;
                String fileGraduationState;
                String filePgState;       
                String filePgDegree;  
                String filePgPercentage;   
                String filePgCollege;
                String fileGatescore;
                String filePgDiscipline;
                String filetime;
                
                try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
                    
                    fileEmail = reader.readLine(); //email read
                    fileName = reader.readLine(); //name read
                    reader.readLine();                                 //skipping address
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();                                 //skipping mobile
                    fileStream = reader.readLine(); //read PhDStream
                    reader.readLine();                                 //skipping pref1
                    reader.readLine();                                 //skipping pref2
                    reader.readLine();                                 //skipping pref3
                    fileGender = reader.readLine(); //gender read
                    fileCategory = reader.readLine(); //category read
                    filePD = reader.readLine(); //pd read
                    dobParts = reader.readLine().split("/"); //dob read
                    reader.readLine();                                 //skip war
                    reader.readLine();                                 //skip father's name
                    reader.readLine();                                 //skip nationality
                    reader.readLine();                                 //skip address
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();                                 //skip pincode
                    filexBoard = reader.readLine(); //read xboard
                    filexPercentage = reader.readLine();
                    reader.readLine();                                  //skip x year
                    filexiiBoard = reader.readLine(); //read 12 board
                    filexiiPercentage = reader.readLine(); // read percanetage
                    reader.readLine();                                  //skip xii year
                    fileGraduationDegree = reader.readLine(); //read graduation degree
                    fileGraduationDiscipline = reader.readLine(); //read graduation discipline
                    reader.readLine();                                  //skip college name
                    fileGraduationUniversity = reader.readLine(); //read graduation University
                    reader.readLine();                                  //skip collge city
                    fileGraduationState=reader.readLine();       //graduation state
                    reader.readLine();                                  //skip graduation year
                    fileGraduationPercentage = reader.readLine(); //read percentage
                    reader.readLine();                                  //skip ece preferences
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();                                  //skip ece prefernces
                    filePgCollege=reader.readLine();             // not skip pg college
                    reader.readLine();                                  //skip pg city
                    filePgState = reader.readLine(); //read pg state
                    filePgDiscipline=reader.readLine();          //pg discipline
                    filePgDegree = reader.readLine(); //pg degree
                    reader.readLine();                                  //skip pg thesis
                    reader.readLine();                                  //skip pg year
                    filePgPercentage = reader.readLine(); //pg percentage
                    reader.readLine();                                  //skip other exams details
                    reader.readLine();                                  //skip other exams details
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();                                  //skipped other exams details
                    reader.readLine();                                  //skip gate area
                    reader.readLine();                                  //skip gate year
                    reader.readLine();                                  //skip gate mark
                    fileGatescore=reader.readLine();             //read gate score
                    reader.readLine();
                    reader.readLine();
                    String[] timer = reader.readLine().split(" ");
                    filetime = timer[0];
                    reader.close();
                } 
                
                if(flagEmail)
                {          
                           if(admin_email.getText().toLowerCase().equals(fileEmail.toLowerCase()))
                           {
                           }
                           else
                           {
                               continue;
                           }
                }
                if(flagName)
                {           
                   if(admin_name.getText().toLowerCase().equals(fileName.toLowerCase())) 
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagEnrollmentNumber)
                    {         System.err.println("roll check");
                   if(admin_enrollmentno.getText().toLowerCase().equals(("PhD2015" + String.valueOf(i)).toLowerCase())) 
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagGraduationUniversity )
                    {         System.err.println("graduation uni check");
                   if(admin_graduationUniversity_TextField.getText().toLowerCase().equals(fileGraduationUniversity.toLowerCase())) 
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagPostGraduationUniversity)
                    {             System.err.println("pg uni check");
                   if(admin_postGraduationUniversity_TextField.getText().toLowerCase().equals(filePgCollege.toLowerCase())) 
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagGender)
                    {            System.err.println("gender check");
                   if(admin_male_radioButton.isSelected() && fileGender.toLowerCase().equals("male")) 
                   {
                   }
                   else if(admin_female_radioButton.isSelected() && fileGender.toLowerCase().equals("female")) 
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagDOB)
                {   System.err.println("dob check");
                    LocalDate date;
                   date=admin_dob_DatePicker.getValue();
                   System.err.println(dobParts[0]+" "+dobParts[1]+" "+dobParts[2]+" ");
                   int month=Integer.parseInt(dobParts[0]);
                   int day=Integer.parseInt(dobParts[1]);
                   int year=Integer.parseInt(dobParts[2]);
                   
                   if(admin_dobBefore_radioButton.isSelected() && date.getYear()>=year)
                   {   
                    if(date.getYear() == year)
                    {
                       if(date.getMonthValue()>=month)
                       {   
                            if(date.getMonthValue() == month)
                            {
                                if(date.getDayOfMonth()>=day)
                                {
                                    
                                }
                                else
                                {
                                    continue;
                                }
                            }
                       }
                       else
                       {
                           continue;
                       }
                    }
                   }
                   else if(admin_dobafter_radioButton.isSelected() && date.getYear()<=year)
                   {
                       if(date.getYear() == year)
                    {
                       if(date.getMonthValue()<=month)
                       {   
                            if(date.getMonthValue() == month)
                            {
                                if(date.getDayOfMonth()<=day)
                                {
                                    
                                }
                                else
                                {
                                    continue;
                                }
                            }
                       }
                       else
                       {
                           continue;
                       }
                    }
                   }
                   
                   else if(admin_dobOn_radioButton.isSelected() && date.getDayOfMonth()==day && date.getMonthValue()==month && date.getYear()==year)
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagPhysicallyDisabled)
                {              System.err.println("pd check");
                   if(admin_pdYes_radioButton.isSelected() && filePD.toLowerCase().equals(("Y").toLowerCase()))    //lasttime it was error prone
                   {}
                   else if(admin_pdNo_radioButton.isSelected() && filePD.toLowerCase().equals(("N").toLowerCase()))
                   {}
                   else
                   {
                       continue;
                   }
                }
                if(flagCategory)
                {
                   if(admin_category.getValue().toLowerCase().equals(fileCategory.toLowerCase())) 
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagXBoard)
                {
                   if(admin_classXBoard_ComboBox.getValue().toLowerCase().equals(filexBoard.toLowerCase()))
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagXIIBoard)
                {
                   if(admin_classXIIBoard_ComboBox.getValue().toLowerCase().equals(filexiiBoard.toLowerCase()))
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagGraduationDegree)
                {
                   if(admin_graduationDegree_ComboBox.getValue().toLowerCase().equals(fileGraduationDegree.toLowerCase()))
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagGraduationDepartment)
                {
                   if(admin_graduationDepartment_ComboBox.getValue().toLowerCase().equals(fileGraduationDiscipline.toLowerCase()))
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagPostGraduationDegree)
                {
                   if(admin_postDegree_ComboBox.getValue().toLowerCase().equals(filePgDegree.toLowerCase()))
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagPhdstream)
                {
                   if(admin_phdStream_ComboBox.getValue().toLowerCase().equals(fileStream.toLowerCase()))
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagPostGraduationDepartment)
                {
                   if(admin_postGraduationDepartment_ComboBox.getValue().toLowerCase().equals(filePgDiscipline.toLowerCase()))
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                if(flagPostGraduationState)
                {
                   if(admin_postGraduationState_ComboBox.getValue().toLowerCase().equals(filePgState.toLowerCase()))
                   {
                   }
                   else
                   {
                       continue;
                   }
                }
                 if(flagGraduationPercentage)
                {  
                	 
  
                   if(admin_equalsGraduationPercentage_CheckBox.isSelected()==true && Double.parseDouble(admin_graduationPercentage_TextField.getText())==Double.parseDouble(fileGraduationPercentage))
                   {}
                   else if(admin_lesserThanGraduationPercentage_CheckBox.isSelected()==true && Double.parseDouble(admin_graduationPercentage_TextField.getText())> Double.parseDouble(fileGraduationPercentage))
                   {}
                   else if(admin_greaterThanGraduationPercentage_CheckBox.isSelected()==true && Double.parseDouble(admin_graduationPercentage_TextField.getText())<Double.parseDouble(fileGraduationPercentage))
                   {}
                   else
                   {
                       continue;
                   }
                }
                if(flagXpercentage)
                {  
                   if(admin_equalsXBoardPercentage_CheckBox.isSelected()==true && Double.parseDouble(admin_XBoardPercentage_TextField.getText())==Double.parseDouble(filexPercentage))
                   {}
                   else if(admin_lesserThanXBoardPercentage_CheckBox.isSelected()==true && Double.parseDouble(admin_XBoardPercentage_TextField.getText())>Double.parseDouble(filexPercentage))
                   {}
                   else if(admin_greaterThanXBoardPercentage_CheckBox.isSelected()==true && Double.parseDouble(admin_XBoardPercentage_TextField.getText())<Double.parseDouble(filexPercentage))
                   {}
                   else
                   {
                       continue;
                   }
                }
                if(flagXIIpercentage)
                {  
                   if(admin_equalsXIIBoardPercentage_CheckBox.isSelected()==true && Double.parseDouble(admin_XIIBoardPercentage_TextField.getText())==Double.parseDouble(filexiiPercentage))
                   {}
                   else if(admin_lesserThanXIIBoardPercentage_CheckBox.isSelected()==true && Double.parseDouble(admin_XIIBoardPercentage_TextField.getText())>Double.parseDouble(filexiiPercentage))
                   {}
                   else if(admin_greaterThanXIIBoardPercentage_CheckBox.isSelected()==true && Double.parseDouble(admin_XIIBoardPercentage_TextField.getText())<Double.parseDouble(filexiiPercentage))
                   {}
                   else
                   {
                       continue;
                   }
                }
                if(flagPostGraduationPercentage)
                {  
                   if(admin_equalsPostGraduationPercentage_CheckBox.isSelected()==true && Double.parseDouble(admin_postGraduationPercentage_TextField.getText())==Double.parseDouble(filePgPercentage))
                   {}
                   else if(admin_lesserThanPostGraduationPercentage_CheckBox.isSelected()==true && Double.parseDouble(admin_postGraduationPercentage_TextField.getText())>Double.parseDouble(filePgPercentage))
                   {}
                   else if(admin_greaterThanPostGraduationPercentage_CheckBox.isSelected()==true && Double.parseDouble(admin_postGraduationPercentage_TextField.getText())<Double.parseDouble(filePgPercentage))
                   {}
                   else
                   {
                       continue;
                   }
                }
                if(flagGATEScore)
                {  
                   if(admin_equalsThanGateScore_CheckBox.isSelected()==true && Double.parseDouble(admin_gateScore_TextField.getText())==Double.parseDouble(fileGatescore))
                   {}
                   else if(admin_lesserThanGateScore_CheckBox.isSelected()==true && Double.parseDouble(admin_gateScore_TextField.getText())>Double.parseDouble(fileGatescore))
                   {}
                   else if(admin_greaterThanGateScore_CheckBox.isSelected()==true && Double.parseDouble(admin_gateScore_TextField.getText())<Double.parseDouble(fileGatescore))
                   {}
                   else
                   {
                       continue;
                   }
                }
                if(flagGraduationState)
                {
                	if(admin_graduationState_ComboBox.getValue().toLowerCase().equals(fileGraduationState.toLowerCase()))
                    {
                    }
                    else
                    {
                        continue;
                    }
                }
                
                
                if(flagtime1)
                {
                	LocalDate date = admin_applicationDatedFrom_DatePicker.getValue();
                	int year1 = date.getYear();
                	int month1 = date.getMonthValue();
                	int day1 = date.getDayOfMonth(); 
                	String[] timer = filetime.split("-");
                	int year2 = Integer.valueOf(timer[2]);
                	int month2 = Integer.valueOf(timer[0]);
                	int day2 = Integer.valueOf(timer[1]);
                	
                	if(year2 >= year1)
                	{
                		if(year2 == year1)
                		{
                			if(month2 >= month1)
                			{
                				if(month2 == month1)
                				{
                					if(day2 >= day1)
                					{
                						
                					}
                					else
                					{
                						continue;
                					}
                				}
                			}
                			else
                			{
                				continue;
                			}
                		}
                	}
                	else
                	{
                		continue;
                	}
                }
                if(flagtime2)
                {
                	LocalDate date = admin_applicationDatedUpto_DatePicker.getValue();
                	int year1 = date.getYear();
                	int month1 = date.getMonthValue();
                	int day1 = date.getDayOfMonth(); 
                	String[] timer = filetime.split("-");
                	int year2 = Integer.valueOf(timer[2]);
                	int month2 = Integer.valueOf(timer[0]);
                	int day2 = Integer.valueOf(timer[1]);
                	
                	if(year2 <= year1)
                	{
                		if(year2 == year1)
                		{
                			if(month2 <= month1)
                			{
                				if(month2 == month1)
                				{
                					if(day2 <= day1)
                					{
                						
                					}
                					else
                					{
                						continue;
                					}
                				}
                			}
                			else
                			{
                				continue;
                			}
                		}
                	}
                	else
                	{
                		continue;
                	}
                }
                
                Person p=new Person(fileName,"PhD2015" + String.valueOf(i),"PhD2015" + String.valueOf(i)+".doc");
                personData.add(p);
                
            } 
            catch(FileNotFoundException e)
            {
            }
            catch(IOException e)
            {
            }
            
            
            
    }
        	screen_val = 1;
            Stage table_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Parent table_parent=FXMLLoader.load(getClass().getResource("adminTable.fxml"));
            Scene table_scene=new Scene(table_parent);
            table_stage.setScene(table_scene);
            table_stage.show();
}

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {  
		if(screen_val == 1)
    	{
    		try
    		{
    			screen_val = 0;
    			tableView.setItems(personData);
    			ColumnName.setCellValueFactory(cellData -> cellData.getValue().firstColumnProperty());
    			ColumnEnrollment.setCellValueFactory(cellData -> cellData.getValue().secondColumnProperty());
    			tableView.setRowFactory( tv -> {
    			TableRow<Person> row = new TableRow<>();
    			row.setOnMouseClicked(event -> {
    				if (event.getClickCount() >= 1 && (! row.isEmpty()) ) 
    				{
    					Person rowData = row.getItem();
    					String file_name = "./src/Applicant/" + rowData.getenrollmentNumber() + ".pdf";
    					File file = new File(file_name);
    					try 
    					{
    						Desktop.getDesktop().open(file);
    					}	
    					catch (IOException e) 
    					{
    						e.printStackTrace();
    					}
    				}
            		});
            		return row ;
    			});
    		}
    		catch(NullPointerException e)
    		{
    			e.printStackTrace();
    		}
    	}
    }
}